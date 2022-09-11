package com.cash.history.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Expense {
    private long id;
    private String concept;
    private double amount;
    private LocalDateTime createdAt;
}
