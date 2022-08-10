package com.generation.blogpessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.TemaModel;
import com.generation.blogpessoal.repository.TemaRepository;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {
	
		@Autowired
		private TemaRepository temaRepository;

		@GetMapping
		public ResponseEntity<List<TemaModel>> getAll() {
			return ResponseEntity.ok(temaRepository.findAll());

		}

		@PostMapping
		public ResponseEntity<TemaModel> postTema(@Valid @RequestBody TemaModel tema) {
			return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
		}

}
