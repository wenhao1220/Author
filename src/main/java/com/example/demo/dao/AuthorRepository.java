package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.entity.AuthorEntity;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

    AuthorEntity findByName(String name);

    List<AuthorEntity> findByNameIn(List<String> nameList);

    @Query("select author.oid from AuthorEntity author where author.name = :name")
    Optional<Integer> findOidByName(Integer oid);

    // 根據條件查詢作者以及其底下的書籍
    @Query("SELECT author FROM AuthorEntity author WHERE " +
            "(:name IS NULL OR author.name = :name) AND " +
            "(:minAge IS NULL OR author.age >= :minAge) AND " +
            "(:maxAge IS NULL OR author.age <= :maxAge)")
    List<AuthorEntity> findAuthorsWithBooks(
            @Param("name") Integer oid,
            @Param("minAge") Integer minAge,
            @Param("maxAge") Integer maxAge);

}