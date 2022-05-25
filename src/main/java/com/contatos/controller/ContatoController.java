package com.contatos.controller;

import com.contatos.models.Contato;
import com.contatos.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class ContatoController {

	private final ContatoService contatoService;

	public ContatoController(ContatoService contatoService) {
		this.contatoService = contatoService;
	}

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
		contato = contatoService.encontrarPorId(id);
		model.addObject("contato", contato);
		return model;
	}

	@PostMapping("/editar/contato/salvar")
	public String editarContatoPost(Contato contato) {
		contatoService.salvarContato(contato);
		return ("redirect:/editar/" + contato.getIdPessoa());
	}

	@GetMapping("/delete/contato/{id}")
	public String deletarContato(@PathVariable long id) {
		contatoService.deletarContato(id);
		return ("redirect:/");
	}
}
