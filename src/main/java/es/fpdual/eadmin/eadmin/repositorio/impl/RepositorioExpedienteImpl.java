package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

@Repository
public class RepositorioExpedienteImpl implements RepositorioExpediente{
	
	private List<Expediente> expedientes = new ArrayList<>();
	
	public List<Expediente> getExpedientes() {
		return expedientes;
	}
	
	// Con esto obtengo la lista completa con todos los expedientes.	


	@Override
	public void altaExpediente(Expediente expediente) {
		if (expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El documento ya existe.");
		}
		
		expedientes.add(expediente);
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		if (!expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El documento ha modificar no existe.");
		}
		
		expedientes.set(expedientes.indexOf(expediente),expediente);
		
	}

	@Override
	public void eliminarExpediente(Integer codigo) {
		Expediente documentoEncontrado = expedientes.stream().
				filter(d -> tieneIgualCodigo(d, codigo)).
				findFirst().orElseGet(null);
				
				
		if (documentoEncontrado != null) {
			expedientes.remove(documentoEncontrado);
		}
	}

	@Override
	public Expediente asociarDocumentoAlExpediente(Integer codigoExpediente, Documento documento) {
		
		Expediente expedienteEncontrado = expedientes.stream().
				filter(d -> tieneIgualCodigo(d, codigoExpediente)).
				findFirst().orElseGet(null);
		
		if (expedienteEncontrado != null) {
			expedienteEncontrado.getDocumentos().add(documento);
		}
		return null;
				
	}

	@Override
	public Expediente desasociarDocumentoDelExpediente(Integer codigoExpediente, Integer codigoDocumento) {
		
		Expediente expedienteEncontrado = expedientes.stream().
				filter(d -> tieneIgualCodigo(d, codigoExpediente)).
				findFirst().orElseGet(null);
		
		if (expedienteEncontrado != null) {
			expedienteEncontrado.getDocumentos().remove(codigoDocumento);
		}
		return null;
			
	}
	
	@Override
	public Expediente obtenerExpedientePorCodigo(Integer codigoExpediente) {
		
		Optional<Expediente> expedienteEncontrado = expedientes.stream().
				filter(d -> tieneIgualCodigo(d, codigoExpediente)).
				findFirst();
		
		if (expedienteEncontrado.isPresent()) {
			return expedienteEncontrado.get();
		}
		return null;
	}

	@Override
	public List<Expediente> obtenerTodosLosExpedientes() {
		
		return expedientes;
	}

	protected boolean tieneIgualCodigo(Expediente expediente, Integer codigo) {
		return expediente.getCodigo().equals(codigo);
	}


}
