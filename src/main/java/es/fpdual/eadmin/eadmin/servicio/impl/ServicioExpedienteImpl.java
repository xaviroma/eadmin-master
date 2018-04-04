package es.fpdual.eadmin.eadmin.servicio.impl;

import java.util.Date;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.modelo.builder.ExpedienteBuilder;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;
import es.fpdual.eadmin.eadmin.servicio.ServicioExpediente;

public class ServicioExpedienteImpl implements ServicioExpediente{
	
	RepositorioExpediente repositorioExpediente;

	@Override
	public Expediente altaExpediente(Expediente expediente) {
		
		final Expediente expedienteModificado = devolverConFechaCorrecta(expediente);
		
		repositorioExpediente.altaExpediente(expedienteModificado);
		return expedienteModificado;
	}

	
	@Override
	public Expediente modificarExpediente(Expediente expediente) {
		
		final Expediente expedienteFechaModificacion = agregarFechaModificacion(expediente);
		
		this.repositorioExpediente.modificarExpediente(expedienteFechaModificacion);

		return expedienteFechaModificacion;
	}


	@Override
	public void eliminarExpediente(Integer codigo) {
		
		this.repositorioExpediente.eliminarExpediente(codigo);
		
	}

	@Override
	public Expediente asociarDocumentoAlExpediente(Integer codigoExpediente, Documento documento) {
		
		
		return this.repositorioExpediente.asociarDocumentoAlExpediente(codigoExpediente, documento);

	}

	@Override
	public Expediente desasociarDocumentoDelExpediente(Integer codigoExpediente, Integer codigoDocumento) {
		
		return this.repositorioExpediente.desasociarDocumentoDelExpediente(codigoExpediente, codigoDocumento);

	}
	
	
	protected Expediente devolverConFechaCorrecta(Expediente expediente) {
		
		
		return new ExpedienteBuilder().clonar(expediente).conFechaCreacion(dameFechaActual()).construir();
	}
	
	protected Expediente agregarFechaModificacion(Expediente expediente) {
		
		return new ExpedienteBuilder().clonar(expediente).conFechaUltimaModificacion(dameFechaActual()).
				construir();
	}



	protected Date dameFechaActual() {
		return new Date();
	}

}
