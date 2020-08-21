package ru.GilvanovDR.model.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

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
        private List<XmlHistory> elements;

        public List<XmlHistory> getElements() {
            return elements;
        }

        @XmlElementWrapper(name = "rows")
        @XmlElement(name = "row")
        public void setElements(List<XmlHistory> elements) {
            this.elements = elements;
        }
    }
}
