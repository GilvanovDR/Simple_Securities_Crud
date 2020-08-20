package ru.GilvanovDR.model.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

public class History implements Serializable {
    protected String secId;
    protected String tradeDate;
    protected String numTrades;
    protected String open;
    protected String close;

    @XmlAttribute(name = "SECID")
    public void setSecId(String secId) {
        this.secId = secId;
    }

    @XmlAttribute(name = "TRADEDATE")
    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    @XmlAttribute(name = "NUMTRADES")
    public void setNumTrades(String numTrades) {
        this.numTrades = numTrades;
    }

    @XmlAttribute(name = "OPEN")
    public void setOpen(String open) {
        this.open = open;
    }

    @XmlAttribute(name = "CLOSE")
    public void setClose(String close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return "History{" +
                "secId='" + secId + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                ", numTrades='" + numTrades + '\'' +
                ", open='" + open + '\'' +
                ", close='" + close + '\'' +
                '}';
    }
}
