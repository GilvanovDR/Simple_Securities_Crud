package ru.GilvanovDR.model.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "document")
public class XmlSecurityContainer {
    private SecurityDataContainer dataContainer;

    public SecurityDataContainer getDataContainer() {
        return dataContainer;
    }

    @XmlElement(name = "data")
    public void setDataContainer(SecurityDataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    public static class SecurityDataContainer {
        private List<XmlSecurity> elements;

        public List<XmlSecurity> getElements() {
            return elements;
        }

        @XmlElementWrapper(name = "rows")
        @XmlElement(name = "row")
        public void setElements(List<XmlSecurity> elements) {
            this.elements = elements;
        }
    }
}
