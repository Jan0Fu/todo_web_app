package com.todoapp.todoproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todoapp.todoproject.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
    User findTopByUsername(String username);
    User findTopByPassword(String password);
}
