package ru.GilvanovDR;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.GilvanovDR.repository.SecuritiesRepository;
import ru.GilvanovDR.service.DbUploader;

public class SpringTestContext {
    public static void main(String[] args) {
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring/spring-db.xml", "spring/spring-app.xml");
            appCtx.refresh();
            //XMLMapper objXMLMapper = appCtx.getBean("objXmlMapper", XMLMapper.class);
            //objXMLMapper.XmlToSecurity("XML/securities_1.xml").forEach(System.out::println);
            DbUploader dbUploader = appCtx.getBean(DbUploader.class);
            //objXMLMapper.XmlToHistory("XML/history_2.xml").forEach(System.out::println);
            //System.out.println(dbLoader.uploadFromFolder("XML"));
            SecuritiesRepository securitiesRepository = appCtx.getBean(SecuritiesRepository.class);
            securitiesRepository.getAll().forEach(System.out::println);
        }
    }
}
