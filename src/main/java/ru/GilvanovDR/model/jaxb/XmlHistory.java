package ru.GilvanovDR.model.jaxb;

import javax.xml.bind.annotation.XmlAttribute;

public class XmlHistory {
    protected String secId;
    protected String tradeDate;
    protected String numTrades;
    protected String open;
    protected String close;

    public XmlHistory(String secId, String tradeDate, String numTrades, String open, String close) {
        this.secId = secId;
        this.tradeDate = tradeDate;
        this.numTrades = numTrades;
        this.open = open;
        this.close = close;
    }

    public XmlHistory() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XmlHistory that = (XmlHistory) o;

        if (!secId.equals(that.secId)) return false;
        if (!tradeDate.equals(that.tradeDate)) return false;
        if (!numTrades.equals(that.numTrades)) return false;
        if (open != null ? !open.equals(that.open) : that.open != null) return false;
        return close != null ? close.equals(that.close) : that.close == null;
    }

    @Override
    public int hashCode() {
        int result = secId.hashCode();
        result = 31 * result + tradeDate.hashCode();
        result = 31 * result + numTrades.hashCode();
        result = 31 * result + (open != null ? open.hashCode() : 0);
        result = 31 * result + (close != null ? close.hashCode() : 0);
        return result;
    }

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
