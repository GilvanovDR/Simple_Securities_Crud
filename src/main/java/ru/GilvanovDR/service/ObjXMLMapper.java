package ru.GilvanovDR.service;

import org.springframework.oxm.Unmarshaller;
import ru.GilvanovDR.model.jaxb.XmlHistory;
import ru.GilvanovDR.model.jaxb.XmlSecurity;
import ru.GilvanovDR.model.jaxb.XmlHistoryContainer;
import ru.GilvanovDR.model.jaxb.XmlSecurityContainer;

import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ObjXMLMapper{
    private final Unmarshaller historyMarshaller;
    private final Unmarshaller securitiesMarshaller;

    public ObjXMLMapper(Unmarshaller historyMarshaller, Unmarshaller securitiesMarshaller) {
        this.historyMarshaller = historyMarshaller;
        this.securitiesMarshaller = securitiesMarshaller;
    }

    public List<XmlSecurity> XmlToSecurity(String fileName) throws IOException {
        XmlSecurityContainer document;
        try (FileInputStream is = new FileInputStream(fileName)) {
            document = (XmlSecurityContainer) this.securitiesMarshaller.unmarshal(new StreamSource(is));
        }
        return document.getDataContainer().getElements();
    }

    public List<XmlHistory> XmlToHistory(String fileName) throws IOException {
        XmlHistoryContainer document;
        try (FileInputStream is = new FileInputStream(fileName)) {
            document = (XmlHistoryContainer) this.historyMarshaller.unmarshal(new StreamSource(is));
        }
        return document.getDataContainer().get(0).getElements();
    }
}
