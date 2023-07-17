package com.example.demo.model.entity;

import java.time.OffsetDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "bookentity")
public class bookentity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
    private Integer oid;
	
	@Column(name = "author_oid")
	private Integer authorOid;
	
	@Column(name = "publication_date")
    private Date publicationDate;
	
	@Column(name = "name")
	private String name;

    // 正常應該是@CreationTimestamp,不過課程的資料庫中沒有更新時間,就先拿來用
	@Column(name = "create_date")
    @UpdateTimestamp
	private OffsetDateTime createDate;
}