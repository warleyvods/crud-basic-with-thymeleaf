package com.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.contatos.models.Contato;
import com.contatos.models.Pessoa;
import com.contatos.service.ContatoService;
import com.contatos.service.PessoaService;

/*
 * Controlador Pessoa
 */

@Controller
@RequestMapping("/")
public class PessoaController {

	@Autowired
	private ContatoService contatoService;

	@Autowired
	private PessoaService service;

	@GetMapping("/cadastrar")
	public ModelAndView telaCadastro(Pessoa pessoa) {
		ModelAndView modelo = new ModelAndView("/formPessoa");
		modelo.addObject("pessoa", pessoa);
		return modelo;
	}

	@PostMapping("/cadastrar")
	public String salvaPessoa(Pessoa pessoa) {
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
//		List<Contato> = pessoa.getContatos();
		model.addObject("pessoa", pessoa);
		return model;
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		service.deletarUsuario(id);
		return ("redirect:/");
	}

	/*
	 * Controlador Contato
	 */

	@GetMapping("/cadastrar/contato/{id}")
	public ModelAndView telaCadastroContato(@PathVariable long id, Contato contato) {
		ModelAndView modelo = new ModelAndView("contatos/formContatos");
		modelo.addObject("contato", contato);
		modelo.addObject("pessoaid", id);
		return modelo;
	}

	@PostMapping("/cadastrar/contato/{id}")
	public String salvarContato(@PathVariable long id, Contato contato) {
		contato.setIdPessoa(id);
		contatoService.salvarContato(contato);
		return ("redirect:/editar/" + id);
	}

	@GetMapping("/editar/contato/{id}")
	public ModelAndView editarContato(@PathVariable long id, Contato contato) {
		ModelAndView model = new ModelAndView("/contatos/editContatos");
		contato = contatoService.findById(id);
		model.addObject("contato", contato);
		return model;
	}

	@PostMapping("/editar/contato/salvar")
	public String editarContatoPost(Contato contato) {
		contatoService.salvarContato(contato);
		return ("redirect:/editar/" + contato.getIdPessoa());
	}

	@GetMapping("/delete/contato/{id}")
	public String deleteContato(@PathVariable long id) {
		contatoService.deletarUsuario(id);
		return ("redirect:/");
	}
}