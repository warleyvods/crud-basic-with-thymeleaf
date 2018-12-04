package com.contatos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Controlador do Index
@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
