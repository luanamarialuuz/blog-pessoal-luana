package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.PostagemModel;
import com.generation.blogpessoal.repository.PostagemRepository;

@RestController //responsável por responder as aquisições do http 
@RequestMapping("/postagens") //minha endpoint ou seja meu endereço de pesquisa
@CrossOrigin(origins = "*", allowedHeaders = "*") 

public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	@GetMapping
	public ResponseEntity<List<PostagemModel>>getAll (){
		return ResponseEntity.ok(postagemRepository.findAll());
	}
}
