package ru.GilvanovDR.model;

import ru.GilvanovDR.model.jaxb.XmlSecurity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SECURITIES")
public class Security extends AbstractBaseEntity {
    @Size(max = 765)
    @Column(name = "REG_NUMBER")
    protected String regNumber;

    @Size(max = 765)
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Size(max = 765)
    @Column(name = "EMITENT_TITLE", nullable = false)
    protected String emitentTitle;

    @Size(max = 36)
    @NotBlank
    @Column(name = "SEC_ID", nullable = false)
    String secID;

    public Security() {

    }

    public Security(String secID, String regNumber, String name, String emitentTitle, Integer id) {
        super(id);
        this.secID = secID;
        this.regNumber = regNumber;
        this.name = name;
        this.emitentTitle = emitentTitle;
    }

    public Security(String secID, String regNumber, String name, String emitentTitle) {
        this(secID, regNumber, name, emitentTitle, null);
    }

    public Security(XmlSecurity xmlSecurity) {
        this.secID = xmlSecurity.getSecId();
        this.regNumber = xmlSecurity.getRegNumber();
        this.name = xmlSecurity.getName();
        this.emitentTitle = xmlSecurity.getEmitentTitle();
    }

    public String getSecID() {
        return secID;
    }

    public void setSecID(String secID) {
        this.secID = secID;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmitentTitle() {
        return emitentTitle;
    }

    public void setEmitentTitle(String emitentTitle) {
        this.emitentTitle = emitentTitle;
    }

    @Override
    public String toString() {
        return "Security{" +
                "secID='" + secID + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", name='" + name + '\'' +
                ", emitentTitle='" + emitentTitle + '\'' +
                ", id=" + id +
                '}';
    }
}
