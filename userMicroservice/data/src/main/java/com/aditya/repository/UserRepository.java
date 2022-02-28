package com.aditya.repository;

import com.aditya.user_entities.UserValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserValue,Long> {


}
