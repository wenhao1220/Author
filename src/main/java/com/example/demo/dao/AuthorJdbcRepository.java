package com.example.demo.dao;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 新增作者，使用 JdbcTemplate
    public void createAuthor(String name, Integer age, Date createdate) {
        String sql = "INSERT INTO authorentity (name, age, create_date) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, name, age, createdate);
    }
}
