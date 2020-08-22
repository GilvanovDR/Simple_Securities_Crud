package ru.GilvanovDR.service;

import org.springframework.stereotype.Service;
import ru.GilvanovDR.repository.HistoryRepository;
import ru.GilvanovDR.repository.SecuritiesRepository;
import ru.GilvanovDR.util.ObjectUtils;
import ru.GilvanovDR.util.XMLMapper;

import java.io.IOException;

@Service
public class DbLoader {
    private HistoryRepository historyRepository;
    private SecuritiesRepository securitiesRepository;
    private XMLMapper XMLMapper;

    public DbLoader(HistoryRepository historyRepository, SecuritiesRepository securitiesRepository, XMLMapper XMLMapper) {
        this.historyRepository = historyRepository;
        this.securitiesRepository = securitiesRepository;
        this.XMLMapper = XMLMapper;
    }

    public int SecToDb(String fileName) throws IOException {
        return securitiesRepository
                .saveAll(ObjectUtils.getSecurities(XMLMapper.XmlToSecurity(fileName)));
    }

    public int HisToDb(String fileName) throws IOException {
        return historyRepository.saveAll(ObjectUtils.getHistory(XMLMapper.XmlToHistory(fileName)));
    }


}
