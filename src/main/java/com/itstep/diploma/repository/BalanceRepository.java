package com.itstep.diploma.repository;

import com.itstep.diploma.model.Balance;
import com.itstep.diploma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories(" sample.data.jpa.service ")
public interface BalanceRepository extends JpaRepository<Balance, Long> {

    List<Balance> findByUser(User user);

    @Query("select u from Balance  u where u.create_date= :create_date")
    List<Balance> getBalanceByCreate_date(@Param("create_date") String create_date);

}
