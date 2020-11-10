package com.itstep.diploma.repository;

import com.itstep.diploma.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories(" sample.data.jpa.service ")
public interface BalanceRepository extends JpaRepository<Balance, Long> {

}
