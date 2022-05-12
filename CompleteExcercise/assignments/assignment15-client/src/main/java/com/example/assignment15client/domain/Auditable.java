package com.example.assignment15client.domain;

import java.time.LocalDate;

public class Auditable {
    public String createdBy;
    public String updatedBy;
    public LocalDate createdOn;
    public LocalDate updatedOn;
}
