package com.greenfoxacademy.the_reddit.repositories;

import com.greenfoxacademy.the_reddit.models.User;
import com.greenfoxacademy.the_reddit.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  public User findByName(String name);

  @Query(value = "SELECT v.type FROM Vote v INNER JOIN User u ON v.user_id = u.id INNER JOIN Post p ON v.post_id = p.id " +
          "WHERE u.name = ?1 AND p.id = ?2 AND v.type = ?3 ORDER BY v.id DESC LIMIT 1", nativeQuery = true)
  public String findVoteType(String userName, Long id, String type);


}
