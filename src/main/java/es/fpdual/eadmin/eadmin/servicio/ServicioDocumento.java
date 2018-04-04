package es.fpdual.eadmin.eadmin.servicio;

import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface ServicioDocumento {
	
	public abstract Documento altaDocumento(Documento documento);

	public abstract Documento modificarDocumento(Documento documento);

	public abstract void eliminarDocumento(Integer codigo);
	
	public abstract Documento obtenerDocumentoPorCodigo(Integer codigo);
	
	public abstract List<Documento> obtenerTodosLosDocumentos();
	

}
