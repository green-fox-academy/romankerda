package com.greenfoxacademy.the_reddit.repositories;

import com.greenfoxacademy.the_reddit.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

  public Optional<Vote> findByUser_idAndPost_id(Long uid, Long pid);

}
