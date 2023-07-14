package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AuthorService;
import com.example.demo.model.entity.AuthorEntity;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Api(tags = "作者相關")
@RestController
@RequestMapping("author")
public class AuthorController {
    private final AuthorService authorService;
    
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