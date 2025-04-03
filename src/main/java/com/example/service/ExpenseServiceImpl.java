package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Expense;
import com.example.entity.User;
import com.example.respository.ExpenseRespository;
@Service
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	private ExpenseRespository expenseRespository;

	@Override
	public void addExpense(Expense expense) {
		expenseRespository.save(expense);

	}

	@Override
	public Expense updateExpense(Expense expense) {
		
		return expenseRespository.save(expense);
	}

	@Override
	public void deleteExpense(Expense expense) {
		expenseRespository.delete(expense);
	}

	@Override
	public Expense findById(long expenseId) {
		// TODO Auto-generated method stub
		return expenseRespository.findById(expenseId).get();
	}

	@Override
	public List<Expense> findAll(){ 
		// TODO Auto-generated method stub
		return expenseRespository.findAll();
	}
	 @Override
	    public List<Expense> getExpensesByUser(User user) {
	        return expenseRespository.findByUser(user);
	    }
	 @Override
	 public void deleteExpense(long id)
	 {
		 expenseRespository.deleteById(id);
	 }
	 

}
