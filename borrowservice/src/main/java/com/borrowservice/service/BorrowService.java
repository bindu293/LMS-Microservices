package com.borrowservice.service;

import com.borrowservice.entity.BorrowRecord;
import java.util.List;

public interface BorrowService {

    BorrowRecord borrowBook(BorrowRecord record);

    List<BorrowRecord> getBorrowedBooksByUser(Long userId);

    String returnBook(Long borrowId);
}
