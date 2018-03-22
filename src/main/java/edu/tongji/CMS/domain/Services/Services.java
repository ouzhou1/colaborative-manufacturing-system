package edu.tongji.CMS.domain.Services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * @author ouzhou
 */

@Entity
@Table(name = "services")
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "owner")
	@NotEmpty(message = "Owner is required.")
	private String owner;

	@Column(name = "category")
	//@NotEmpty(message = "Catagory is required.")
	private String category;

	@Column(name = "subcategory")
	//@NotEmpty(message = "Sub Catagory is required.")
	private String subcategory;

	@Column(name = "field")
	//@NotEmpty(message = "Field is required.")
	private String field;

	@Column(name = "servicename")
	@NotEmpty(message = "Service Name is required.")
	private String servicename;

	@Column(name = "publishtime")
	@NotEmpty(message = "Publishtime is required.")
	private String publishtime;
	
	@Column(name = "serviceUseTimes")
	// @NotEmpty(message = "The time of services using is required.")
	private String serviceUseTimes;

	@Column(name = "status")
	@NotEmpty(message = "Status is required.")
	private String status;
	
	@Column(name = "onlineNums")
    // @NotEmpty(message = "Number of online services is required.")
	private String online_nums;

    @Column(name = "capacity")
    // @NotEmpty(message = "The capacity of services is required.")
    private String capacity;

	// remainService
	// maximumCapacity
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "createDate")
    //@NotEmpty(message = "Create date is required.")
    private String createDate;

	@Column(name = "summary")
	private String summary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public String getServiceUseTimes() {
        return serviceUseTimes;
    }

    public void setServiceUseTimes(String serviceUseTimes) {
        this.serviceUseTimes = serviceUseTimes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOnline_nums() {
        return online_nums;
    }

    public void setOnline_nums(String online_nums) {
        this.online_nums = online_nums;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
