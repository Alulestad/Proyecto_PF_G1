package com.funcional.gr1.funcionalgr1;

import com.funcional.gr1.funcionalgr1.controller.BookController;
import com.funcional.gr1.funcionalgr1.controller.dto.BookDto;
import com.funcional.gr1.funcionalgr1.service.BookService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;


@RequiredArgsConstructor
@SpringBootApplication
public class Funcionalgr1Application implements CommandLineRunner{

	@NonNull
	private final BookController bookController;

	@NonNull
	private final BookService bookService;



	public static void main(String[] args) {
		SpringApplication.run(Funcionalgr1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		bookController.getBook(1).subscribe(val -> System.out.println("get: " + val));
		bookController.createBook(new BookDto(2,"JJ","isbn223","Urantia",new BigDecimal(30))).subscribe(val -> System.out.println("create: " + val));
		bookController.updateBook(1,new BookDto(1,"Miguel de Cervantes","isbn123","Don Quijote",new BigDecimal(15) )).subscribe(val -> System.out.println("update: " + val));
		bookService.getAllBooks().subscribe((val)->System.out.println("getAll: " + val));
		bookController.deleteBook(2).subscribe(val -> System.out.println("delete: " + val));


	}

}
