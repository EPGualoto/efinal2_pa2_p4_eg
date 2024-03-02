package com.uce.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	@Autowired
	public IMateriaService iMateriaService;

	//guardar
	@PostMapping("/guardar")
	public String guardar(Materia materia) {
		this.iMateriaService.guardar(materia);
		return "redirect:/materias/nuevaMateria";
	}

	//Se envia un objeto materia vacío
	@GetMapping("/nuevaMateria")
	public String mostrarNuevaMateria(Model modelo) {
		modelo.addAttribute("materia", new Materia());
		return "vistaNuevaMateria";
	}
}
