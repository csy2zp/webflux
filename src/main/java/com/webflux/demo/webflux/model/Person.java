package com.webflux.demo.webflux.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonGetter;

@Entity
@Table(name="person")
public class Person extends StringIdentifier{
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private int age;
	
	private Date createDate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Transient
	@JsonGetter
	public String getDate() {
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(createDate);
	}
}
