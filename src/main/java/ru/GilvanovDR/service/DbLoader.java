package ru.GilvanovDR.service;

import org.springframework.data.convert.EntityConverter;
import org.springframework.stereotype.Service;
import ru.GilvanovDR.model.Security;
import ru.GilvanovDR.model.jaxb.XmlSecurity;
import ru.GilvanovDR.repository.HistoryRepository;
import ru.GilvanovDR.repository.SecuritiesRepository;
import ru.GilvanovDR.util.ObjectUtils;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;

@Service
public class DbLoader {
    private HistoryRepository historyRepository;
    private SecuritiesRepository securitiesRepository;
    private ObjXMLMapper objXMLMapper;

    public DbLoader(HistoryRepository historyRepository, SecuritiesRepository securitiesRepository, ObjXMLMapper objXMLMapper) {
        this.historyRepository = historyRepository;
        this.securitiesRepository = securitiesRepository;
        this.objXMLMapper = objXMLMapper;
    }

    public boolean SecToDb(String fileName) throws IOException {
       return securitiesRepository
                .saveAll(ObjectUtils.getSecurities(objXMLMapper.XmlToSecurity(fileName)));
    }

}
