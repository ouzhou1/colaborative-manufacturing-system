package edu.tongji.CMS.domain.Resource;

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

    @Column(name = "category")
    private String category;

    @Column(name = "owner")
    private String owner;

    @Column(name = "description")
    private String description;

    @Column(name = "production_date")
    private Date productionDate;

    @Column(name = "function_name")
    private String functionName;

    @Column(name = "function_description")
    private String functionDescription;

    @Column(name = "data_format")
    private String dataFormat;

    @Column(name = "current_status")
    private String currentStatus;

    @Column(name = "operation_days")
    private Long operationDays;

    @Column(name = "instruction")
    private String instruction;

    @Column(name = "url")
    private String url;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
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

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
