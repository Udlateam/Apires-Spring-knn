package com.udla.springboot.backend.apirest.controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import com.udla.springboot.backend.apirest.dto.ClienteDistanciaDTO;
import com.udla.springboot.backend.apirest.dto.ClienteInteresDTO;
import com.udla.springboot.backend.apirest.dto.InteresConUsuariosDTO;
import com.udla.springboot.backend.apirest.dto.TendenciaInteresDTO;
import com.udla.springboot.backend.apirest.services.IClienteInteresService;
import com.udla.springboot.backend.apirest.services.KNNService;

//@CrossOrigin(origins = { "http://localhost:4200" }) // Configuración de CORS
@RestController
@RequestMapping("/api")
public class ClienteInteresRestController {

    @Autowired
    private IClienteInteresService clienteInteresService;

    @Autowired
    private KNNService knnService;

    // En tu controlador REST

    @GetMapping("/intereses-usuarios")
    public List<InteresConUsuariosDTO> listarInteresesConUsuarios() {
        return clienteInteresService.obtenerInteresesConUsuarios();
    }

    @GetMapping("/cliente-intereses/tendencias")
    public List<TendenciaInteresDTO> obtenerTendenciasIntereses(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {

        Date inicioDate = java.sql.Date.valueOf(inicio);
        Date finDate = java.sql.Date.valueOf(fin);

        // Limitar a los 10 primeros resultados
        Pageable topTen = PageRequest.of(0, 10);

        return clienteInteresService.findTendenciasIntereses(inicioDate, finDate, topTen);
    }

    @GetMapping("/cliente-intereses/detailed")
    public List<ClienteInteresDTO> obtenerClienteInteresesConDetalles() {
        return clienteInteresService.findClienteInteresesWithDetails();
    }

    @GetMapping("/cliente-intereses/{clienteId}/recomendaciones")
    public List<ClienteDistanciaDTO> obtenerRecomendaciones(@PathVariable Long clienteId, @RequestParam int k) {
        return knnService.encontrarVecinosCercanos(clienteId, k);
    }

    @GetMapping("/cliente-intereses")
    public List<ClienteInteresDTO> index() {
        return clienteInteresService.findAll();
    }

    @GetMapping("/cliente-intereses/{id}")
    public ClienteInteresDTO show(@PathVariable Long id) {
        return clienteInteresService.findById(id);
    }

    @PostMapping("/cliente-intereses")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteInteresDTO create(@RequestBody ClienteInteresDTO clienteInteresDTO) {
        return clienteInteresService.save(clienteInteresDTO);
    }

    @PutMapping("/cliente-intereses/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteInteresDTO update(@RequestBody ClienteInteresDTO clienteInteresDTO, @PathVariable Long id) {
        ClienteInteresDTO clienteInteresActual = clienteInteresService.findById(id);
        if (clienteInteresActual != null) {
            clienteInteresActual.setClienteId(clienteInteresDTO.getClienteId());
            clienteInteresActual.setInteresId(clienteInteresDTO.getInteresId());
            clienteInteresActual.setPonderacion(clienteInteresDTO.getPonderacion());
            return clienteInteresService.save(clienteInteresActual);
        }
        // Aquí puedes manejar el caso en que el ClienteInteres no se encuentre
        return null; // O lanzar una excepción
    }

    @DeleteMapping("/cliente-intereses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clienteInteresService.delete(id);
    }
}
