package com.udla.springboot.backend.apirest.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import com.udla.springboot.backend.apirest.dto.ClienteInteresDTO;
import com.udla.springboot.backend.apirest.dto.InteresConUsuariosDTO;
import com.udla.springboot.backend.apirest.dto.TendenciaInteresDTO;
import com.udla.springboot.backend.apirest.entity.ClienteInteres;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteInteresRepository extends JpaRepository<ClienteInteres, Long> {
	// Métodos personalizados si son necesarios
	List<ClienteInteres> findByClienteId(Long clienteId);

	@Query("SELECT DISTINCT ci.cliente.id FROM ClienteInteres ci WHERE ci.cliente.id <> :clienteId")
	List<Long> findAllClienteIdsExcept(@Param("clienteId") Long clienteId);

	@Query(value = "SELECT new com.udla.springboot.backend.apirest.dto.ClienteInteresDTO(ci.id, ci.createAt, c.id, c.nombre, c.apellido, i.nombre, ci.ponderacion) FROM Cliente c LEFT JOIN c.clienteIntereses ci LEFT JOIN Interes i ON ci.interes.id = i.id", nativeQuery = false)
	List<ClienteInteresDTO> findClienteInteresesWithDetails();

	@Query("SELECT new com.udla.springboot.backend.apirest.dto.TendenciaInteresDTO(i.nombre, COUNT(ci.interes)) " +
			"FROM ClienteInteres ci " +
			"JOIN ci.cliente c " +
			"JOIN ci.interes i " +
			"WHERE ci.createAt BETWEEN :inicio AND :fin " +
			"GROUP BY ci.interes " +
			"ORDER BY COUNT(ci.interes) DESC")
	List<TendenciaInteresDTO> findTendenciasIntereses(@Param("inicio") Date inicio, @Param("fin") Date fin,
			Pageable pageable);

	@Query("SELECT new com.udla.springboot.backend.apirest.dto.InteresConUsuariosDTO(" +
			"ci.interes.id, " +
			"i.nombre, " +
			"ci.ponderacion, " +
			"COUNT(ci.cliente.id) as numeroDeUsuarios, " +
			"'' as apellidosDeUsuarios) " + // Campo agregado como cadena vacía
			"FROM ClienteInteres ci " +
			"JOIN ci.interes i " +
			"JOIN ci.cliente c " +
			"GROUP BY ci.interes.id, ci.ponderacion " +
			"ORDER BY ci.ponderacion DESC, numeroDeUsuarios DESC")
	List<InteresConUsuariosDTO> findInteresesConUsuarios();

}