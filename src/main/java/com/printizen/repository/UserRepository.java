package com.printizen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.printizen.entity.User;



public interface UserRepository extends JpaRepository<User, Long>{
   
}