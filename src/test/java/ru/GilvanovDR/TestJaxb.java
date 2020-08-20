package ru.GilvanovDR;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.GilvanovDR.service.ObjXMLMapper;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class TestJaxb {
    public static void main(String[] args) throws IOException {
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring/spring-app.xml");
            appCtx.refresh();
            ObjXMLMapper objXMLMapper = appCtx.getBean("objXmlMapper", ObjXMLMapper.class);
            objXMLMapper.XmlToHistory("XML/history_2.xml").forEach(System.out::println);
            objXMLMapper.XmlToSecurity("XML/securities_1.xml").forEach(System.out::println);
        }
    }
}
