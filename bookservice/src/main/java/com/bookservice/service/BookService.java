package com.bookservice.service;

import com.bookservice.dto.BookDTO;
import com.bookservice.entity.Book;
import com.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public BookDTO createBook(BookDTO dto) {
        Book book = new Book(dto.getTitle(), dto.getAuthor(), dto.getIsbn(), dto.getAvailableCopies());
        Book saved = bookRepository.save(book);
        return toDto(saved);
    }

    public boolean decreaseCopies(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null || book.getAvailableCopies() <= 0) {
            return false;
        }
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
        return true;
    }

    public void increaseCopies(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);
    }

    private BookDTO toDto(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        dto.setAvailableCopies(book.getAvailableCopies());
        return dto;
    }
}
