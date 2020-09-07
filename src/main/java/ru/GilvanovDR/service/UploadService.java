package ru.GilvanovDR.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.GilvanovDR.model.jaxb.XmlHistory;
import ru.GilvanovDR.model.jaxb.XmlSecurity;
import ru.GilvanovDR.repository.HistoryRepository;
import ru.GilvanovDR.repository.SecuritiesRepository;
import ru.GilvanovDR.util.ObjectUtils;
import ru.GilvanovDR.util.XMLMapper;
import ru.GilvanovDR.util.exception.NotFoundException;

import javax.xml.transform.stream.StreamSource;
import java.util.List;

@Service
public class UploadService {
    private static final Logger log = LoggerFactory.getLogger(UploadService.class);
    private final XMLMapper xmlMapper;
    private final HistoryRepository historyRepository;
    private final SecuritiesRepository securitiesRepository;

    public UploadService(XMLMapper xmlMapper, HistoryRepository historyRepository, SecuritiesRepository securitiesRepository) {
        this.xmlMapper = xmlMapper;
        this.historyRepository = historyRepository;
        this.securitiesRepository = securitiesRepository;
    }

    public int uploadFile(MultipartFile file) {

        try {
            List<XmlSecurity> xmlSecurityList = xmlMapper.streamToSecurity(new StreamSource(file.getInputStream()));
            log.debug("Securities count from file {}", xmlSecurityList.size());
            List<XmlHistory> xmlHistoryList = xmlMapper.streamToHistory(new StreamSource(file.getInputStream()));
            log.debug("Histories count from file {}", xmlHistoryList.size());
            if (xmlSecurityList.size() > 0 && xmlSecurityList.get(0).getSecId() != null) {
                return securitiesRepository.saveAll(ObjectUtils.getSecurities(xmlSecurityList));
            }
            if (xmlHistoryList.size() > 1 && xmlHistoryList.get(0).getSecId() != null) {
                return historyRepository.saveAll(ObjectUtils.getHistory(xmlHistoryList));
            }
        } catch (Exception e) {
            throw new NotFoundException("Wrong uploaded file " + e);
        }
        return 0;
    }
}
