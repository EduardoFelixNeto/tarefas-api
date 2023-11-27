package com.felix.tarefas.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Tarefas")
public class Tarefa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tarefaId;
	
	@Column(name = "nome", nullable=false, length = 4000)
	private String nome;
	
	@Column(name = "custo", nullable=false, length = 22)
	private Double custo;
	
	
	@Column(name = "dataLimite", nullable=false, length = 9)
	private LocalDate dataLimite;
	
	@Column(name = "ordemApresentacao", nullable=false, length = 22)
	private Integer ordemApresentacao;

	public Tarefa() {
	}

	public long getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(long tarefaId) {
		this.tarefaId = tarefaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public LocalDate getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(LocalDate dataLimite) {
		this.dataLimite = dataLimite;
	}

	public Integer getOrdemApresentacao() {
		return ordemApresentacao;
	}

	public void setOrdemApresentacao(Integer ordemApresentacao) {
		this.ordemApresentacao = ordemApresentacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(custo, dataLimite, nome, ordemApresentacao, tarefaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(custo, other.custo) && Objects.equals(dataLimite, other.dataLimite)
				&& Objects.equals(nome, other.nome) && Objects.equals(ordemApresentacao, other.ordemApresentacao)
				&& tarefaId == other.tarefaId;
	}
	
}

