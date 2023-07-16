package com.example.demo.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.authorentity;
import com.example.demo.model.entity.bookentity;
import com.example.demo.service.AuthorService;

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
    @PostMapping("/authors")
    public void createAuthor(@RequestParam String name, @RequestParam Integer age, @RequestParam Date createDate) {
        authorService.createAuthor(name, age, createDate);
    }

	@ApiOperation("更新作者")
	@PutMapping("/{oid}")
	public int updateAuthor(@PathVariable Integer oid, @RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
	    return authorService.updateAuthor(oid, name, age);
	}

	@ApiOperation("刪除作者")
	@DeleteMapping("/{oid}")
	public void deleteAuthor(@PathVariable Integer oid) {
		authorService.deleteAuthor(oid);
	}

	@ApiOperation("查詢作者以及該作者底下的書籍")
	@GetMapping
	public List<authorentity> findOidByName(@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer minAge, @RequestParam(required = false) Integer maxAge) {
		return authorService.findOidByName(name, minAge, maxAge);
	}

	@ApiOperation("取得作者資訊")
	@GetMapping(value = "oid")
	public List<authorentity> findAll() {
		return authorService.findAll();
	}

	@ApiOperation("查詢作者資料(單)")
	@GetMapping(value = "name")
	public authorentity findByName(@RequestParam String name) {
		return authorService.findByName(name);
	}

	@ApiOperation("查詢作者資料(多)")
	@GetMapping(value = "names")
	public List<authorentity> findByNameIn(@RequestParam List<String> nameList) {
		return authorService.findByNameIn(nameList);
	}
}