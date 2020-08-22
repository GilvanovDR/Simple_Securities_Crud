package ru.GilvanovDR.model.jaxb;

import javax.xml.bind.annotation.XmlAttribute;

public class XmlHistory {
    protected String secId;
    protected String tradeDate;
    protected String numTrades;
    protected String open;
    protected String close;

    @Override
    public String toString() {
        return "XmlHistory{" +
                "secId='" + secId + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                ", numTrades='" + numTrades + '\'' +
                ", open='" + open + '\'' +
                ", close='" + close + '\'' +
                '}';
    }

    public String getSecId() {
        return secId;
    }

    @XmlAttribute(name = "SECID")
    public void setSecId(String secId) {
        this.secId = secId;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    @XmlAttribute(name = "TRADEDATE")
    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getNumTrades() {
        return numTrades;
    }

    @XmlAttribute(name = "NUMTRADES")
    public void setNumTrades(String numTrades) {
        this.numTrades = numTrades;
    }

    public String getOpen() {
        return open;
    }

    @XmlAttribute(name = "OPEN")
    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    @XmlAttribute(name = "CLOSE")
    public void setClose(String close) {
        this.close = close;
    }
}
