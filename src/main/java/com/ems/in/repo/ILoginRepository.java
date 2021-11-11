package com.ems.in.repo;

import com.ems.in.entity.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILoginRepository extends JpaRepository<User, String>{

    public Optional<User> findByUserIdAndPassword(String userId, String password) ;
    
}
