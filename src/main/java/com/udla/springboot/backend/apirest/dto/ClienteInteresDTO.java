package com.udla.springboot.backend.apirest.dto;

import java.util.Date;

public class ClienteInteresDTO {
	private Long id;
	private Date createAt;
	private Long clienteId;
	private String clienteNombre;
	private String clienteApellido;
	private Long interesId;
	private String interesNombre;
	private Integer ponderacion;

	// Constructor vacío
	public ClienteInteresDTO() {
	}

	// Constructor completo
	public ClienteInteresDTO(Long id, Date createAt, Long clienteId, String clienteNombre, String clienteApellido,
			Long interesId,
			String interesNombre, Integer ponderacion) {
		this.id = id;
		this.createAt = createAt;
		this.clienteId = clienteId;
		this.clienteNombre = clienteNombre;
		this.clienteApellido = clienteApellido;
		this.interesId = interesId;
		this.interesNombre = interesNombre;
		this.ponderacion = ponderacion;
	}

	// Getters y setters
	// ...

	public Long getId() {
		return id;
	}

	public String getClienteNombre() {
		return clienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	public String getClienteApellido() {
		return clienteApellido;
	}

	public void setClienteApellido(String clienteApellido) {
		this.clienteApellido = clienteApellido;
	}

	public String getInteresNombre() {
		return interesNombre;
	}

	public void setInteresNombre(String interesNombre) {
		this.interesNombre = interesNombre;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getInteresId() {
		return interesId;
	}

	public void setInteresId(Long interesId) {
		this.interesId = interesId;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Integer getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(Integer ponderacion) {
		this.ponderacion = ponderacion;
	}

	// Sobrescribe el método toString()
	@Override
	public String toString() {
		return "ClienteInteresDTO{" +
				"id=" + id +
				", createAt=" + createAt +
				", clienteId=" + clienteId +
				", clienteNombre='" + clienteNombre + '\'' +
				", clienteApellido='" + clienteApellido + '\'' +
				", interesId=" + interesId +
				", interesNombre='" + interesNombre + '\'' +
				", ponderacion=" + ponderacion +
				'}';
	}
}
