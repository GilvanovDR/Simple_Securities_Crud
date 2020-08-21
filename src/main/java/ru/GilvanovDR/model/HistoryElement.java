package ru.GilvanovDR.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "HISTORY")
public class HistoryElement extends AbstractBaseEntity {
    public HistoryElement() {
    }
    @ManyToOne(fetch = FetchType.LAZY)
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

    public void setSecurity(Security security) {
        this.security = security;
    }

    public Security getSecurity() {
        return security;
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
