package com.askme.askme.repository.jpa;

import com.askme.askme.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaUserRoleRepository extends JpaRepository<UserRole,Long>{

    UserRole save(UserRole ur);

    @Override
    Optional<UserRole> findById(Long aLong);

    List<UserRole> findAll();
}
