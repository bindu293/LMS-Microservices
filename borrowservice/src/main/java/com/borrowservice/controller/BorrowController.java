package com.borrowservice.controller;

import com.borrowservice.entity.BorrowRecord;
import com.borrowservice.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    // Borrow a Book
    @PostMapping
    public ResponseEntity<BorrowRecord> borrowBook(@RequestBody BorrowRecord record) {
        return ResponseEntity.ok(borrowService.borrowBook(record));
    }

    // Get Borrow History for a User
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BorrowRecord>> getBorrowHistory(@PathVariable Long userId) {
        return ResponseEntity.ok(borrowService.getBorrowedBooksByUser(userId));
    }

    // Return a Book
    @PutMapping("/return/{borrowId}")
    public ResponseEntity<String> returnBook(@PathVariable Long borrowId) {
        return ResponseEntity.ok(borrowService.returnBook(borrowId));
    }
}
