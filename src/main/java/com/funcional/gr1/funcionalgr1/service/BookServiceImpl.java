package com.funcional.gr1.funcionalgr1.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funcional.gr1.funcionalgr1.controller.dto.BookDto;
import com.funcional.gr1.funcionalgr1.repository.BookRepository;
import com.funcional.gr1.funcionalgr1.repository.model.BookEntity;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	
	@Override
	public Mono<BookDto> getBook(Integer bookId) {

		Mono<BookEntity> consulta= bookRepository.findById(bookId);
		System.out.println("Se ejecuto el get con id: "+ bookId);

		return bookRepository.findById(bookId)
				.map(book -> new BookDto( book.getId() ,book.getAuthor() , book.getIsbn() , book.getTitle() , book.getPrecio() ));
	}

	@Override
	public Mono<BookDto> crateBook(BookDto bookDto) {
		System.out.println("Se ejecuto el create con bookDto: "+ bookDto);
		return bookRepository.save(BookEntity.builder()
                .author(bookDto.author())
                .isbn(bookDto.isbn())
                .title(bookDto.title())
                .precio(bookDto.price())
                .build())
                .map(book -> new BookDto(book.getId(),book.getAuthor(),book.getIsbn(),book.getTitle(),book.getPrecio()));
	}

	@Override
	public Mono<BookDto> updateBook(Integer bookId, BookDto bookDto) {
		System.out.println("Se ejecuto el update con id: "+ bookId + " y bookDto: "+bookDto);
		return bookRepository.save(BookEntity.builder()
                .id(bookId)
                .author(bookDto.author())
                .isbn(bookDto.isbn())
                .title(bookDto.title())
                .precio(bookDto.price())
                .build())
                .map(book -> new BookDto(book.getId(),book.getAuthor(),book.getIsbn(),book.getTitle(),book.getPrecio()));
	}

	@Override
	public Mono<Void> deleteBook(Integer bookDto) {
		System.out.println("Se ejecuto el delete con id: "+ bookDto);
		return bookRepository.deleteById(bookDto);
	}

	@Override
	public Flux<BookDto> getAllBooks() {
		System.out.println("Se ejecuto el getAll ");
		return bookRepository.findAll()
				.map(bookEntity -> new  BookDto(bookEntity.getId(),bookEntity.getAuthor(),bookEntity.getIsbn(),bookEntity.getTitle(),bookEntity.getPrecio()));
	}


}
