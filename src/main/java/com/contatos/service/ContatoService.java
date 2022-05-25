package com.contatos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.contatos.models.Contato;
import com.contatos.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;

	public List<Contato> listarTodasOsContatos() {
		Iterable<Contato> itr = repository.findAll();
		return (List<Contato>) itr;
	}

	public Contato salvarContato(Contato contato) {
		return repository.save(contato);
	}

	public void deletarContatoPorId(Long id) {
		repository.deleteById(id);
	}

	public Contato encontrarPorId(long id) {
		return repository.getOne(id);
	}

	public void deletarContato(long id) {
		Contato contato = repository.getOne(id);
		repository.delete(contato);
	}

}
