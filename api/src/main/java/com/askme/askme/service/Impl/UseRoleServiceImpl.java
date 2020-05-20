package com.askme.askme.service.Impl;

import com.askme.askme.exceptions.UserRoleNotFoundException;
import com.askme.askme.models.UserRole;
import com.askme.askme.repository.jpa.JpaUserRoleRepository;
import com.askme.askme.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UseRoleServiceImpl implements UserRoleService{

    @Autowired
    private JpaUserRoleRepository userRoleRepository;


    @Override
    public UserRole save(UserRole o) {
        return userRoleRepository.save(o);
    }

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole findById(Long id) {
       Optional<UserRole> ur = userRoleRepository.findById(id);
       if(!ur.isPresent()){
           throw  new UserRoleNotFoundException();
       }
       return ur.get();
    }
}
