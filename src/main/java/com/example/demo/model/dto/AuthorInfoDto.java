package com.example.demo.model.dto;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorInfoDto {
    private Integer oid;
    private String authorName;
	private String bookName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;
}