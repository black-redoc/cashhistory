package com.cash.history.repository;

import com.cash.history.model.Expense;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ExpenseRepository extends Repository<Expense, Long> {
    List<Expense> findAll();
    Expense findById(long id);
    void deleteById(long id);
    void save(Expense expense);
}
