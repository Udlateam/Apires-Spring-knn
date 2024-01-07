package com.udla.springboot.backend.apirest.services;

import java.util.List;
import java.util.Date;
import org.springframework.data.domain.Pageable;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.udla.springboot.backend.apirest.dto.ClienteInteresDTO;
import com.udla.springboot.backend.apirest.dto.InteresConUsuariosDTO;
import com.udla.springboot.backend.apirest.dto.TendenciaInteresDTO;
import com.udla.springboot.backend.apirest.entity.ClienteInteres;
import com.udla.springboot.backend.apirest.repositories.ClienteInteresRepository;
import com.udla.springboot.backend.apirest.repositories.ClienteRepository;
import com.udla.springboot.backend.apirest.repositories.InteresRepository;

@Service
public class ClienteInteresServiceImpl implements IClienteInteresService {

    @Autowired
    private ClienteInteresRepository clienteInteresRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClienteRepository clienteRepository; // Inyección del repositorio de clientes

    @Autowired
    private InteresRepository interesRepository;

    // En ClienteInteresService o un servicio dedicado para consultas complejas

    @Override
    public List<InteresConUsuariosDTO> obtenerInteresesConUsuarios() {
        return clienteInteresRepository.findInteresesConUsuarios();
    }

    @Transactional(readOnly = true)
    public List<TendenciaInteresDTO> findTendenciasIntereses(Date inicio, Date fin, Pageable pageable) {
        return clienteInteresRepository.findTendenciasIntereses(inicio, fin, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteInteresDTO> findClienteInteresesWithDetails() {
        return clienteInteresRepository.findClienteInteresesWithDetails();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteInteresDTO> findAll() {
        List<ClienteInteres> clienteIntereses = clienteInteresRepository.findAll();
        return clienteIntereses.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteInteresDTO findById(Long id) {
        ClienteInteres clienteInteres = clienteInteresRepository.findById(id).orElse(null);
        return clienteInteres != null ? convertirADTO(clienteInteres) : null;
    }

    @Override
    @Transactional
    public ClienteInteresDTO save(ClienteInteresDTO clienteInteresDTO) {
        ClienteInteres clienteInteres = convertirAEntidad(clienteInteresDTO);
        clienteInteres = clienteInteresRepository.save(clienteInteres);
        return convertirADTO(clienteInteres);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteInteresRepository.deleteById(id);
    }

    // Método para obtener los intereses y ponderaciones de un cliente específico
    public List<ClienteInteresDTO> findInteresesByClienteId(Long clienteId) {
        List<ClienteInteres> clienteIntereses = clienteInteresRepository.findByClienteId(clienteId);
        return clienteIntereses.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Long> findAllClienteIdsExcept(Long clienteId) {
        return clienteInteresRepository.findAllClienteIdsExcept(clienteId);
    }

    public double[] convertirInteresesADoubleArray(List<ClienteInteresDTO> clienteInteresesDTO) {
        double[] interesesArray = new double[clienteInteresesDTO.size()];
        for (int i = 0; i < clienteInteresesDTO.size(); i++) {
            ClienteInteresDTO ci = clienteInteresesDTO.get(i);
            interesesArray[i] = ci.getPonderacion(); // Asumiendo que tienes un atributo 'ponderacion' en
                                                     // ClienteInteresDTO
        }
        return interesesArray;
    }

    private ClienteInteresDTO convertirADTO(ClienteInteres clienteInteres) {
        ClienteInteresDTO dto = new ClienteInteresDTO();
        dto.setId(clienteInteres.getId());
        dto.setCreateAt(clienteInteres.getCreateAt());

        // Asegúrate de que las entidades relacionadas no son nulas
        if (clienteInteres.getCliente() != null) {
            dto.setClienteId(clienteInteres.getCliente().getId());
            dto.setClienteNombre(clienteInteres.getCliente().getNombre());
            dto.setClienteApellido(clienteInteres.getCliente().getApellido());
        }

        if (clienteInteres.getInteres() != null) {
            dto.setInteresId(clienteInteres.getInteres().getId());
            dto.setInteresNombre(clienteInteres.getInteres().getNombre());
        }

        dto.setPonderacion(clienteInteres.getPonderacion());

        return dto;
    }

    private ClienteInteres convertirAEntidad(ClienteInteresDTO clienteInteresDTO) {
        ClienteInteres clienteInteres = modelMapper.map(clienteInteresDTO, ClienteInteres.class);

        // Aquí se utiliza el repositorio directamente para buscar la entidad Cliente
        clienteInteres.setCliente(clienteRepository.findById(clienteInteresDTO.getClienteId()).orElse(null));
        // Aquí se utiliza el repositorio directamente para buscar la entidad Interes
        clienteInteres.setInteres(interesRepository.findById(clienteInteresDTO.getInteresId()).orElse(null));

        return clienteInteres;
    }

}
