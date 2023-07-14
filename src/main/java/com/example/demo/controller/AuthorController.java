package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AuthorService;
import com.example.demo.model.entity.AuthorEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Api(tags = "作者相關")
@RestController
@RequestMapping("author")
public class AuthorController {
    private final AuthorService authorService;
    
    @ApiOperation("新增作者")
    @PostMapping
    public AuthorEntity postBook(@RequestBody AuthorEntity authorEntity) {
        return authorService.createAuthor(authorEntity);
    }

    @ApiOperation("更新作者")
    @PutMapping
    public AuthorEntity updateAuthor(@RequestBody AuthorEntity authorEntity) {
        return authorService.updateAuthor(authorEntity);
    }

    @ApiOperation("刪除作者")
    @DeleteMapping(value = "{oid}")
    public void deleteAuthor(@PathVariable Integer oid) {
        authorService.deleteAuthor(oid);
    }
    
    @ApiOperation("查詢作者以及該作者底下的書籍")
    @GetMapping(value = "{oid}")
    public List<AuthorEntity> findAuthorsWithBooks(@PathVariable Integer oid,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge) {
        return authorService.findAuthorsWithBooks(oid, minAge, maxAge);
    }
    
    @ApiOperation("取得作者資訊")
    @GetMapping
    public List<AuthorEntity> findAll() {
        return authorService.findAll();
    }
    
    @ApiOperation("查詢作者資料(單)")
    @GetMapping(value = "name")
    public AuthorEntity findByName(@RequestParam String name) {
        return authorService.findByName(name);
    }
    
    @ApiOperation("查詢作者資料(多)")
    @GetMapping(value = "names")
    public List<AuthorEntity> findByNameIn(@RequestParam List<String> nameList) {
        return authorService.findByNameIn(nameList);
    }
}