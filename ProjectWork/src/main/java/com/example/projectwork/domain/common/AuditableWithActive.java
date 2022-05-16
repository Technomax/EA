package com.example.projectwork.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AuditableWithActive{
    @Column(name="isActive", nullable = false)
    public boolean isActive;
    @Column(name="createdBy", nullable = false, length = 150)
    public String createdBy;
    @Column(name="updatedBy", nullable = false, length = 150)
    public String updatedBy;
    @Column(name="createdOn", nullable = false)
    public LocalDate createdOn;
    @Column(name="updatedOn", nullable = false)
    public LocalDate updatedOn;
}
