package es.fpdual.eadmin.eadmin.modelo;


import java.math.BigDecimal;
import java.util.Date;


public class DocumentoContable extends Documento {
	
	protected final BigDecimal importe;
	protected final String nifInteresado;
	

	

	public DocumentoContable(Integer codigo, String nombre, Date fechaCreacion, Boolean publico,
			Date fechaUltimaModificacion, EstadoDocumento estado, BigDecimal importe, String nifInteresado) {
		super(codigo, nombre, fechaCreacion, publico, fechaUltimaModificacion, estado);
		this.importe = importe;
		this.nifInteresado = nifInteresado;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public String getNifInteresado() {
		return nifInteresado;
	}

	@Override
	public String toString() {
		return "Documento_Contable [importe=" + importe + ", DNI_Interesado=" + nifInteresado + "]";
	}
	
}
