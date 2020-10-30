package com.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Casilla implements Serializable {

	private static final long serialVersionUID = 1L;

	public Casilla() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCasilla;

	@Column(length = 40)
	private String parametro;

	@Column(length = 40)
	private String unidadMedida;

	@Column(length = 40)
	private String descripcion;

	public Long getIdCasilla() {
		return idCasilla;
	}

	public void setIdCasilla(Long idCasilla) {
		this.idCasilla = idCasilla;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
