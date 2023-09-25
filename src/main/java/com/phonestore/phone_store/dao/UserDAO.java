package com.phonestore.phone_store.dao;

import com.phonestore.phone_store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,String> {

}