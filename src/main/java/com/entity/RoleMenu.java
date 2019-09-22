package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t_role_menu")
public class RoleMenu {
	@Id
	@SequenceGenerator(sequenceName="t_rm_seq",name="t_rm_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="t_rm_seq")
	@Column(name="id")
	private Integer id;
	@Column(name="rid")
	private Integer rid;
	@Column(name="mid")
	private Integer mid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	
}
