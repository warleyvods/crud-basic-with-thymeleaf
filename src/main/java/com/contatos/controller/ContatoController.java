package com.contatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.contatos.models.Contato;
import com.contatos.service.ContatoService;

/**
 * Controlador responsavel por gerenciar/manter os recursos de cadastro de
 * contatos
 * 
 * @author Warley
 *
 */
@Controller
@RequestMapping("/")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

	/**
	 * Endpoint responsável por apresentar a tela cadastro de contatos já relacionado a pessoa
	 * 
	 * @param id id da pessoa que esta cadastrando o contato
	 * @param contato contato que será cadastrado
	 * @return Retorna a view form contato, já relacionado a pessoaid
	 */
	@GetMapping("/cadastrar/contato/{id}")
	public ModelAndView telaCadastroContato(@PathVariable long id, Contato contato) {
		ModelAndView modelo = new ModelAndView("contatos/formContatos");
		modelo.addObject("contato", contato);
		modelo.addObject("pessoaid", id);
		return modelo;
	}

	/**
	 * Endpoint responsável por cadastrar contatos identificando a pessoa e associando o mesmo a uma pessoa
	 * 
	 * @param id id da pessoa que esta associada ao contato
	 * @param contato contato que será cadastrado
	 * @return Redireciona para Editar contato com o view da pessoa a que ele foi atribuido
	 */
	@PostMapping("/cadastrar/contato/{id}")
	public String salvarContato(@PathVariable long id, Contato contato) {
		contato.setIdPessoa(id);
		contatoService.salvarContato(contato);
		return ("redirect:/editar/" + id);
	}

	/**
	 * Endpoint responsável por apresentar a view Editar contato para edição.
	 * 
	 * @param id id do contato que será editado
	 * @param contato contato que será editado
	 * @return Retorna model da tela cadastrar contato 
	 */
	@GetMapping("/editar/contato/{id}")
	public ModelAndView editarContato(@PathVariable long id, Contato contato) {
		ModelAndView model = new ModelAndView("/contatos/editContatos");
		contato = contatoService.encontrarPorId(id);
		model.addObject("contato", contato);
		return model;
	}

	/**
	 * Endpoint responsável por editar o contato
	 * 
	 * @param contato contato que será editado
	 * @return Redireciona para a tela editar contato
	 */
	@PostMapping("/editar/contato/salvar")
	public String editarContatoPost(Contato contato) {
		contatoService.salvarContato(contato);
		return ("redirect:/editar/" + contato.getIdPessoa());
	}

	/**
	 * Endpoint responsável por deletar o contato
	 * 
	 * @param id id do contato que será deletado
	 * @return Retorna a view de tela principal "/"
	 */
	@GetMapping("/delete/contato/{id}")
	public String deletarContato(@PathVariable long id) {
		contatoService.deletarContato(id);
		return ("redirect:/");
	}

}
