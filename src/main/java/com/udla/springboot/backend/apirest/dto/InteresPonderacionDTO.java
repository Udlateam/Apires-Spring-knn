package com.udla.springboot.backend.apirest.dto;

public class InteresPonderacionDTO {

    private Long interesId;
    private String interesNombre;
    private Integer ponderacion;
    private Long numeroDeUsuarios;
    private String nombresDeUsuarios;

    // Constructor que coincide con los campos seleccionados en la consulta
    public InteresPonderacionDTO(Long interesId, String interesNombre, Integer ponderacion, Long numeroDeUsuarios,
            String nombresDeUsuarios) {
        this.interesId = interesId;
        this.interesNombre = interesNombre;
        this.ponderacion = ponderacion;
        this.numeroDeUsuarios = numeroDeUsuarios;
        this.nombresDeUsuarios = nombresDeUsuarios;
    }

    public Long getInteresId() {
        return interesId;
    }

    public void setInteresId(Long interesId) {
        this.interesId = interesId;
    }

    public String getInteresNombre() {
        return interesNombre;
    }

    public void setInteresNombre(String interesNombre) {
        this.interesNombre = interesNombre;
    }

    public Integer getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(Integer ponderacion) {
        this.ponderacion = ponderacion;
    }

    public Long getNumeroDeUsuarios() {
        return numeroDeUsuarios;
    }

    public void setNumeroDeUsuarios(Long numeroDeUsuarios) {
        this.numeroDeUsuarios = numeroDeUsuarios;
    }

    public String getNombresDeUsuarios() {
        return nombresDeUsuarios;
    }

    public void setNombresDeUsuarios(String nombresDeUsuarios) {
        this.nombresDeUsuarios = nombresDeUsuarios;
    }

}
