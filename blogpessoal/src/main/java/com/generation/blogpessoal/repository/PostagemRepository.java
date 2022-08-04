package com.generation.blogpessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.PostagemModel;

@Repository 
public interface PostagemRepository extends JpaRepository <PostagemModel, Long> {

}
