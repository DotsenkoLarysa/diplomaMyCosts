package com.itstep.diploma.repository;

import com.itstep.diploma.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories(" sample.data.jpa.service ")
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
}
