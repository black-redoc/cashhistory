package com.cash.history.repository;

import com.cash.history.model.Income;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.time.LocalDateTime;
import java.util.List;

public interface IncomeRepository extends Repository<Income, Long> {
    List<Income> findAll();

    Income findById(long id);

    void save(Income income);

    void deleteById(long income);

    @Query(value = "SELECT SUM(amount) FROM income WHERE created_at BETWEEN ?1 AND ?2", nativeQuery = true)
    Double getTotalAmountWhereCreatedAtBetween(LocalDateTime originDate, LocalDateTime issueDate);
}
