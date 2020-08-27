package ru.GilvanovDR.service;

import org.springframework.stereotype.Service;
import ru.GilvanovDR.repository.HistoryRepository;
import ru.GilvanovDR.repository.SecuritiesRepository;
import ru.GilvanovDR.util.ObjectUtils;
import ru.GilvanovDR.util.XMLMapper;

@Service
public class DbUploader {
    private final HistoryRepository historyRepository;
    private final SecuritiesRepository securitiesRepository;
    private final XMLMapper xmlMapper;

    public DbUploader(HistoryRepository historyRepository, SecuritiesRepository securitiesRepository, XMLMapper xmlMapper) {
        this.historyRepository = historyRepository;
        this.securitiesRepository = securitiesRepository;
        this.xmlMapper = xmlMapper;
    }

    public int secToDb(String fileName) {
        return securitiesRepository
                .saveAll(ObjectUtils.getSecurities(xmlMapper.fileToSecurity(fileName)));
    }

    public int hisToDb(String fileName) {
        return historyRepository.saveAll(ObjectUtils.getHistory(xmlMapper.fileToHistory(fileName)));
    }
}
