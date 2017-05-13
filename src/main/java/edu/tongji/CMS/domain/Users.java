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
	
	@Column(name = "status")
	@NotEmpty(message = "Status is required.")
	private String status;
	
	@Column(name = "personal_statement")
	private String personal_statement;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_category() {
		return user_category;
	}

	public void setUser_category(String user_category) {
		this.user_category = user_category;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public String getU_scale() {
		return u_scale;
	}

	public void setU_scale(String u_scale) {
		this.u_scale = u_scale;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPersonal_statement() {
		return personal_statement;
	}

	public void setPersonal_statement(String personal_statement) {
		this.personal_statement = personal_statement;
	}
}
