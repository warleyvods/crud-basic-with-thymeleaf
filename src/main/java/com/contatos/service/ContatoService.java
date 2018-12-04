package com.contatos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.contatos.models.Contato;
import com.contatos.repository.ContatoRepository;

/**
 * Classe de serviço dos contatos
 * 
 * @author Warley
 *
 */
@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;

	/**
	 * Atribui a responsabilidade de listar todos os contatos
	 * 
	 * @return 
	 */
	public List<Contato> listarTodasOsContatos() {
		Iterable<Contato> itr = repository.findAll();
		return (List<Contato>) itr;
	}

	/**
	 * Atribui a responsabilidade de salvar o contato
	 * 
	 * @param contato
	 * @return
	 */
	public Contato salvarContato(Contato contato) {
		return repository.save(contato);
	}

	/**
	 * Atribui a responsabilidade de apagar o contato por ID
	 * 
	 * @param id
	 */
	public void deletarContatoPorId(Long id) {
		repository.deleteById(id);
	}

	/**
	 * Atribui a responsabilidade de encontrar o contato por ID
	 * 
	 * @param id
	 * @return
	 */
	public Contato encontrarPorId(long id) {
		return repository.getOne(id);
	}

	/**
	 * Atribui a responsabilidade de deletar o contato por ID
	 * 
	 * @param id
	 */
	public void deletarContato(long id) {
		Contato contato = repository.getOne(id);
		repository.delete(contato);
	}

}
