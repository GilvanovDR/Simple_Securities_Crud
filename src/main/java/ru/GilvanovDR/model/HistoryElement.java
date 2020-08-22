package ru.GilvanovDR.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.GilvanovDR.model.jaxb.XmlHistory;
import ru.GilvanovDR.util.exception.NotFoundException;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "HISTORY")
public class HistoryElement extends AbstractBaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "SEC_ID", nullable = false)
    protected Security security;
    @Column(name = "TRADE_DATE", nullable = false)
    protected LocalDate tradeDate;
    @Column(name = "NUM_TRADES")
    protected Double numTrades;
    @Column(name = "OPEN")
    protected Double open;
    @Column(name = "CLOSE")
    protected Double close;

    public HistoryElement() {
    }

    public HistoryElement(XmlHistory xmlHistory) {
        try {
            this.tradeDate = LocalDate.parse(xmlHistory.getTradeDate());
            this.numTrades = !"".equals(xmlHistory.getNumTrades()) ? Double.parseDouble(xmlHistory.getNumTrades()) : null;
            this.open = !"".equals(xmlHistory.getOpen()) ? Double.parseDouble(xmlHistory.getOpen()) : null;
            this.close = !"".equals(xmlHistory.getClose()) ? Double.parseDouble(xmlHistory.getClose()) : null;
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage() + " " + xmlHistory.toString());
        }
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Double getNumTrades() {
        return numTrades;
    }

    public void setNumTrades(Double numTrades) {
        this.numTrades = numTrades;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return "HistoryElement{" +
                "security=" + security +
                ", tradeDate=" + tradeDate +
                ", numTrades=" + numTrades +
                ", open=" + open +
                ", close=" + close +
                ", id=" + id +
                '}';
    }
}
