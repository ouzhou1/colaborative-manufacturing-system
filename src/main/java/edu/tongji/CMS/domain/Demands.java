package edu.tongji.CMS.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author ouzhou
 */

@Entity
@Table(name = "demands")
public class Demands {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "demand_id")
	private Long demand_id;
	
	@Column(name = "demand_name")
	@NotEmpty(message = "Demand name is required.")
	private String demand_name;

	@Column(name = "related_order")
	@NotEmpty(message = "Belonged order is required.")
	private String related_order;

	@Column(name = "publisher")
	@NotEmpty(message = "Publisher is required.")
	private String publisher;

	@Column(name = "publish_time")
	@NotEmpty(message = "Publish time is required.")
	private Date publish_time;

	@Column(name = "status")
	@NotEmpty(message = "Status is required.")
	private String status;

	@Column(name = "field")
	@NotEmpty(message = "Field is required.")
	private String field;

	@Column(name = "city")
	private String city;

	@Column(name = "tags")
	//@NotEmpty(message = "Tag is required.")
	private String tags;

	@Column(name = "delivery_date")
	@NotEmpty(message = "Delivery date is required.")
	private Date delivery_date;

	@Column(name = "description")
	@NotEmpty(message = "A detaled description is required.")
	private String description;

	public Long getDemand_id() {
		return demand_id;
	}

	public void setDemand_id(Long demands_id) {
		this.demand_id = demands_id;
	}

	public String getDemand_name() {
		return demand_name;
	}

	public void setDemand_name(String demand_name) {
		this.demand_name = demand_name;
	}

	public String getRelated_order() {
		return related_order;
	}

	public void setRelated_order(String related_order) {
		this.related_order = related_order;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(Date publish_time) {
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Date getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
