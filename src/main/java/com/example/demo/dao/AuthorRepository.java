package com.example.demo.dao;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.model.entity.authorentity;
import com.example.demo.model.entity.bookentity;
import lombok.Data;

@Repository
public interface AuthorRepository extends JpaRepository<authorentity, Integer> {

	void deleteByOid(Integer oid);
	
	authorentity findByName(String name);

	List<authorentity> findByNameIn(List<String> nameList);
	
	// 根據條件查詢作者以及其底下的書籍
	@Query("select author.oid from authorentity author where author.name = :name")
    Optional<Integer> findOidByName(String name);

	//刪除作者
	@Modifying
	@Transactional
	@Query("DELETE FROM authorentity author WHERE author.oid = :oid AND NOT EXISTS (SELECT 1 FROM bookentity book WHERE book.authorOid = author.oid)")
	int deleteAuthor(@Param("oid") Integer oid);

}