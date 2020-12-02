package com.itstep.diploma.repository;

import com.itstep.diploma.model.Category;
import com.itstep.diploma.model.Journal;
import com.itstep.diploma.model.Transaction;
import com.itstep.diploma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories(" sample.data.jpa.service ")
public interface JournalRepository extends JpaRepository<Journal, Long> {
    List<Journal>  findAll();
    List<Journal> findByCategory(Category category);
    List<Journal> findByTransaction(Transaction transaction);
    List<Journal> findByUser(User user);

    @Query("select u from Journal u where u.user= :username and u.event_date between :startDate and :endDate")
    List<Journal> getAllBetweenDates(@Param("username")String username, @Param("startDate")Date startDate, @Param("endDate")Date endDate);

    //@Query("select u from Journal u where u.category= :categoryID and u.transaction= :transactionID and u.user= :userID")
   // List<Journal> getAllByParams(@Param("categoryId")int categoryId, @Param("transactionId")int transactionId,
    //                             @Param("userId")Long userId);

}
