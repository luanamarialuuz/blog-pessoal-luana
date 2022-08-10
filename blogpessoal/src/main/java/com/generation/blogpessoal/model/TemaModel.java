package com.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tema") 
public class TemaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	// trocar se o Long estiver com o L minusculo, e não esquecer dos getters e setters
	private Long id;
	

	@NotBlank(message = "O atributo descrição é Obrigatório e não pode utilizar espaços em branco!") 
	private String descricao;
	
	@OneToMany(mappedBy="tema")
	@JsonIgnoreProperties("tema")
	private List<PostagemModel> postagem;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}
