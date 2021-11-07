package com.greenfoxacademy.programmer_fox_club.repositories;

import com.greenfoxacademy.programmer_fox_club.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoxRepository extends JpaRepository<Fox, Long> {


  @Query(value = "SELECT * FROM Fox f INNER JOIN User u on f.id = u.fox_id WHERE u.name = ?1", nativeQuery = true)
  Fox findFoxByUserName(String name);

  @Query(value = "SELECT f.food FROM Fox f INNER JOIN User u on f.id = u.fox_id WHERE u.name = ?1", nativeQuery = true)
  Food findFoodByUserName(String name);

  @Query(value = "SELECT * FROM Trick t LEFT JOIN Fox f on f.id = t.fox_id WHERE f.name = ?1", nativeQuery = true)
  List<Trick> findAllTricksByFoxName(String foxName);

}
