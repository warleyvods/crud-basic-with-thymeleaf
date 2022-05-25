package com.contatos.controller;

import com.contatos.models.Pessoa;
import com.contatos.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class PessoaController {
	
	private final PessoaService service;

	public PessoaController(PessoaService service) {
		this.service = service;
	}

	@GetMapping("/cadastrar")
	public ModelAndView exibirTelaCadastro(Pessoa pessoa) {
		ModelAndView modelo = new ModelAndView("/formPessoa");
		modelo.addObject("pessoa", pessoa);
		return modelo;
	}

	@PostMapping("/cadastrar")
	public String salvarPessoa(Pessoa pessoa) {
		service.salvarPessoa(pessoa);
		return ("redirect:/");
	}

	@GetMapping("/")
	public ModelAndView listarTodasAsPessoas() {
		ModelAndView model = new ModelAndView("/index");
		List<Pessoa> pessoa = service.listarTodasAsPessoas();
		model.addObject("pessoa", pessoa);
		return model;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editarUser(@PathVariable long id, Pessoa pessoa) {
		ModelAndView model = new ModelAndView("/editPessoa");
		pessoa = service.findById(id);
		model.addObject("pessoa", pessoa);
		return model;
	}

	@GetMapping("/delete/{id}")
	public String deletarPessoa(@PathVariable long id) {
		service.deletarUsuario(id);
		return ("redirect:/");
	}
}
