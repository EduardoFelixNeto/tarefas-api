package com.felix.tarefas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felix.tarefas.model.Tarefa;
import com.felix.tarefas.services.TarefaService;


@RestController
@RequestMapping("/tarefas")
@CrossOrigin( origins = "http://localhost:4200")
public class TarefaController {
	
	@Autowired
	private TarefaService service;
	
	@GetMapping(
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Tarefa> findAll() throws Exception{
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Tarefa findById(@PathVariable(value="id") Long id) throws Exception{
		return service.findById(id);
	}
	
	@PostMapping(
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Tarefa create(@RequestBody Tarefa tarefa) {
		return service.create(tarefa);
	}
	
	@PutMapping(
			path = "/{id}",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Tarefa update(@RequestBody Tarefa tarefa) {
		return service.update(tarefa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();	
		}
}
