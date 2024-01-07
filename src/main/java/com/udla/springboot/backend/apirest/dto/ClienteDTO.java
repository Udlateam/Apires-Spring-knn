package com.udla.springboot.backend.apirest.dto;

// import java.util.ArrayList;
import java.util.Date;
// import java.util.List;
// import java.util.Set;
// import java.util.stream.Collectors;

// import com.udla.springboot.backend.apirest.entity.Rol;

public class ClienteDTO {

	private Long id;
	private Date createAt;
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	// private Set<String> roles;
	private Integer semestreCursado;
	// private List<ClienteInteresDTO> clienteInteresesDTO;

	// public ClienteDTO() {
	// this.clienteInteresesDTO = new ArrayList<>();
	// }

	// // Getters y setters para clienteInteresesDTO
	// public List<ClienteInteresDTO> getClienteInteresesDTO() {
	// return clienteInteresesDTO;
	// }

	// public void setClienteInteresesDTO(List<ClienteInteresDTO>
	// clienteInteresesDTO) {
	// this.clienteInteresesDTO = clienteInteresesDTO;
	// }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// public Set<String> getRoles() {
	// return roles;
	// }

	// public void setRoles(Set<Rol> roles) {
	// this.roles = roles.stream()
	// .map(Rol::getNombre)
	// .collect(Collectors.toSet());
	// }

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Integer getSemestreCursado() {
		return semestreCursado;
	}

	public void setSemestreCursado(Integer semestreCursado) {
		this.semestreCursado = semestreCursado;
	}

	@Override
	public String toString() {
		return "ClienteDTO{" +
				"id=" + id +
				", createAt=" + createAt +
				", cedula=" + cedula +
				", nombre=" + nombre +
				", apellido=" + apellido +
				", email=" + email +
				// ", roles=" + roles +
				", semestreCursado=" + semestreCursado;
		// ", clienteInteresesDTO=" + clienteInteresesDTO;
	}

}
