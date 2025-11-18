package com.borrowservice.service;

import com.borrowservice.entity.BorrowRecord;
import com.borrowservice.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Override
    public BorrowRecord borrowBook(BorrowRecord record) {
        record.setBorrowDate(LocalDate.now());
        record.setReturned(false);
        return borrowRecordRepository.save(record);
    }

    @Override
    public List<BorrowRecord> getBorrowedBooksByUser(Long userId) {
        return borrowRecordRepository.findByUserId(userId);
    }

    @Override
    public String returnBook(Long borrowId) {
        BorrowRecord record = borrowRecordRepository.findById(borrowId)
                .orElse(null);

        if (record == null) {
            return "Borrow Record Not Found";
        }

        record.setReturned(true);
        record.setReturnDate(LocalDate.now());
        borrowRecordRepository.save(record);
        return "Book Returned Successfully";
    }
}
