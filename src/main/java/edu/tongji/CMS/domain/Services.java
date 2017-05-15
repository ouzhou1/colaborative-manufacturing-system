package edu.tongji.CMS.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

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

	@Column(name = "field")
	//@NotEmpty(message = "Field is required.")
	private String field;

	@Column(name = "servicename")
	@NotEmpty(message = "Service Name is required.")
	private String servicename;

	@Column(name = "publishtime")
	@NotEmpty(message = "Publishtime is required.")
	private String publishtime;
	
	@Column(name = "service_imes")
	@NotEmpty(message = "The time of services using is required.")
	private String service_imes;

	@Column(name = "status")
	@NotEmpty(message = "Status is required.")
	private String status;
	
	@Column(name = "online_nums")
	@NotEmpty(message = "Numbers of online services is required.")
	private String online_nums;

	@Column(name = "summary")
	//@NotEmpty(message = "Summary is required.")
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

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String text) {
		this.servicename = text;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public String getService_imes() {
		return service_imes;
	}

	public void setService_imes(String service_imes) {
		this.service_imes = service_imes;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
