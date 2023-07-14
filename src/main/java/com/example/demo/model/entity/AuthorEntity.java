package com.example.demo.model.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "author")
public class AuthorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private Integer oid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "create_date")
	private OffsetDateTime createDate;
	
	@Column(name = "create_user")
	private String createUser;
}