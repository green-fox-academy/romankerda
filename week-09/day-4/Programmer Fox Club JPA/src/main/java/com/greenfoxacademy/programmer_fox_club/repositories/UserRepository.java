package com.greenfoxacademy.programmer_fox_club.repositories;

import com.greenfoxacademy.programmer_fox_club.models.Trick;
import com.greenfoxacademy.programmer_fox_club.models.TrickEnum;
import com.greenfoxacademy.programmer_fox_club.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByName(String name);

//  @Query(value = "SELECT * FROM Trick t " +
//          "INNER JOIN Fox f on t.fox_id = f.id " +
//          "INNER JOIN User u on u.fox_id = f.id" +
//          "WHERE u.name = ?1", nativeQuery = true)
//  List<Trick> findAllTricksByUserName(String name);

}
