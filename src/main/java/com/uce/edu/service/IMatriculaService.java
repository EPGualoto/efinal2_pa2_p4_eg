package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.DTO.MatriculaDTO;

public interface IMatriculaService {
	public void guardar(List<String> lista, String cedulaEstudiante, Matricula matricula);

	public List<MatriculaDTO> consultarTodos();

}
