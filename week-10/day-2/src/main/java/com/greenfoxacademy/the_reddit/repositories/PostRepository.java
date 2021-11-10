package com.greenfoxacademy.the_reddit.repositories;

import com.greenfoxacademy.the_reddit.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  @Query(value = "SELECT * FROM post ORDER BY points DESC LIMIT 10 OFFSET ?1", nativeQuery = true)
  public List<Post> getPage(int offset);
}
