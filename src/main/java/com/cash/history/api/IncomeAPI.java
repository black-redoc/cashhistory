package com.cash.history.api;

import com.cash.history.model.Income;
import com.cash.history.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class IncomeAPI {

    private final IncomeService incomeService;

    @Autowired
    public IncomeAPI(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/income")
    List<Income> getIncomes() {
        return incomeService.findAll();
    }

    @GetMapping("/income/{id}")
    ResponseEntity getIncomeById(@PathVariable long id) {
        Income income = incomeService.findById(id);
        if (income == null)
            return new ResponseEntity<>(Map.of("error", "Income not found  with id " + id), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(income, HttpStatus.OK);
    }

    @PostMapping("/income")
    ResponseEntity<Income> createIncome(@RequestBody Income income) throws Exception {
        var newIncome = incomeService.save(income);
        return new ResponseEntity<>(newIncome, HttpStatus.CREATED);
    }

    @PutMapping("/income/{id}")
    ResponseEntity updateIncome(@PathVariable long id, @RequestBody Income income) {
        try {
            var currentIncome = incomeService.update(id, income);
            return new ResponseEntity<>(currentIncome, HttpStatus.CREATED);
        } catch(NullPointerException exception) {
            return new ResponseEntity<>(Map.of("error", "Not found income with id " + id), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/income/{id}")
    ResponseEntity<Map<String, Object>> deleteIncome(@PathVariable long id) {
        incomeService.deleteById(id);
        return new ResponseEntity<>(Map.of("success", true), HttpStatus.OK);
    }
}
