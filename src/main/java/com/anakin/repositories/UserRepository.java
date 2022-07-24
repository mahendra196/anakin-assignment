package com.anakin.repositories;

import com.anakin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserNameAndPassword(String userName, String password);
    User findByUserName(String userName);
}
