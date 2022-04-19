package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer>{

}
