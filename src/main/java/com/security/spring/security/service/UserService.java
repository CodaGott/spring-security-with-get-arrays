package com.security.spring.security.service;

import com.security.spring.security.model.Role;
import com.security.spring.security.model.User;

import java.util.List;

public interface UserService {
    User saveUser (User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();
}
