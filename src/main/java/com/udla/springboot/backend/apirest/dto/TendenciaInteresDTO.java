package com.udla.springboot.backend.apirest.dto;

public class TendenciaInteresDTO {
    private String interes;
    private Long cantidad;

    public TendenciaInteresDTO() {
        // Constructor por defecto necesario para que los frameworks y bibliotecas puedan inicializar la clase
    }

    public TendenciaInteresDTO(String interes, Long cantidad) {
        this.interes = interes;
        this.cantidad = cantidad;
    }

    // Getters y setters
    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
