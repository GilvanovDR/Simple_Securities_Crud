package ru.GilvanovDR.service;

import org.springframework.stereotype.Service;
import ru.GilvanovDR.repository.HistoryRepository;
import ru.GilvanovDR.repository.SecuritiesRepository;
import ru.GilvanovDR.util.ObjectUtils;
import ru.GilvanovDR.util.XMLMapper;
import ru.GilvanovDR.util.exception.NotFoundException;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

@Service
public class DbLoader {
    private final HistoryRepository historyRepository;
    private final SecuritiesRepository securitiesRepository;
    private final XMLMapper xmlMapper;

    public DbLoader(HistoryRepository historyRepository, SecuritiesRepository securitiesRepository, XMLMapper xmlMapper) {
        this.historyRepository = historyRepository;
        this.securitiesRepository = securitiesRepository;
        this.xmlMapper = xmlMapper;
    }

    public int secToDb(String fileName) {
        return securitiesRepository
                .saveAll(ObjectUtils.getSecurities(xmlMapper.XmlToSecurity(fileName)));
    }

    public int hisToDb(String fileName){
        return historyRepository.saveAll(ObjectUtils.getHistory(xmlMapper.XmlToHistory(fileName)));
    }

    public int uploadFromFolder(String pathName) {
        Set<String> securities = new HashSet<>();
        Set<String> history = new HashSet<>();
        int count = 0;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(pathName))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path) && path.getFileName().toString().toLowerCase().endsWith(".xml")) {
                    if (path.getFileName().toString().toLowerCase().contains("securities")) {
                        securities.add(path.getFileName().toString());
                    }
                    if (path.getFileName().toString().toLowerCase().contains("history")) {
                        history.add(path.getFileName().toString());
                    }
                }
            }
        } catch (IOException e) {
            throw new NotFoundException("Can't parse folder " + e.getMessage());
        }
        for (String fileName : securities) {
            count += secToDb(pathName + "/" + fileName);
        }
        for (String fileName : history) {
            count += hisToDb(pathName + "/" + fileName);
        }
        return count;
    }

    /*    @PostConstruct
    public void initDb() {
        try {
            uploadFromFolder("resources/XML");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
