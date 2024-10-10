package com.example.bookmyshowsst.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
    @Id // Identity/PK column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENTED.
    private Long id;

    //Auditing attributes.
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date lastModifiedAt;
}

/*
MappedSuperClass annotation -

    1. No table for parent class.
    2. All the attributes of parent class will be present as
    columns in all the child class tables.
 */
