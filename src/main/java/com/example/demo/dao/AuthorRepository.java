package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.entity.AuthorEntity;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

    AuthorEntity findByName(String name);

    List<AuthorEntity> findByNameIn(List<String> nameList);

    @Query("select author.oid from AuthorEntity author where author.name = :name")
    Optional<Integer> findOidByName(String name);

}