
package com.generation.projetorh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.projetorh.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	List<Funcionario> findAllByCargoContainingIgnoreCase(@Param("cargo") String cargo);
}
