package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {
	
	private List<Documento> documentos = new ArrayList<>();
	
	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public void altaDocumento(Documento documento) {
		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe.");
		}
		
		documentos.add(documento);
		System.out.println("Se ha insertado un documento.");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ha modificar no existe.");
		}
		
		documentos.set(documentos.indexOf(documento),documento);
		
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		/*
		Documento documentoEncontrado = null;
		
		for (int i = 0; i< documentos.size(); i++) {
			if(documentos.get(i).getCodigo().equals(codigo)) {
				documentoEncontrado = documentos.get(i);
				break;
			}
		}
		*/
		
		Documento documentoEncontrado = documentos.stream().
				filter(d -> tieneIgualCodigo(d, codigo)).
				findFirst().orElseGet(null);
				
				
		if (documentoEncontrado != null) {
			documentos.remove(documentoEncontrado);
		}
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		Optional <Documento> documentoEncontrado = documentos.stream().
				filter(d -> tieneIgualCodigo(d, codigo)).
				findFirst();
		
		if (documentoEncontrado.isPresent()) {
			return documentoEncontrado.get();
		}
		return null;
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		
		return documentos;
	}
	
	protected boolean tieneIgualCodigo(Documento documento, Integer codigo) {
		return documento.getCodigo().equals(codigo);
	}


}