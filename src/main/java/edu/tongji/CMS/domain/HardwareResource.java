package edu.tongji.CMS.domain;

import lombok.Data;

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
@Data
@Entity
@Table(name = "hardware_resource")
public class HardwareResource {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "devicecode")
	private Long deviceCode;
	
	@Column(name = "devicecateory")
	private String deviceCategory;
	
	@Column(name = "deviceowner")
	private String deviceOwner;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "productiondate")
	private Date productionDate;
	
	@Column(name = "functionname")
	private String functionName;
	
	@Column(name = "functiondescription")
	private String functionDescription;
	
	@Column(name = "currentstatus")
	private String currentStatus;
	
	@Column(name = "operationdays")
	private Long operationDays;
	
	@Column(name = "loadstatus")
	private String loadStatus;

}
