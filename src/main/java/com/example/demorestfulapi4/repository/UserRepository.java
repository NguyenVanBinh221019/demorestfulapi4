package com.example.demorestfulapi4.repository;

import com.example.demorestfulapi4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByIdBetween(Long start, Long end);
    User findByName(String lastname);

}
