package ru.GilvanovDR;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import ru.GilvanovDR.repository.HistoryRepository;
import ru.GilvanovDR.repository.SecuritiesRepository;
import ru.GilvanovDR.service.DbLoader;

import java.io.IOException;

public class TestJaxb {
    public static void main(String[] args) throws IOException {
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring/spring-app.xml", "spring/spring-db.xml");
            appCtx.refresh();
            //XMLMapper objXMLMapper = appCtx.getBean("objXmlMapper", XMLMapper.class);
            //objXMLMapper.XmlToSecurity("XML/securities_1.xml").forEach(System.out::println);
            DbLoader dbLoader = appCtx.getBean(DbLoader.class);
            //objXMLMapper.XmlToHistory("XML/history_2.xml").forEach(System.out::println);
            System.out.println("+++++++" + dbLoader.SecToDb("XML/securities_1.xml"));
            System.out.println("+++++++" + dbLoader.SecToDb("XML/securities_2.xml"));
            System.out.println("=======" + dbLoader.SecToDb("XML/securities_2.xml"));
            HistoryRepository historyRepository = appCtx.getBean(HistoryRepository.class);
            //securitiesRepository.getAll().forEach(System.out::println);
            System.out.println("HISTORY NOT ADD " + dbLoader.HisToDb("XML/history_1.xml"));
            System.out.println("HISTORY SIZE " + historyRepository.getAll().size());
            System.out.println("HISTORY NOT ADD " + dbLoader.HisToDb("XML/history_2.xml"));
            System.out.println("HISTORY SIZE " + historyRepository.getAll().size());
            System.out.println("HISTORY NOT ADD " + dbLoader.HisToDb("XML/history_3.xml"));
            System.out.println("HISTORY SIZE " + historyRepository.getAll().size());
            System.out.println("HISTORY NOT ADD " + dbLoader.HisToDb("XML/history_4.xml"));
            System.out.println("HISTORY SIZE " + historyRepository.getAll().size());

        }
    }
}
