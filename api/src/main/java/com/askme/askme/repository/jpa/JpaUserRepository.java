package com.askme.askme.repository.jpa;

import com.askme.askme.models.Projections.UserProjection;
import com.askme.askme.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaUserRepository extends JpaRepository<User,Long> {

    User save(User u);
    User findByUsername(String username);
    List<UserProjection> findAllBy();
}
