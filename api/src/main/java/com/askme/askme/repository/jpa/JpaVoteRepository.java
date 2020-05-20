package com.askme.askme.repository.jpa;

import com.askme.askme.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVoteRepository extends JpaRepository<Vote,Long> {
}
