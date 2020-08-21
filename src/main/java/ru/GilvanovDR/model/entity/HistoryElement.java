package ru.GilvanovDR.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Access(AccessType.FIELD)
@Table(name = "HISTORY")
public class HistoryElement {
    @Id
    protected Integer id;

    @Size(max = 36)
    @Column(name = "SEC_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "sec_id", nullable = false)
    protected Security secId;

    @Column(name = "TRADE_DATE", nullable = false)
    protected LocalDate tradeDate;

    @Column(name = "NUM_TRADES")
    protected Double numTrades;

    @Column(name = "OPEN")
    protected Double open;

    @Column(name = "CLOSE")
    protected Double close;

}
