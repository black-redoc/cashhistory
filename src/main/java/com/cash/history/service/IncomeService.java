package com.cash.history.service;

import com.cash.history.model.Income;
import com.cash.history.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.cash.history.utils.Coalescing.firstNotNull;

@Service
public class IncomeService {
    final IncomeRepository incomeRepository;

    @Autowired
    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public Income save(Income income) {
        income.setCreatedAt(LocalDateTime.now());
        incomeRepository.save(income);
        return income;
    }

    public Income findById(long id) {
        return incomeRepository.findById(id);
    }

    public List<Income> findAll() {
        return incomeRepository.findAll();
    }

    public Income update(long id, Income income) {
        var currentIncome = incomeRepository.findById(id);
        currentIncome.setAmount(firstNotNull(income.getAmount(), currentIncome.getAmount()));
        currentIncome.setConcept(firstNotNull(income.getConcept(), currentIncome.getConcept()));
        incomeRepository.save(currentIncome);
        return currentIncome;
    }

    public void deleteById(long id) {
        incomeRepository.deleteById(id);
    }
}
