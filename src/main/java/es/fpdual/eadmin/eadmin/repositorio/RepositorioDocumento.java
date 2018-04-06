package es.fpdual.eadmin.eadmin.repositorio;

import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface RepositorioDocumento {
	
	public abstract void altaDocumento(Documento documento);
	
	public abstract void modificarDocumento (Documento documento);
	
	public abstract void eliminarDocumento (Integer codigo);
	
	public abstract Documento obtenerDocumentoPorCodigo(Integer codigo);
	
	public abstract List<Documento> obtenerTodosLosDocumentos();
	
	public abstract void cargarDocumentoEnArchivo();
	
	void listarEnAlta(Documento documento);

	void listarModificados(Documento documento);
	
	void listarEliminados(Integer codigo);
	
}
