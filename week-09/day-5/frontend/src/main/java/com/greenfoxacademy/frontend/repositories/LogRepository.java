package com.greenfoxacademy.frontend.repositories;

import com.greenfoxacademy.frontend.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

  @Query("SELECT COUNT (l.id) FROM Log l")
  int countLogs();

  @Query("SELECT l FROM Log l")
  List<Log> listLogs();

}
