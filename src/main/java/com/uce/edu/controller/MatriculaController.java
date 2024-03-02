package com.uce.edu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.DTO.MatriculaDTO;
import com.uce.edu.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	@Autowired
	public IMatriculaService iMatriculaService;

	//guardar
	@PostMapping("/guardar")
	public String guardar(@RequestParam("cedula") String cedulaEstudiante, @RequestParam("codigo1") String codigo1,
			@RequestParam("codigo2") String codigo2, @RequestParam("codigo3") String codigo3,
			@RequestParam("codigo4") String codigo4, Matricula matricula) {
		List<String> lista = new ArrayList<>();
		lista.add(codigo1);
		lista.add(codigo2);
		lista.add(codigo3);
		lista.add(codigo4);
		this.iMatriculaService.guardar(lista, cedulaEstudiante, matricula);
		return "redirect:/matriculas/nuevaMatricula";
	}

	//Se envia un objeto matricula vacío
	@GetMapping("/nuevaMatricula")
	public String mostrarNuevaMatricula(Model modelo) {
		modelo.addAttribute("matricula", new Matricula());
		return "vistaNuevaMatricula";
	}
	
	//Reporte
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<MatriculaDTO> lista = this.iMatriculaService.consultarTodos();
		modelo.addAttribute("matriculas", lista);
		return "vistaListaMatriculas";
	}
}