package com.cash.history.api;

import com.cash.history.model.Expense;
import com.cash.history.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ExpenseAPI {
    private final ExpenseService expenseService;
    @Autowired
    public ExpenseAPI(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @GetMapping("/expense")
    List<Expense> getExpenses(){
        return expenseService.findAll();
    }
    @GetMapping("/expense/{id}")
    ResponseEntity getIncomeById(@PathVariable long id){
        Expense expense = expenseService.findById(id);
        if(expense == null){
            return new ResponseEntity<>(Map.of("error", "Expense not found with id "+ id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }
    @PostMapping("/expense")
    ResponseEntity<Expense> createExpense(@RequestBody Expense expense) throws Exception{
        var newExpense = expenseService.save(expense);
        return new ResponseEntity<>(newExpense, HttpStatus.CREATED);
    }
    @PutMapping("/expense/{id}")
    ResponseEntity updateExpense(@PathVariable long id, @RequestBody Expense expense){
        try{
            var currentExpense = expenseService.update(id, expense);
            return new ResponseEntity<>(currentExpense, HttpStatus.CREATED);
        } catch (NullPointerException exception){
            return new ResponseEntity<>(Map.of("error", "Income with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/expense/{id}")
    ResponseEntity<Map<String, Object>> deleteIncome(@PathVariable long id){
        expenseService.deleteById(id);
        return new ResponseEntity<>(Map.of("success", true), HttpStatus.OK);
    }
}
