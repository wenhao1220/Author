package com.example.demo.model.dto;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorInsertDto {
	private Integer authorAge;
    private String authorName;
}