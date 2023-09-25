package com.phonestore.phone_store.dao;

import com.phonestore.phone_store.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role,String> {
}