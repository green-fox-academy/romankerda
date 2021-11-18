package com.greenfoxacademy.sage_chat.repositories;


import com.greenfoxacademy.sage_chat.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByLogin(String login);
  User findByUsername(String username);
}
