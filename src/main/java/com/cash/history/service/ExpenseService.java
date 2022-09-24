package com.cash.history.service;

import com.cash.history.model.Expense;
import com.cash.history.model.Income;
import com.cash.history.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.cash.history.utils.Coalescing.firstNotNull;

@Service
public class ExpenseService {
    final ExpenseRepository expenseRepository;
    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    public List<Expense> findAll(){
        return expenseRepository.findAll();
    }
    public Expense findById(long id){
        return expenseRepository.findById(id);
    }
    public Expense update(long id, Expense expense){
        var currentExpense = expenseRepository.findById(id);
        currentExpense.setAmount(firstNotNull(expense.getAmount(), currentExpense.getAmount()));
        currentExpense.setConcept(firstNotNull(expense.getConcept(), currentExpense.getConcept()));
        expenseRepository.save(currentExpense);
        return currentExpense;
    }
    public void deleteById(long id){
        expenseRepository.deleteById(id);
    }
    public Expense save(Expense expense){
        expense.setCreatedAt(LocalDateTime.now());
        expenseRepository.save(expense);
        return expense;
    }
}
