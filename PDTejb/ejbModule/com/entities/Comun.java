package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity

public class Comun implements Serializable {

	private static final long serialVersionUID = 1L;

	public Comun() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idComun;

	public Long getIdComun() {
		return idComun;
	}

	public void setIdComun(Long idComun) {
		this.idComun = idComun;
	}

}
