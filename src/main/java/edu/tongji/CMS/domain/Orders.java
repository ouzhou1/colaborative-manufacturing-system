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
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author ouzhou
 */

@Data
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

}