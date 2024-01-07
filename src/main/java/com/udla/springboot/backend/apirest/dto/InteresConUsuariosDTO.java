package com.udla.springboot.backend.apirest.dto;

public class InteresConUsuariosDTO {

    private Long interesId;
    private String interesNombre;
    private Integer ponderacion;
    private Long numeroDeUsuarios;
    private String apellidosDeUsuarios; // Campo modificado

    public InteresConUsuariosDTO(Long interesId, String interesNombre, Integer ponderacion, Long numeroDeUsuarios,
            String apellidosDeUsuarios) { // Constructor modificado
        this.interesId = interesId;
        this.interesNombre = interesNombre;
        this.ponderacion = ponderacion;
        this.numeroDeUsuarios = numeroDeUsuarios;
        this.apellidosDeUsuarios = apellidosDeUsuarios; // Inicialización modificada
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

    public String getApellidosDeUsuarios() {
        return apellidosDeUsuarios;
    }

    public void setApellidosDeUsuarios(String apellidosDeUsuarios) {
        this.apellidosDeUsuarios = apellidosDeUsuarios;
    }

}
