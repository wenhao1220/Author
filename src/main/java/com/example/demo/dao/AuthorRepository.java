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

	authorentity findByName(String name);

	List<authorentity> findByNameIn(List<String> nameList);
	
	// 根據條件查詢作者以及其底下的書籍
	@Query("SELECT DISTINCT author FROM authorentity author JOIN FETCH author.books WHERE (:name is null OR author.name = :name) AND (:minAge is null OR author.age >= :minAge) AND (:maxAge is null OR author.age <= :maxAge)")
	List<authorentity> findOidByName(@Param("name") String name, @Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);
	
	//更新作者
	@Modifying
	@Transactional
	@Query("UPDATE authorentity author SET " +
	        "author.name = CASE WHEN :name IS NULL THEN author.name ELSE :name END, " +
	        "author.age = CASE WHEN :age IS NULL THEN author.age ELSE :age END " +
	        "WHERE author.oid = :oid")
	int updateAuthor(@Param("oid") Integer oid, @Param("name") String name, @Param("age") Integer age);

	//刪除作者
	@Modifying
	@Transactional
	@Query("DELETE FROM authorentity author WHERE author.oid = :oid AND NOT EXISTS (SELECT 1 FROM bookentity book WHERE book.authorOid = author.oid)")
	int deleteAuthor(@Param("oid") Integer oid);

}