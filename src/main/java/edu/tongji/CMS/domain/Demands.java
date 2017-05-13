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
@Table(name = "demands")
public class Demands {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "demands_id")
	private Long demands_id;
	
	@Column(name = "demand_name")
	@NotEmpty(message = "Demand name is required.")
	private String demand_name;
	
	@Column(name = "publisher")
	@NotEmpty(message = "Publisher is required.")
	private String publisher;

	@Column(name = "publish_time")
	@NotEmpty(message = "Publish time is required.")
	private String publish_time;

	@Column(name = "status")
	@NotEmpty(message = "Status is required.")
	private String status;

	@Column(name = "field")
	@NotEmpty(message = "Field is required.")
	private String field;

	@Column(name = "tags")
	//@NotEmpty(message = "Tag is required.")
	private String tags;

	@Column(name = "delivery_date")
	@NotEmpty(message = "Delivery date is required.")
	private String delivery_date;

	@Column(name = "description")
	@NotEmpty(message = "A detaled description is required.")
	private String description;

	public Long getDemands_id() {
		return demands_id;
	}

	public void setDemands_id(Long demands_id) {
		this.demands_id = demands_id;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
