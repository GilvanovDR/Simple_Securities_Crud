package ru.GilvanovDR.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quotations")
public class Quotation {
    @Id
    protected Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "sec_id", nullable = false)
    protected Security secId;

    protected Date tradeDate;

    protected Double numTrades;

    protected Double open;

    protected Double close;


}
