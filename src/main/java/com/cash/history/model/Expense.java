package com.cash.history.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Entity
public class Expense {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String concept;

    @Column(nullable = false)
    private double amount;
    private LocalDateTime createdAt;

    public Expense() {
    }

    public Expense(String concept, double amount, LocalDateTime createdAt) {
        this.concept = concept;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
