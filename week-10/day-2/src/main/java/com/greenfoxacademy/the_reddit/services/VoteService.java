package com.greenfoxacademy.the_reddit.services;

import com.greenfoxacademy.the_reddit.models.Vote;
import com.greenfoxacademy.the_reddit.repositories.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteService {

  VoteRepository voteRepository;

  public VoteService(VoteRepository voteRepository) {
    this.voteRepository = voteRepository;
  }


  public void delete(Vote vote) {
    voteRepository.delete(vote);
  }

  public Optional<Vote> findByUser_idAndPost_id(Long userId, Long postId) {
    return voteRepository.findByUser_idAndPost_id(userId, postId);
  }

  public void save(Vote vote) {
    voteRepository.save(vote);
  }
}
