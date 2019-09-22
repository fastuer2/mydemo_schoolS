package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="t_user")
public class User {
	@Id
	@SequenceGenerator(name = "t_u_seq", sequenceName="t_u_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "t_u_seq")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	@Column(name="phone")
	private String phone;
	@Column(name="ctime")
	private Date ctime;
	public User() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	
}
