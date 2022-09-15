	package com.Entregable3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
import java.util.List;


@Controller
@RequestMapping	
public class Controlador {
	
	@Autowired
	private IclienteService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<cliente> cliente = service.listar(); 
		model.addAttribute("cliente", cliente);
		return "Tabla";
	}
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {
		model.addAttribute("cliente", new cliente());
		return "formulario";
	}
	
	
	@PostMapping("/save")
	public String save(@Validated cliente p, Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{idcliente}")
	public String editar(@PathVariable int idcliente, Model model) {
		Optional<cliente> cliente = service.listarId(idcliente);
		model.addAttribute("cliente",cliente);
		return "formulario2";
	}
	
	@GetMapping("/eliminar/{idcliente}")
	public String eliminar(Model model, @PathVariable int idcliente) {
		service.delete(idcliente);
		return "redirect:/listar";
	}
}
