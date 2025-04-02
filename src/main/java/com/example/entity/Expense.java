package com.example.entity;



import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Component("exp")
@Table(name = "expenses") // Specifies the table name in the database
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID (primary key)
    @Column(name = "expense_id") // Column mapping for the expense ID
    private long expenseId;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Foreign Key
    private User user;

   

    @Column(name = "amount", nullable = false) // Amount spent
    private int amount;

    @Column(name = "description") // Description of the expense (optional)
    private String description;

    @Temporal(TemporalType.TIMESTAMP) // Specifies that this is a timestamp column
    @Column(name = "expense_date", nullable = false) // Date and time when the expense was made
    private Date expenseDate;

    public Expense() {
        // Default constructor (required by Hibernate)
    }

     

    public long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(long expenseId) {
        this.expenseId = expenseId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


  

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }
     

    public Expense(User user,  int amount, String description, Date expenseDate) {
		super();
		this.user= user;
		
		this.amount = amount;
		this.description = description;
		this.expenseDate = expenseDate;
	}
    

	@Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", userId=" + user +
               
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", expenseDate=" + expenseDate +
                '}';
    }
}