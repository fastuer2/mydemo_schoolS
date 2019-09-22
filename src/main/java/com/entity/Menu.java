package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t_menu")
public class Menu {
	@Id
	@SequenceGenerator(sequenceName="t_m_seq",name="t_m_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="t_m_seq")
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="url")
	private String url;
	@Column(name="parentid")
	private Integer parentid;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", url=" + url + ", parentid=" + parentid + "]";
	}
	
}
