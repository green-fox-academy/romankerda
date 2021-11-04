package com.greenfoxacademy.programmer_fox_club.repositories;

import com.greenfoxacademy.programmer_fox_club.models.Fox;
import com.greenfoxacademy.programmer_fox_club.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoxRepository extends JpaRepository<Fox, Long> {

}
