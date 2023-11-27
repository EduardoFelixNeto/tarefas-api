package com.felix.tarefas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.felix.tarefas.exceptions.ResourceNotFoundException;
import com.felix.tarefas.model.Tarefa;
import com.felix.tarefas.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	TarefaRepository repository;
	
	public List<Tarefa> findAll(){
		return repository.findAll(Sort.by(Sort.Direction.ASC, "ordemApresentacao"));
	}
	
	public Tarefa findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Tarefa create(Tarefa tarefa) {
		return repository.save(tarefa);
	}
	
	public Tarefa update(Tarefa tarefa) {
		var entity = repository.findById(tarefa.getTarefaId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		entity.setNome(tarefa.getNome());
		entity.setCusto(tarefa.getCusto());
		entity.setDataLimite(tarefa.getDataLimite());
		entity.setOrdemApresentacao(tarefa.getOrdemApresentacao());
		return repository.save(tarefa);
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
}
