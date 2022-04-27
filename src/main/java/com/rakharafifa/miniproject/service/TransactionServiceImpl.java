package com.rakharafifa.miniproject.service;

import java.util.ArrayList;
import java.util.List;

import com.rakharafifa.miniproject.model.entity.Transaction;
import com.rakharafifa.miniproject.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAllTransaction() {
        List<Transaction> transactions = new ArrayList<>();
        transactionRepository.findAll().forEach(transactions::add);
        return transactions;
    }

    @Override
    public Transaction getTransactionById(Long transaction_id) {
        return transactionRepository.findById(transaction_id).get();
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void updateTransaction(Long transaction_id, Transaction transaction) {
        Transaction transaction2 = transactionRepository.findById(transaction_id).get();
        System.out.println(transaction2.toString());
        transaction2.setPrice(transaction.getPrice());
        transaction2.setTotal_price(transaction.getTotal_price());
        transactionRepository.save(transaction2);
    }

    @Override
    public void deleteTransaction(Long transaction_id) {
        transactionRepository.deleteById(transaction_id);
        
    }
}
