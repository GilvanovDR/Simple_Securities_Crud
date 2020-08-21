package ru.GilvanovDR;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.GilvanovDR.repository.SecuritiesRepository;
import ru.GilvanovDR.service.DbLoader;
import ru.GilvanovDR.service.ObjXMLMapper;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class TestJaxb {
    public static void main(String[] args) throws IOException {
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring/spring-app.xml","spring/spring-db.xml");
            appCtx.refresh();
            //ObjXMLMapper objXMLMapper = appCtx.getBean("objXmlMapper", ObjXMLMapper.class);
            //objXMLMapper.XmlToSecurity("XML/securities_1.xml").forEach(System.out::println);
            DbLoader dbLoader = appCtx.getBean(DbLoader.class);
            //objXMLMapper.XmlToHistory("XML/history_2.xml").forEach(System.out::println);
            System.out.println(dbLoader.SecToDb("XML/securities_1.xml"));
            System.out.println(dbLoader.SecToDb("XML/securities_2.xml"));
            try {
                System.out.println(dbLoader.SecToDb("XML/securities_2.xml"));
            } catch (IOException m) {
                System.out.println(m.getMessage());
            }
            SecuritiesRepository securitiesRepository=appCtx.getBean(SecuritiesRepository.class);
            securitiesRepository.getAll().forEach(System.out::println);
        }
    }
}
