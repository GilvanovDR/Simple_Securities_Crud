package ru.GilvanovDR.model.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


//https://www.netjstech.com/2018/11/spring-object-xml-mapping-support-jaxb-example.html
@XmlRootElement(name = "document")
public class XmlHistoryContainer {
    private List<HistoryDataContainer> dataContainers;

    public List<HistoryDataContainer> getDataContainer() {
        return dataContainers;
    }

    @XmlElement(name = "data")
    public void setDataContainer(List<HistoryDataContainer> dataContainers) {
        this.dataContainers = dataContainers;
    }

    public static class HistoryDataContainer {
        private List<History> elements;

        public List<History> getElements() {
            return elements;
        }

        @XmlElementWrapper(name = "rows")
        @XmlElement(name = "row")
        public void setElements(List<History> elements) {
            this.elements = elements;
        }
    }
}
