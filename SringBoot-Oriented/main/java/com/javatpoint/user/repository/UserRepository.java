package com.javatpoint.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.user.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
