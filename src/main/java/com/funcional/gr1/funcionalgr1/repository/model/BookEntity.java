package com.funcional.gr1.funcionalgr1.repository.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Table("book")
public class BookEntity {
	
	@Id
	Integer id;

	@Column(value = "author")
	String author;

	@Column(value = "isbn")
	String isbn;

	@Column(value = "title")
	String title;

	@Column(value = "price")
	BigDecimal precio;
	

	
}
