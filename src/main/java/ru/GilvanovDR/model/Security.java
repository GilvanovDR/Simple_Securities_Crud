package ru.GilvanovDR.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "securities")
public class Security {
    @Id
    protected String secId;

    protected String regNumber;

    protected String name;

    protected String emitentTitle;
}
