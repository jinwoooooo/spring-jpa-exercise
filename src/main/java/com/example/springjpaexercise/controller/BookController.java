package com.example.springjpaexercise.controller;

import com.example.springjpaexercise.domain.Book;
import com.example.springjpaexercise.domain.dto.BookResponse;
import com.example.springjpaexercise.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<List<BookResponse>> list(Pageable pageable){
        return ResponseEntity.ok().body(bookService.findBooks(pageable));
    }

}
