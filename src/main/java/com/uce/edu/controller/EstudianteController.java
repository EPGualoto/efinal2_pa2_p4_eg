package com.uce.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	@Autowired
	public IEstudianteService iEstudianteService;

	//guardar
	@PostMapping("/guardar")
	public String guardar(Estudiante estudiante) {
		this.iEstudianteService.guardar(estudiante);
		return "redirect:/estudiantes/nuevoEstudiante";
	}

	//Se envia un objeto estudiante vacío
	@GetMapping("/nuevoEstudiante")
	public String mostrarNuevaPersona(Model modelo) {
		modelo.addAttribute("estudiante", new Estudiante());
		return "vistaNuevoEstudiante";
	}

}
