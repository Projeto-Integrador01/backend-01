
package com.generation.projetorh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.projetorh.model.Funcionarios;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {

	List<Funcionarios> findAllByCargoContainingIgnoreCase(@Param("cargo") String cargo);
}
