package com.contatos.service;

import com.contatos.models.Pessoa;
import com.contatos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public List<Pessoa> listarTodasAsPessoas() {
		return repository.findAll();
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
		Pessoa pessoa = findById(id);
		repository.delete(pessoa);
	}
}
