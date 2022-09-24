package com.cash.history.service;

import com.cash.history.model.Expense;
import com.cash.history.model.Wallet;
import com.cash.history.repository.ExpenseRepository;
import com.cash.history.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.cash.history.utils.Coalescing.firstNotNull;
import static com.cash.history.utils.StringUtils.capitalize;

@Service
public class WalletService {
    @Autowired
    private IncomeRepository incomeRepository;
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private MonthNameService monthNameService;
    public Wallet findCurrentMonthWallet() {
        /*
         * findWalletByOriginDateAndIssueDate
         * This builds new Wallet model and full it with current month transactions, from origin at issue date.
         */
        var issueDate = LocalDateTime.now();
        var originDate = issueDate.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
        var expenses = expenseRepository.findAllByCreatedAtBetween(originDate, issueDate);

        Double totalIncomeAmount = firstNotNull(incomeRepository.getTotalAmountWhereCreatedAtBetween(originDate, issueDate), 0D);
        var totalExpenseAmount = expenses.parallelStream().map(Expense::getAmount).reduce(0D, Double::sum);
        var total = totalIncomeAmount - totalExpenseAmount;
        var currentMonth = monthNameService.getMonthName(issueDate, "en-US");

        currentMonth = capitalize(currentMonth);
        return new Wallet(totalIncomeAmount, totalExpenseAmount, total, issueDate,originDate, currentMonth);
    }
}
