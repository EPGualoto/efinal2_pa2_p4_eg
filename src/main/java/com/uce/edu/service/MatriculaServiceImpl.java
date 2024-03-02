package com.uce.edu.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.DTO.MatriculaDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Autowired
	private IEstudianteService iEstudianteService;

	@Autowired
	private IMateriaService iMateriaService;

	@Override
	public void guardar(List<String> lista, String cedulaEstudiante, Matricula matricula) {
		// TODO Auto-generated method stub
		// Consultar cedula para ver el nombre del hilo en ese estudiante de acuerdo al
		// código de las materias.
		Estudiante estudiante = this.iEstudianteService.consultarPorCedula(cedulaEstudiante);
		
		List<Matricula> matriculas = new ArrayList<>();

		lista.parallelStream().forEach(codigoMateria -> {
		    Matricula materia1 = new Matricula();
		    Materia materia = this.iMateriaService.consultarPorCodigo(codigoMateria);

		    materia1.setFecha(LocalDate.now());
		    materia1.setEstudiante(estudiante);
		    materia1.setMateria(materia);
		    materia1.setNombreHilo(Thread.currentThread().getName());

		    matriculas.add(materia1);

		    this.iMatriculaRepository.insertar(materia1);
		});

		
	}

	@Override
	public List<MatriculaDTO> consultarTodos() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionarTodos();
	}
}
