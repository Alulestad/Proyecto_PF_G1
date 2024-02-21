package com.funcional.gr1.funcionalgr1.service;

import com.funcional.gr1.funcionalgr1.controller.dto.BookDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
	
	Mono<BookDto> getBook(Integer bookId);
	
	Mono<BookDto> crateBook(BookDto bookDto);
	
	Mono<BookDto> updateBook(Integer bookId, BookDto bookDto);
	
	Mono<Void> deleteBook(Integer bookDto);

	Flux<BookDto> getAllBooks();
	
	
	
}
