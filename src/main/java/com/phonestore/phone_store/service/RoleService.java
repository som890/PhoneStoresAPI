package com.phonestore.phone_store.service;

import com.phonestore.phone_store.dao.RoleDAO;
import com.phonestore.phone_store.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {


    @Autowired
    private RoleDAO roleRepository;

    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }
}
