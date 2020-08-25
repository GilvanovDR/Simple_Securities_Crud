package ru.GilvanovDR.model.jaxb;

import javax.xml.bind.annotation.XmlAttribute;


public class XmlSecurity {

    protected String secId;

    protected String regNumber;

    protected String name;

    protected String emitentTitle;

    public XmlSecurity() {
    }

    public XmlSecurity(String secId, String regNumber, String name, String emitentTitle) {
        this.secId = secId;
        this.regNumber = regNumber;
        this.name = name;
        this.emitentTitle = emitentTitle;
    }

    public String getSecId() {
        return secId;
    }

    @XmlAttribute(name = "secid")
    public void setSecId(String secId) {
        this.secId = secId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XmlSecurity that = (XmlSecurity) o;

        if (!secId.equals(that.secId)) return false;
        if (regNumber != null ? !regNumber.equals(that.regNumber) : that.regNumber != null) return false;
        if (!name.equals(that.name)) return false;
        return emitentTitle.equals(that.emitentTitle);
    }

    @Override
    public int hashCode() {
        int result = secId.hashCode();
        result = 31 * result + (regNumber != null ? regNumber.hashCode() : 0);
        result = 31 * result + name.hashCode();
        result = 31 * result + emitentTitle.hashCode();
        return result;
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
}
