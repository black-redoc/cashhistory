package com.cash.history.model;

import java.time.LocalDateTime;

public class Wallet {
    private Double totalIncomeAmount;
    private Double totalExpenseAmount;
    private Double currentWalletAmount;
    private LocalDateTime issueDate;
    private LocalDateTime originDate;
    private String currentMonth;

    public Wallet(Double totalIncomeAmount, Double totalExpenseAmount, Double currentWalletAmount, LocalDateTime issueDate, LocalDateTime originDate, String currentMonth) {
        this.totalIncomeAmount = totalIncomeAmount;
        this.totalExpenseAmount = totalExpenseAmount;
        this.currentWalletAmount = currentWalletAmount;
        this.issueDate = issueDate;
        this.originDate = originDate;
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

    public Double getCurrentWalletAmount() {
        return this.currentWalletAmount;
    }

    public void setCurrentWalletAmount(Double currentWalletAmount) {
        this.currentWalletAmount = currentWalletAmount;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getOriginDate() {
        return originDate;
    }

    public void setOriginDate(LocalDateTime originDate) {
        this.originDate = originDate;
    }

    public String getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(String currentMonth) {
        this.currentMonth = currentMonth;
    }
}
