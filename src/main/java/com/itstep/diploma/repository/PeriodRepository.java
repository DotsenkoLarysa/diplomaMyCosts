package com.itstep.diploma.repository;

import com.itstep.diploma.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories(" sample.data.jpa.service ")
public interface PeriodRepository extends JpaRepository<Period, Integer> {
}
