package com.contatos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contatos.models.Pessoa;
import com.contatos.repository.PessoaRepository;

/**
 * Classe de serviço pessoas
 * 
 * @author Warley
 *
 */
@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	/**
	 * Atribui a responsabilidade de listar todos as pessoas
	 * 
	 * @return
	 */
	public List<Pessoa> listarTodasAsPessoas() {
		return repository.findAll();
	}

	/**
	 * Atribui a responsabilidade de salvar a pessoa
	 * 
	 * @param pessoa
	 * @return
	 */
	public Pessoa salvarPessoa(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	/**
	 * Atribui a responsabilidade de apagar a pessoa por ID
	 * 
	 * @param id
	 */
	public void deletarPessoaPorId(Long id) {
		repository.deleteById(id);
	}

	/**
	 * Atribui a responsabilidade de encontrar a pessoa por ID
	 * 
	 * @param id
	 * @return
	 */
	public Pessoa findById(long id) {
		return repository.getOne(id);
	}

	/**
	 * Atribui a responsabilidade de deletar a pessoa por ID
	 * 
	 * @param id
	 */
	public void deletarUsuario(long id) {
		Pessoa pessoa = findById(id);
		repository.delete(pessoa);
	}
}
