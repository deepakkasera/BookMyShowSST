package com.example.bookmyshowsst.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id // Identity/PK column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENTED.
    private Long id;

    //Auditing attributes.
    private Date createdAt;
    private Date lastModifiedAt;
}

/*
MappedSuperClass annotation -

    1. No table for parent class.
    2. All the attributes of parent class will be present as
    columns in all the child class tables.
 */
