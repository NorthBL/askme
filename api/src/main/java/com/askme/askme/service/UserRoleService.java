package com.askme.askme.service;

import com.askme.askme.models.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRoleService {
    UserRole save(UserRole o);
    List<UserRole> findAll();
    UserRole findById(Long id);

}
