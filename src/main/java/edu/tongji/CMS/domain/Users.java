package edu.tongji.CMS.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.tongji.CMS.domain.vo.UserStatus;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author ouzhou
 */

@Data
@Entity
@Table(name = "user_info")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "username")
	@NotEmpty(message = "User name is required.")
	private String username;

	@Column(name = "user_category")
	@NotEmpty(message = "Personal category is required.")
	private String user_category;
	
	@Column(name = "tel")
	@NotEmpty(message = "Telephone is required.")
	private Long tel;
	
	@Column(name = "u_scale")
	private String u_scale;
	
	@Column(name = "field")
	private String field;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "location")
	private String location;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	@NotEmpty(message = "Status is required.")
	private UserStatus status;
	
	@Column(name = "personal_statement")
	private String personal_statement;

}
