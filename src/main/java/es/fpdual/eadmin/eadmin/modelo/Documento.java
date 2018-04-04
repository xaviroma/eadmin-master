package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento extends AdministracionElectronicaBase {

	protected final EstadoDocumento estado;
		

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, Date fechaUltimaModificacion,
			EstadoDocumento estado) {
		super(codigo, nombre, fechaCreacion, publico, fechaUltimaModificacion);
		this.estado = estado;
	}


	public EstadoDocumento getEstado() {
		return estado;
	}

}
