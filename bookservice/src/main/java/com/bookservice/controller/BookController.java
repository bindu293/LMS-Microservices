package com.bookservice.controller;

import com.bookservice.dto.BookDTO;
import com.bookservice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO dto) {
        return ResponseEntity.ok(bookService.createBook(dto));
    }

    // Called by Borrow-Service later
    @PostMapping("/{id}/decrease")
    public ResponseEntity<String> decreaseCopies(@PathVariable Long id) {
        boolean ok = bookService.decreaseCopies(id);
        return ok ?
                ResponseEntity.ok("Copies decreased") :
                ResponseEntity.badRequest().body("Not available");
    }

    @PostMapping("/{id}/increase")
    public ResponseEntity<String> increaseCopies(@PathVariable Long id) {
        bookService.increaseCopies(id);
        return ResponseEntity.ok("Copies increased");
    }
}
