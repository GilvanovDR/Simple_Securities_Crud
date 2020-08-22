package ru.GilvanovDR.model.jaxb;

import javax.xml.bind.annotation.XmlAttribute;


public class XmlSecurity {

    protected String secId;

    protected String regNumber;

    protected String name;

    protected String emitentTitle;

    public String getSecId() {
        return secId;
    }

    @XmlAttribute(name = "secid")
    public void setSecId(String secId) {
        this.secId = secId;
    }

    public String getRegNumber() {
        return regNumber;
    }

    @XmlAttribute(name = "regnumber")
    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getEmitentTitle() {
        return emitentTitle;
    }

    @XmlAttribute(name = "emitent_title")
    public void setEmitentTitle(String emitentTitle) {
        this.emitentTitle = emitentTitle;
    }

    @Override
    public String toString() {
        return "XmlSecurity{" +
                "secId='" + secId + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", name='" + name + '\'' +
                ", emitentTitle='" + emitentTitle + '\'' +
                '}';
    }
}
