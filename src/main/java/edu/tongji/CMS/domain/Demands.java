package edu.tongji.CMS.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author ouzhou
 */

@Data
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

}
