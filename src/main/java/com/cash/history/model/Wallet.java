package com.cash.history.model;

import java.time.LocalDateTime;

public class Wallet {
    private Double totalIncomeAmount;
    private Double totalExpenseAmount;
    private LocalDateTime issueDate;
    private LocalDateTime originDates;
    private String currentMonth;

    public Wallet(Double totalIncomeAmount, Double totalExpenseAmount, LocalDateTime issueDate, LocalDateTime startTransactionDates, String currentMonth) {
        this.totalIncomeAmount = totalIncomeAmount;
        this.totalExpenseAmount = totalExpenseAmount;
        this.issueDate = issueDate;
        this.originDates = startTransactionDates;
        this.currentMonth = currentMonth;
    }

    public Double getTotalIncomeAmount() {
        return totalIncomeAmount;
    }

    public void setTotalIncomeAmount(Double totalIncomeAmount) {
        this.totalIncomeAmount = totalIncomeAmount;
    }

    public Double getTotalExpenseAmount() {
        return totalExpenseAmount;
    }

    public void setTotalExpenseAmount(Double totalExpenseAmount) {
        this.totalExpenseAmount = totalExpenseAmount;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getOriginDates() {
        return originDates;
    }

    public void setOriginDates(LocalDateTime originDates) {
        this.originDates = originDates;
    }

    public String getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(String currentMonth) {
        this.currentMonth = currentMonth;
    }
}
