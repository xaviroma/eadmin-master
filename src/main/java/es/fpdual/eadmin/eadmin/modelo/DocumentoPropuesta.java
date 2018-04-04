package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class DocumentoPropuesta extends Documento {
	
	private final Integer codigoPro;
	private final Integer ejercicio;
	private final String grupoPolitico;
	
	
	public DocumentoPropuesta(Integer codigo, String nombre, Date fechaCreacion, Boolean publico,
			Date fechaUltimaModificacion, EstadoDocumento estado, Integer codigoPro, Integer ejercicio,
			String grupoPolitico) {
		super(codigo, nombre, fechaCreacion, publico, fechaUltimaModificacion, estado);
		this.codigoPro = codigoPro;
		this.ejercicio = ejercicio;
		this.grupoPolitico = grupoPolitico;
	}

	public Integer getCodigo_pro() {
		return codigoPro;
	}

	public Integer getEjercicio() {
		return ejercicio;
	}


	public String getGrupoPolitico() {
		return grupoPolitico;
	}


	@Override
	public String toString() {
		return "DocumentoPropuesta [codigo=" + codigoPro + ", ejercicio=" + ejercicio + ", grupoPolitico=" + grupoPolitico
				+ "]";
	}
	

	

}
