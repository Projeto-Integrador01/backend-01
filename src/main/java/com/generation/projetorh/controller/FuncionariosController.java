package com.generation.projetorh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.projetorh.model.Funcionario;
import com.generation.projetorh.repository.FuncionarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario") 
@CrossOrigin(origins = "", allowedHeaders = "") 
public class FuncionariosController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public ResponseEntity <List<Funcionario>> getAll(){
		return ResponseEntity.ok(funcionarioRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getById(@PathVariable Long id){
		return funcionarioRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity <Funcionario> post(@Valid @RequestBody Funcionario funcionario) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(funcionarioRepository.save(funcionario));
	}
	
	@GetMapping("/cargo/{cargo}")
	public ResponseEntity<List<Funcionario>> getByTitulo(@PathVariable String cargo) {
		return ResponseEntity.ok(funcionarioRepository.findAllByCargoContainingIgnoreCase(cargo));
	}
	
	@PutMapping
	public ResponseEntity<Funcionario> put(@Valid @RequestBody Funcionario funcionario) {
		return funcionarioRepository.findById(funcionario.getId()).map(
				resposta -> ResponseEntity.status(HttpStatus.CREATED).body(funcionarioRepository.save(funcionario)))

				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void delete(@PathVariable long id) {
		Optional<Funcionario> postagem = funcionarioRepository.findById(id);

		if (postagem.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		funcionarioRepository.deleteById(id);
	}
	
}
