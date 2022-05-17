package com.rakharafifa.miniproject.service;

import java.util.List;

import com.rakharafifa.miniproject.model.dto_create.CreateTransactionDTO;
import com.rakharafifa.miniproject.model.dto_get.TransactionDto;
import com.rakharafifa.miniproject.model.entity.Transaction;

public interface TransactionService {
    List<Transaction> getAllTransaction();
    List<TransactionDto> getAllTransactionDto();
    Transaction getTransactionById(Long transaction_id);
    void createTransactionDto(CreateTransactionDTO createTransactionDTO);
    void updateTransaction(Long transaction_id, Transaction transaction);
    void deleteTransaction(Long transaction_id);
}
