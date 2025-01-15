package com.generation.projetorh.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_funcionarios")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório")
	@Size(min = 10, max = 255, message = "O atributo nome deve conter no mínimo 10 e no máximo 255 caracteres")
	private String nome;
	
	@NotBlank(message = "O atributo salario é obrigatório")
	private BigDecimal salario;
	
	@NotBlank(message = "O atributo cargo é obrigatório")
	@Size(min = 5, max = 255, message = "O atributo cargo deve conter no mínimo 5 e no máximo 255 caracteres")
	private String cargo;
	
	@UpdateTimestamp
	private LocalDateTime data_adm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDateTime getData_adm() {
		return data_adm;
	}

	public void setData_adm(LocalDateTime data_adm) {
		this.data_adm = data_adm;
	}
	
	
	
}
