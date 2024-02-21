package com.funcional.gr1.funcionalgr1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funcional.gr1.funcionalgr1.controller.dto.BookDto;
import com.funcional.gr1.funcionalgr1.service.BookService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Controller
@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
	
	
	private final BookService bookService;
	
	@GetMapping("/{bookId}")
	public Mono<BookDto> getBook(@PathVariable("bookId") Integer bookId){
		return bookService.getBook(bookId);
	}
	
	@PostMapping
	public Mono <BookDto> createBook(@RequestBody BookDto bookDto){
		
		return bookService.crateBook(bookDto);
	}
	
	@PutMapping("/{bookId}")
	public Mono <BookDto> updateBook(@PathVariable("bookId")Integer bookId, @RequestBody BookDto bookDto){
		
		return bookService.updateBook(bookId, bookDto);
	}
	@DeleteMapping("/{bookId}")
	public Mono<Void> deleteBook(@PathVariable("bookId") Integer bookId){
		
		return bookService.deleteBook(bookId);
	}
	
	
	
	
	
}
