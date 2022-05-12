package com.example.security.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class Auditable {
    @Column(name = "createdBy", nullable = false)
    public String createdBy;
    @Column(name = "updatedBy", nullable = false)
    public String updatedBy;
    @Column(name = "createdOn", nullable = false)
    public LocalDate createdOn;
    @Column(name = "updatedOn", nullable = false)
    public LocalDate updatedOn;
}
