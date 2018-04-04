package es.fpdual.eadmin.eadmin.servicio.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento {
	
	RepositorioDocumento repositorioDocumento;
	
	@Autowired
	public ServicioDocumentoImpl (RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}

	@Override
	public Documento altaDocumento(Documento documento) {
		
		final Documento documentoModificado = devolverConFechaCorrecta(documento);
		
		repositorioDocumento.altaDocumento(documentoModificado);
		
		return documentoModificado;
		
	}

	@Override
	public Documento modificarDocumento(Documento documento) {
		
		final Documento documentoFechaModificacion = agregarFechaModificacion(documento);
		
		repositorioDocumento.modificarDocumento(documentoFechaModificacion);
		
		return documentoFechaModificacion;
	
		
	}

	
	@Override
	public void eliminarDocumento(Integer codigo) {
		repositorioDocumento.eliminarDocumento(codigo);
		
	}
	
	
	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		return this.repositorioDocumento.obtenerDocumentoPorCodigo(codigo);
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		return this.repositorioDocumento.obtenerTodosLosDocumentos();
	}
	
	protected Documento agregarFechaModificacion(Documento documento) {
		/*
		return new Documento(documento.getCodigo(),
				documento.getNombre(),
				documento.getFechaCreacion(),
				documento.getPublico(),
				dameFechaActual(),
				documento.getEstado());
		*/
		return new DocumentoBuilder().clonar(documento).conFechaUltimaModificacion(dameFechaActual()).
				construir();
	}


	protected Documento devolverConFechaCorrecta(Documento documento) {
		/*
		return new Documento(documento.getCodigo(),
				documento.getNombre(),
				dameFechaActual(),
				documento.getPublico(),
				documento.getFechaUltimaModificacion(),
				documento.getEstado());
		*/
		return new DocumentoBuilder().clonar(documento).conFechaCreacion(dameFechaActual()).
				construir();
	}
	

	protected Date dameFechaActual() {
		return new Date();
	}

}
