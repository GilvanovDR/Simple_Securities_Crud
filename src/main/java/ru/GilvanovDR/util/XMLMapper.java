package ru.GilvanovDR.util;


import org.springframework.oxm.Unmarshaller;
import ru.GilvanovDR.model.jaxb.XmlHistory;
import ru.GilvanovDR.model.jaxb.XmlHistoryContainer;
import ru.GilvanovDR.model.jaxb.XmlSecurity;
import ru.GilvanovDR.model.jaxb.XmlSecurityContainer;
import ru.GilvanovDR.util.exception.NotFoundException;

import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

//TODO Refactor this (DRY)
public class XMLMapper {
    private final Unmarshaller historyMarshaller;
    private final Unmarshaller securitiesMarshaller;

    public XMLMapper(Unmarshaller historyMarshaller, Unmarshaller securitiesMarshaller) {
        this.historyMarshaller = historyMarshaller;
        this.securitiesMarshaller = securitiesMarshaller;
    }

    public List<XmlSecurity> urlToSecurity(String url) {
        try {
            return streamToSecurity(new StreamSource(new URL(url).openStream()));
        } catch (IOException e) {
            throw new NotFoundException("Wrong URL:" + e);
        }
    }

    public List<XmlHistory> urlToHistory(String url) {
        try {
            return streamToHistory(new StreamSource(new URL(url).openStream()));
        } catch (IOException e) {
            throw new NotFoundException("Wrong URL:" + e);
        }
    }

    public List<XmlSecurity> streamToSecurity(StreamSource streamSource) {
        XmlSecurityContainer document;
        try {
            document = (XmlSecurityContainer) this.securitiesMarshaller.unmarshal(streamSource);
        } catch (Exception e) {
            throw new NotFoundException("Error xml parse:" + e);
        }
        return document.getDataContainer().getElements();
    }

    public List<XmlHistory> streamToHistory(StreamSource streamSource) {
        XmlHistoryContainer document;
        try {
            document = (XmlHistoryContainer) this.historyMarshaller.unmarshal(streamSource);
        } catch (Exception e) {
            throw new NotFoundException("Error xml parse:" + e);
        }
        return document.getDataContainer().get(0).getElements();
    }

    public List<XmlSecurity> fileToSecurity(String fileName) {
        try {
            return streamToSecurity(new StreamSource(new FileInputStream(fileName)));
        } catch (FileNotFoundException e) {
            throw new NotFoundException("Wrong file:" + e);
        }
    }

    public List<XmlHistory> fileToHistory(String fileName) {
        try {
            return streamToHistory(new StreamSource(new FileInputStream(fileName)));
        } catch (FileNotFoundException e) {
            throw new NotFoundException("Wrong file:" + e);
        }
    }
}
