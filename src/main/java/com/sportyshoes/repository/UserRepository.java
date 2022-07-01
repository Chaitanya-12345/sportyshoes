package com.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sportyshoes.model.User;


public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Transactional
	@Modifying
    @Query("Update User u SET u.password=:pwd WHERE u.firstname=:username")
    public void updatePassword(@Param("username") String usename, @Param("pwd") String pwd);
	

}
