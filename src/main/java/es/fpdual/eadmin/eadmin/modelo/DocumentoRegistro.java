package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class DocumentoRegistro extends Documento {
	
	private String nifInteresado;
	private String controlRegistro;
	
	
	public DocumentoRegistro(Integer codigo, String nombre, Date fechaCreacion, Boolean publico,
			Date fechaUltimaModificacion, EstadoDocumento estado, String nifInteresado, String controlRegistro) {
		super(codigo, nombre, fechaCreacion, publico, fechaUltimaModificacion, estado);
		this.nifInteresado = nifInteresado;
		this.controlRegistro = controlRegistro;
	}


	public String getNifInteresado() {
		return nifInteresado;
	}


	public String getControlRegistro() {
		return controlRegistro;
	}


	@Override
	public String toString() {
		return "Documento_Registro [nifInteresado=" + nifInteresado + ", controlRegistro=" + controlRegistro + "]";
	}
	

}
