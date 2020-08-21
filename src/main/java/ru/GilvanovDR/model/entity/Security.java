package ru.GilvanovDR.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Access(AccessType.FIELD)
@Table(name = "SECURITIES")
public class Security {
    @Id
    @Size(max = 36)
    @Column(name = "SEC_ID", nullable = false)
    String secID;

    @Size(max = 765)
    @Column(name = "REG_NUMBER")
    protected String regNumber;

    @Size(max = 765)
    @Column(name = "REG_NUMBER")
    protected String name;
    @Size(max = 765)
    @Column(name = "REG_NUMBER")
    protected String emitentTitle;
}
