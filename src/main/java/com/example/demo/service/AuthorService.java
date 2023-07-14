package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.demo.dao.AuthorRepository;
import com.example.demo.model.entity.AuthorEntity;

@RequiredArgsConstructor
@Service
public class AuthorService {
	
	private final AuthorRepository authorRepository;
	
	public AuthorEntity createAuthor(AuthorEntity authorEntity) {
	    return authorRepository.save(authorEntity);
	}

	public List<AuthorEntity> findAuthorsWithBooks(Integer oid, Integer minAge, Integer maxAge) {
	    return authorRepository.findAuthorsWithBooks(oid, minAge, maxAge);
	}

	public AuthorEntity updateAuthor(AuthorEntity authorEntity) {
	    return authorRepository.save(authorEntity);
	}

	public void deleteAuthor(Integer oid) {
	    authorRepository.deleteById(oid);
	}

	
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