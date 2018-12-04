package com.contatos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contatos.models.Pessoa;
import com.contatos.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public List<Pessoa> listarTodasAsPessoas() {
		Iterable<Pessoa> itr = repository.findAll();
		return (List<Pessoa>) itr;

	}

	public Pessoa salvarPessoa(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	public void deletarPessoaPorId(Long id) {
		repository.deleteById(id);
	}

	public Pessoa findById(long id) {
		return repository.getOne(id);
	}

	public void deletarUsuario(long id) {

		Pessoa pessoa = repository.getOne(id);
		repository.delete(pessoa);
	}
}
