package ru.GilvanovDR.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.GilvanovDR.model.jaxb.XmlHistory;
import ru.GilvanovDR.util.exception.NotFoundException;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "HISTORY")
public class History extends AbstractBaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "SEC_ID", nullable = false)
    protected Security security;
    @Column(name = "TRADE_DATE", nullable = false)
    protected LocalDate tradeDate;
    @Column(name = "NUM_TRADES")
    protected Integer numTrades;
    @Column(name = "OPEN")
    protected Double open;
    @Column(name = "CLOSE")
    protected Double close;

    public History() {
    }

    public History(XmlHistory xmlHistory) {
        try {
            this.tradeDate = LocalDate.parse(xmlHistory.getTradeDate());
            this.numTrades = !"".equals(xmlHistory.getNumTrades()) ? Integer.parseInt(xmlHistory.getNumTrades()) : null;
            this.open = !"".equals(xmlHistory.getOpen()) ? Double.parseDouble(xmlHistory.getOpen()) : null;
            this.close = !"".equals(xmlHistory.getClose()) ? Double.parseDouble(xmlHistory.getClose()) : null;
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage() + " " + xmlHistory.toString());
        }
    }
    public History(Security security, LocalDate tradeDate, Integer numTrades, Double open, Double close, Integer id) {
       super(id);
       this.security = security;
       this.tradeDate = tradeDate;
       this.numTrades = numTrades;
       this.open = open;
       this.close = close;
    }

    public History(Security security, LocalDate tradeDate, Integer numTrades, Double open, Double close) {
        this(security,tradeDate,numTrades,open,close,null);
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

    public Integer getNumTrades() {
        return numTrades;
    }

    public void setNumTrades(Integer numTrades) {
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
        return "History{" +
                "security=" + security +
                ", tradeDate=" + tradeDate +
                ", numTrades=" + numTrades +
                ", open=" + open +
                ", close=" + close +
                ", id=" + id +
                '}';
    }
}
