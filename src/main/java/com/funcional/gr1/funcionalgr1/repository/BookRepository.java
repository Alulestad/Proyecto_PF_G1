package com.funcional.gr1.funcionalgr1.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.funcional.gr1.funcionalgr1.repository.model.BookEntity;

public interface BookRepository extends R2dbcRepository<BookEntity, Integer>{

}
