package com.example.respository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Expense;
import com.example.entity.User;
@Repository
public interface ExpenseRespository  extends JpaRepository<Expense, Long>{
	List<Expense> findByUser(User user);  

	

	
	

}
