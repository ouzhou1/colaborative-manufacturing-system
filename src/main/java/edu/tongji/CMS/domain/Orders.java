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
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long order_id;
	
	@Column(name = "order_name")
	@NotEmpty(message = "Order name is required.")
	private String order_name;
	
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
	
	@Column(name = "period")
	@NotEmpty(message = "Period is required.")
	private String period;

	@Column(name = "scale")
	@NotEmpty(message = "Scale is required.")
	private String scale;
	
	@Column(name = "tags")
	//@NotEmpty(message = "Tag is required.")
	private String tags;
	
	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
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

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}
