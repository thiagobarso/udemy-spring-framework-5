package br.com.thiagobarso.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.thiagobarso.repositories.AuthorRepository;

@Controller
public class AuthorController {
	
	private final AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getBooks(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		return "authors/list";
	}

}
