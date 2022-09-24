package com.cash.history.repository;

import com.cash.history.model.Expense;
import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends Repository<Expense, Long> {
    List<Expense> findAll();

    Expense findById(long id);

    void save(Expense expense);

    void deleteById(long id);

    @Query("SELECT e from Expense e WHERE createdAt BETWEEN :originDate AND :issueDate")
    List<Expense> findAllByCreatedAtBetween(@Param("originDate") LocalDateTime originDate, @Param("issueDate") LocalDateTime issueDate);

}
