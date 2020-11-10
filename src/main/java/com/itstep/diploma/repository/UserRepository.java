package com.itstep.diploma.repository;

import com.itstep.diploma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories(" sample.data.jpa.service ")
public interface UserRepository extends JpaRepository <User, Long>{

    public Optional<User> findUserByUsername(String username)throws Throwable;

  //  @Query("SELECT u FROM User u WHERE u.username = :username")
  //  Stream<User> findByUsernameReturnStream(@Param("username")String username);

   // @Query("SELECT u FROM User u WHERE u.user_id = :user_id")
   // Stream<User> findUserByIdReturnStream(@Param("user_id")long user_id);

}
