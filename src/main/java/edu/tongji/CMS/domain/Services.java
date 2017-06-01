package edu.tongji.CMS.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author ouzhou
 */

@Data
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
	
	@Column(name = "serviceUseTimes")
	@NotEmpty(message = "The time of services using is required.")
	private String serviceUseTimes;

	@Column(name = "status")
	@NotEmpty(message = "Status is required.")
	private String status;
	
	@Column(name = "onlineNums")
	@NotEmpty(message = "Numbers of online services is required.")
	private String online_nums;

	@Column(name = "summary")
	//@NotEmpty(message = "Summary is required.")
	private String summary;

}
