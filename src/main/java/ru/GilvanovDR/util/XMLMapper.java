package ru.GilvanovDR.util;

import org.springframework.oxm.Unmarshaller;
import ru.GilvanovDR.model.jaxb.XmlHistory;
import ru.GilvanovDR.model.jaxb.XmlHistoryContainer;
import ru.GilvanovDR.model.jaxb.XmlSecurity;
import ru.GilvanovDR.model.jaxb.XmlSecurityContainer;
import ru.GilvanovDR.util.exception.NotFoundException;

import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.util.List;


public class XMLMapper {
    private final Unmarshaller historyMarshaller;
    private final Unmarshaller securitiesMarshaller;

    public XMLMapper(Unmarshaller historyMarshaller, Unmarshaller securitiesMarshaller) {
        this.historyMarshaller = historyMarshaller;
        this.securitiesMarshaller = securitiesMarshaller;
    }

    public List<XmlSecurity> XmlToSecurity(String fileName) {
        XmlSecurityContainer document;
        try {
            FileInputStream is = new FileInputStream(fileName);
            document = (XmlSecurityContainer) this.securitiesMarshaller.unmarshal(new StreamSource(is));
        } catch (Exception e) {
            throw new NotFoundException("Error xml parse:" + e);
        }
        return document.getDataContainer().getElements();
    }

    public List<XmlHistory> XmlToHistory(String fileName) {
        XmlHistoryContainer document;
        try (FileInputStream is = new FileInputStream(fileName)) {
            document = (XmlHistoryContainer) this.historyMarshaller.unmarshal(new StreamSource(is));
        } catch (Exception e) {
            throw new NotFoundException("Error xml parse:" + e);
        }
        return document.getDataContainer().get(0).getElements();
    }
}
