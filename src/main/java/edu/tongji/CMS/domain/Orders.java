package edu.tongji.CMS.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.tongji.CMS.domain.vo.OrderStatus;
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

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	@NotEmpty(message = "Status is required.")
	private OrderStatus status;

	@Column(name = "city")
	@NotEmpty(message = "City is required.")
	private String city;

	@Column(name = "field")
	@NotEmpty(message = "Field is required.")
	private String field;

	@Column(name = "tech_category")
	@NotEmpty(message = "Tech category is required.")
	private String tech_category;

	@Column(name = "craft_category")
	@NotEmpty(message = "Craft category is required.")
	private String craft_category;
	
	@Column(name = "period", length = 5)
	@NotEmpty(message = "Period is required.")
	private String period;

	@Column(name = "scale")
	@NotEmpty(message = "Scale is required.")
	private String scale;
	
	//Numbers of decomposed sub-orders
	@Column(name = "sub_order_nums")
	@NotEmpty(message = "The number of sub-orders is required.")
	private String sub_order_nums;
	
	@Column(name = "tags")
	//@NotEmpty(message = "Tag is required.")
	private String tags;

	@Column(name = "raw_description")
	private String raw_description;
	
	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTech_category() {
		return tech_category;
	}

	public void setTech_category(String tech_category) {
		this.tech_category = tech_category;
	}

	public String getCraft_category() {
		return craft_category;
	}

	public void setCraft_category(String craft_category) {
		this.craft_category = craft_category;
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

	public String getSub_order_nums() {
		return sub_order_nums;
	}

	public void setSub_order_nums(String sub_order_nums) {
		this.sub_order_nums = sub_order_nums;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getRaw_description() {
		return raw_description;
	}

	public void setRaw_description(String raw_description) {
		this.raw_description = raw_description;
	}

}