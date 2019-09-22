package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t_user_role")
public class UserRole {
	@Id
	@SequenceGenerator(name = "t_ur_seq", sequenceName="t_ur_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "t_ur_seq")
	@Column(name="id")
	private Integer id;
	@Column(name="u_id")
	private Integer uid;
	@Column(name="r_id")
	private Integer rid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	
}
