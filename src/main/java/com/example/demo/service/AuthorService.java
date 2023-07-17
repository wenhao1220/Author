package com.example.demo.service;

import java.sql.Date;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.example.demo.dao.AuthorDAO;
import com.example.demo.dao.AuthorJdbcRepository;
import com.example.demo.dao.AuthorRepository;
import com.example.demo.model.dto.AuthorInfoDto;
import com.example.demo.model.dto.AuthorInsertDto;
import com.example.demo.model.entity.authorentity;
import com.example.demo.model.entity.bookentity;

@RequiredArgsConstructor
@Service
public class AuthorService {

	private final AuthorRepository authorRepository;
	private final AuthorJdbcRepository authorJdbcRepository;
	private final AuthorDAO authorDAO;

	public class AuthorNotFoundException extends RuntimeException {
		public AuthorNotFoundException(String message) {
			super(message);
		}
	}

	// 新增作者
	@Transactional
	public authorentity postAuthor(AuthorInsertDto authorInsertDto) {
		authorentity authorEntity = new authorentity();
		authorEntity.setName(authorInsertDto.getAuthorName());
		authorEntity.setAge(authorInsertDto.getAuthorAge());
		authorEntity.setCreateDate(OffsetDateTime.now());
		authorRepository.save(authorEntity);
		return authorEntity;
	}

	// 修改作者
	@Transactional
	public authorentity updateAuthor(Integer authorOid, AuthorInsertDto authorInsertDto) {
		Optional<authorentity> optionalAuthorEntity = authorRepository.findById(authorOid);
		if (optionalAuthorEntity.isPresent()) {
			authorentity authorEntity = optionalAuthorEntity.get();
			authorEntity.setOid(authorOid);
			if (authorInsertDto.getAuthorName() != null) {
				authorEntity.setName(authorInsertDto.getAuthorName());
			}

			if (authorInsertDto.getAuthorAge() != null) {
				authorEntity.setAge(authorInsertDto.getAuthorAge());
			}
			return authorRepository.save(authorEntity);
		} else {
			throw new AuthorNotFoundException("Author not found with OID: " + authorOid);
		}
	}

	// 刪除作者
	@Transactional
	public void deleteAuthor(Integer oid) {
		Optional<authorentity> optionalAuthorEntity = authorRepository.findById(oid);
		if (optionalAuthorEntity.isPresent()) {
			authorRepository.deleteByOid(oid);
		} else {
			throw new AuthorNotFoundException("Author not found with OID: " + oid);
		}
	}

	public List<AuthorInfoDto> getAuthorInfo(Integer authorOid) {
		return authorDAO.getAuthorInfo(authorOid);
	}

	public void createAuthor(String name, Integer age, Date createDate) {
		authorJdbcRepository.createAuthor(name, age, createDate);
	}

	public Optional<Integer> findOidByName(String name) {
		return authorRepository.findOidByName(name);
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