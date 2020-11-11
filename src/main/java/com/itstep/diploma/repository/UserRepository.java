package com.itstep.diploma.repository;

import com.itstep.diploma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long>, JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username) throws Throwable;
}
