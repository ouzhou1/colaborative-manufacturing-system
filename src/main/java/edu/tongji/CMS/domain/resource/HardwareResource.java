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
@Table(name = "hardware_resource")
public class HardwareResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "devicecode")
    private Long deviceCode;

    @Column(name = "devicecateory")
    private String deviceCategory;

    @Column(name = "deviceowner")
    private String deviceOwner;

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

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(Long deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(String deviceCateory) {
        this.deviceCategory = deviceCateory;
    }

    public String getDeviceOwner() {
        return deviceOwner;
    }

    public void setDeviceOwner(String deviceOwner) {
        this.deviceOwner = deviceOwner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionDescription() {
        return functionDescription;
    }

    public void setFunctionDescription(String functionDescription) {
        this.functionDescription = functionDescription;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Long getOperationDays() {
        return operationDays;
    }

    public void setOperationDays(Long operationDays) {
        this.operationDays = operationDays;
    }

    public String getLoadStatus() {
        return loadStatus;
    }

    public void setLoadStatus(String loadStatus) {
        this.loadStatus = loadStatus;
    }
}
