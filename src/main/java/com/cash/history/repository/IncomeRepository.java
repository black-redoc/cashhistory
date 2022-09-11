package com.cash.history.repository;

import com.cash.history.model.Income;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface IncomeRepository extends Repository<Income, Long> {
    List<Income> findAll();
    Income findById(long id);
    void save(Income income);
    void deleteById(long income);
}
