package com.example.demo.dao.user;

import com.example.demo.model.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<Users, Long> {

    @Query("select u from Users u where u.username =:username")
    Optional<Users> getByUsername(@Param("username") String username);
}
