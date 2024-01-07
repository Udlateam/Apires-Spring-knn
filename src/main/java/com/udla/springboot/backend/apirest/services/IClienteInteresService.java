package com.udla.springboot.backend.apirest.services;

import java.util.List;
import java.util.Date;
import org.springframework.data.domain.Pageable;
import com.udla.springboot.backend.apirest.dto.ClienteInteresDTO;
import com.udla.springboot.backend.apirest.dto.TendenciaInteresDTO;
import com.udla.springboot.backend.apirest.dto.InteresConUsuariosDTO;

public interface IClienteInteresService {
    List<InteresConUsuariosDTO> obtenerInteresesConUsuarios(); // Nuevo método
    List<TendenciaInteresDTO> findTendenciasIntereses(Date inicio, Date fin, Pageable pageable);
    List<ClienteInteresDTO> findClienteInteresesWithDetails();
    List<ClienteInteresDTO> findAll();
    ClienteInteresDTO findById(Long id);
    ClienteInteresDTO save(ClienteInteresDTO clienteInteresDTO);
    void delete(Long id);
    List<ClienteInteresDTO> findInteresesByClienteId(Long clienteId);
    List<Long> findAllClienteIdsExcept(Long clienteId); // Nuevo método
}

