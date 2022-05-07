package com.rakharafifa.miniproject.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.rakharafifa.miniproject.model.entity.Transaction;
import com.rakharafifa.miniproject.repository.TransactionRepository;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
    private final EasyRandom EASY_RANDOM = new EasyRandom();
    private Long id;

    @InjectMocks
    private TransactionServiceImpl service;

    @Mock
    private TransactionRepository repository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        id = EASY_RANDOM.nextObject(Long.class);
    }

    @Test
    void findAllTransaction(){
        List<Transaction> transactions = EASY_RANDOM.objects(Transaction.class, 2)
        .collect(Collectors.toList());

        when(repository.findAll()).thenReturn(transactions);
        service.getAllTransaction();
        verify(repository, times(1)).findAll();
    }

    @Test
    void findTransactionById(){
        Transaction transaction = EASY_RANDOM.nextObject(Transaction.class);
        System.out.println(transaction);

        when(repository.findById(transaction.getTransaction_id())).thenReturn(Optional.of(transaction));
        service.getTransactionById(transaction.getTransaction_id());
        verify(repository, times(1)).findById(transaction.getTransaction_id());
    }

    @Test
    void createNewTransaction(){
        Transaction transaction = EASY_RANDOM.nextObject(Transaction.class);
        System.out.println(transaction);

        when(repository.save(transaction)).thenReturn(transaction);
        service.createTransaction(transaction);
        verify(repository, times(1)).save(transaction);
    }

    @Test
    public void deleteTransactionById(){
        Transaction transaction = EASY_RANDOM.nextObject(Transaction.class);

        service.deleteTransaction(transaction.getTransaction_id());
        verify(repository).deleteById(transaction.getTransaction_id());
    }

    @Test
    public void whenGivenId_shouldUpdateUser_ifFound() {
        Transaction transaction = EASY_RANDOM.nextObject(Transaction.class);
        Transaction newTransaction = new Transaction();
        newTransaction.setPrice(50000L);

        when(repository.findById(transaction.getTransaction_id())).thenReturn(Optional.of(transaction));
        service.updateTransaction(transaction.getTransaction_id(), newTransaction);
        verify(repository).save(transaction);
        verify(repository).findById(transaction.getTransaction_id());
    }
}
