package com.example.demo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.demo.dao.AuthorJdbcRepository;
import com.example.demo.dao.AuthorRepository;
import com.example.demo.model.entity.authorentity;
import com.example.demo.model.entity.bookentity;

@RequiredArgsConstructor
@Service
public class AuthorService {
	
	private final AuthorRepository authorRepository;
    private final AuthorJdbcRepository authorJdbcRepository;
	
	public void createAuthor(String name, Integer age, Date createDate) {
		authorJdbcRepository.createAuthor(name, age, createDate);
    }

	public List<authorentity> findOidByName(String name, Integer minAge, Integer maxAge) {
	    return authorRepository.findOidByName(name, minAge, maxAge);
	}

	public int updateAuthor(Integer oid, String name, Integer age) {
	    return authorRepository.updateAuthor(oid, name, age);
	}

	public void deleteAuthor(Integer oid) {
	    authorRepository.deleteAuthor(oid);
	}
	
	public List<authorentity> findAll() {
		return authorRepository.findAll();
	}
	
	public authorentity findByName(String Name) {
		return authorRepository.findByName(Name);
	}
	
	public List<authorentity> findByNameIn(List<String> nameList) {
		return authorRepository.findByNameIn(nameList);
	}
	

}