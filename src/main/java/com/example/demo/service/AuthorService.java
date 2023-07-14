package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.demo.dao.AuthorRepository;
import com.example.demo.model.entity.AuthorEntity;

@RequiredArgsConstructor
@Service
public class AuthorService {
	
	private final AuthorRepository authorRepository;
	
	public List<AuthorEntity> findAll() {
		return authorRepository.findAll();
	}
	
	public AuthorEntity findByName(String Name) {
		return authorRepository.findByName(Name);
	}
	
	public List<AuthorEntity> findByNameIn(List<String> nameList) {
		return authorRepository.findByNameIn(nameList);
	}

}