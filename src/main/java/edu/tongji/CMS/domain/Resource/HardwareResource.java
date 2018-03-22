package edu.tongji.CMS.domain.Resource;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.File;
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
    @NotEmpty(message = "Resource name is required.")
    private String name;

    @Column(name = "resource_code")
    @NotEmpty(message = "Resource code is required.")
    private String resourceCode;

    @Column(name = "category")
    @NotEmpty(message = "Resource category is required.")
    private String category;

    @Column(name = "owner")
    @NotEmpty(message = "Resource owner is required.")
    private String owner;

    @Column(name = "description")
    private String description;

    @Column(name = "use_date")
    private Date useDate;

    @Column(name = "function_name")
    @NotEmpty(message = "Resource function name is required.")
    private String functionName;

    @Column(name = "function_description")
    private String functionDescription;

    @Column(name = "current_status")
    private String currentStatus;

    @Column(name = "operation_days")
    private Long operationDays;

    @Column(name = "load_status")
    private String loadStatus;

    @Column(name = "owl_file")
    private File owlFile;

    public long getId() {
        return id;
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

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
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

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
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

    public File getOwlFile() {
        return owlFile;
    }

    public void setOwlFile(File owlFile) {
        this.owlFile = owlFile;
    }
}
