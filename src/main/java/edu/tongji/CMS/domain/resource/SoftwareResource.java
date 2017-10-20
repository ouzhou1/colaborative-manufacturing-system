package edu.tongji.CMS.domain.resource;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ouzhou
 */

@Entity
@Table(name = "SoftwareResource")
public class
SoftwareResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private Long code;

    @Column(name = "cateory")
    private String category;

    @Column(name = "owner")
    private String owner;

    @Column(name = "description")
    private String description;

    @Column(name = "productiondate")
    private Date productionDate;

    @Column(name = "functionname")
    private String functionName;

    @Column(name = "functiondescription")
    private String functionDescription;

    @Column(name = "currentstatus")
    private String currentStatus;

    @Column(name = "operationdays")
    private Long operationDays;

    @Column(name = "loadstatus")
    private String loadStatus;
}
