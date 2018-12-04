package com.contatos.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pessoa")
/**
 * Representação em classe da tabela de Pessoa do banco de dados.
 * 
 * @author Warley
 *
 */
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false, length = 50)
	@NotBlank(message = "O nome é obrigatório!")
	private String nome;

	@Column(nullable = false, length = 50)
	@NotBlank(message = "O telefone é obrigatório!")
	private String telefone;

	@Column(nullable = false, length = 50)
	@NotBlank(message = "O email é obrigatório!")
	private String email;

	@Column
	private String empresa;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "contatos", joinColumns = @JoinColumn(name = "idpessoa"), inverseJoinColumns = @JoinColumn(name = "id"))
	private List<Contato> contatos;

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

}
