package com.generation.blogpessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

		@GetMapping("/{id}")
		public ResponseEntity<TemaModel> getById(@PathVariable Long id) {
			return temaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> deletePostagem(@PathVariable Long id) {
			
			return temaRepository.findById(id)
					.map(resposta -> {
						temaRepository.deleteById(id);
						return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
					})
					.orElse(ResponseEntity.notFound().build());
		}
		
		@PutMapping
		public ResponseEntity<TemaModel> putTema(@Valid @RequestBody TemaModel tema) {
						
			return temaRepository.findById(tema.getId())
					.map(resposta -> {
						return ResponseEntity.ok().body(temaRepository.save(tema));
					})
					.orElse(ResponseEntity.notFound().build());

		}



		

}
