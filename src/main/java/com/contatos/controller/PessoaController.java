package com.contatos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.contatos.models.Pessoa;
import com.contatos.service.PessoaService;


/**
 * Controlador responsavel por gerenciar/manter os recursos de cadastro de pessoas
 * 
 * @author Warley 
 * 
 */
@Controller
@RequestMapping("/")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
		
	/**
	 * Endpoint responsável por apresentar a tela cadastro de pessoas
	 * 
	 * @param pessoa pessoa a ser cadastrada
	 * @return Retorna a view form pessoa (cadastrar)
	 */
	@GetMapping("/cadastrar")
	public ModelAndView exibirTelaCadastro(Pessoa pessoa) {
		ModelAndView modelo = new ModelAndView("/formPessoa");
		modelo.addObject("pessoa", pessoa);
		return modelo;
	}
	
	/**
	 * Endpoint responsavel por cadastrar pessoas
	 * 
	 * @param pessoa pessoa a ser cadastrada
	 * @return Redirecionamento para a tela inicial
	 */
	@PostMapping("/cadastrar")
	public String salvarPessoa(Pessoa pessoa) {
		service.salvarPessoa(pessoa);
		return ("redirect:/");
	}
	
	/**
	 * Endpoint responsável por listar todas as pessoas
	 * 
	 * @return Retorna o model de listar pessoas em "/index" (tela principal)
	 */
	@GetMapping("/")
	public ModelAndView listarTodasAsPessoas() {
		ModelAndView model = new ModelAndView("/index");
		List<Pessoa> pessoa = service.listarTodasAsPessoas();
		model.addObject("pessoa", pessoa);
		return model;
	}
	
	/**
	 * Endpoint responsável por editar pessoa
	 * 
	 * @param id id da pessoa a ser editada
	 * @param pessoa pessoa a ser editada
	 * @return Retorna a tela editar pessoa
	 */
	@GetMapping("/editar/{id}")
	public ModelAndView editarUser(@PathVariable long id, Pessoa pessoa) {
		ModelAndView model = new ModelAndView("/editPessoa");
		pessoa = service.findById(id);
		model.addObject("pessoa", pessoa);
		return model;
	}
	
	/**
	 * Endpoint reponsável por deletar uma pessoa
	 * 
	 * @param id id da pessoa a ser deletada
	 * @return Redireciona para a tela principal
	 */
	@GetMapping("/delete/{id}")
	public String deletarPessoa(@PathVariable long id) {
		service.deletarUsuario(id);
		return ("redirect:/");
	}
}