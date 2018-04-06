package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Repository
public class RepositorioExpedienteImpl implements RepositorioExpediente{
	
	final File fichero = new File("expedientes.txt");
	final String RUTA_LISTA = "LISTA_EXPEDIENTES.txt";
	final String RUTA_ALTA = "ALTA_EXPEDIENTES.TXT";
	final String RUTA_MODIFICADO = "MODIFICADO_EXPEDIENTE.TXT";
	final String RUTA_ELIMINADO = "ELIMINAR_EXPEDIENTE.TXT";
	FileWriter file = null;
	PrintWriter pw = null;
	
	private static final Logger logger = LoggerFactory.getLogger(RepositorioExpedienteImpl.class);
	
	private List<Expediente> expedientes = new ArrayList<>();
	
	public List<Expediente> getExpedientes() {
		logger.info("Obteniendo expedientes. ");
		return expedientes;
	}
	
	// Con esto obtengo la lista completa con todos los expedientes.	


	@Override
	public void altaExpediente(Expediente expediente) {
		
		logger.info("Dando de alta un expediente.");
		
		if (expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El documento ya existe.");
		}
		
		expedientes.add(expediente);
		listarEnAlta(expediente);
		
		logger.info("Alta expediente finalizada.");
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		
		logger.info("Entrando en modificar expediente.");
		if (!expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El documento ha modificar no existe.");
		}
		
		expedientes.set(expedientes.indexOf(expediente),expediente);
		listarModificados(expediente);
		logger.info("Saliendo de modificar expediente.");
		
	}

	@Override
	public void eliminarExpediente(Integer codigo) {
		
		logger.info("Entrando en eliminar expediente.");
		
		Expediente expedienteEncontrado = expedientes.stream().
				filter(d -> tieneIgualCodigo(d, codigo)).
				findFirst().orElseGet(null);
				
				
		if (expedienteEncontrado != null) {
			listarEliminados(codigo);
			expedientes.remove(expedienteEncontrado);
		}
		
		logger.info("Saliendo de eliminar expediente.");
	}

	@Override
	public Expediente asociarDocumentoAlExpediente(Integer codigoExpediente, Documento documento) {
		
		logger.info("Entrando en asociar documento al expediente.");
		
		Expediente expedienteEncontrado = expedientes.stream().
				filter(d -> tieneIgualCodigo(d, codigoExpediente)).
				findFirst().orElseGet(null);
		
		if (expedienteEncontrado != null) {
			expedienteEncontrado.getDocumentos().add(documento);
		}
		logger.info("Saliendo de asociar documnto al expediente.");
		return null;
						
	}

	@Override
	public Expediente desasociarDocumentoDelExpediente(Integer codigoExpediente, Integer codigoDocumento) {
		
		logger.info("Entrando en desasociar documento al expediente.");
		
		Expediente expedienteEncontrado = expedientes.stream().
				filter(d -> tieneIgualCodigo(d, codigoExpediente)).
				findFirst().orElseGet(null);
		
		if (expedienteEncontrado != null) {
			expedienteEncontrado.getDocumentos().remove(codigoDocumento);
		}
		logger.info("Saliendo de desasociar documnto al expediente.");
		return null;
			
	}
	
	@Override
	public Expediente obtenerExpedientePorCodigo(Integer codigoExpediente) {
		
		logger.info("Entrando en obtener expediente por codigo.");
		
		Optional<Expediente> expedienteEncontrado = expedientes.stream().
				filter(d -> tieneIgualCodigo(d, codigoExpediente)).
				findFirst();
		
		if (expedienteEncontrado.isPresent()) {
			return expedienteEncontrado.get();
		}
		logger.info("Saliendo de obtener expediente por codigo.");
		return null;
	}

	@Override
	public List<Expediente> obtenerTodosLosExpedientes() {
		
		logger.info("Entrando en obtener todos los expediente.");
		logger.info("Saliendo de obtener todos los expediente.");
		
		return expedientes;
	}

	protected boolean tieneIgualCodigo(Expediente expediente, Integer codigo) {
		return expediente.getCodigo().equals(codigo);
	}

	@Override
	public void cargarExpedienteEnArchivo() {
		
		logger.info("Inicio de la carga de expedientes:");

		try {
			file = new FileWriter(RUTA_LISTA, true);
			pw = new PrintWriter(file);

			for (Expediente exp : expedientes) {
				pw.println("***********************");
				pw.println("Codigo :" + exp.getCodigo() + " ");
				pw.println("Nombre " + exp.getNombre() + " ");
				pw.println("Fecha de creación: " + exp.getFechaCreacion() + " ");
				pw.println("Publico: " + exp.getPublico() + " ");
				pw.println("Fecha de Ultima Modificación: " + exp.getFechaUltimaModificacion() + " ");
				pw.println("Estado: " + exp.getEstado() + " ");
				pw.println("***********************");
				pw.println(" ");
				
			}
			pw.close();

		} catch (IOException ex) {
			System.out.println("Error: ");
		}

		logger.info("Carga de expedientes realizada.");
		
	}

	@Override
	public void listarEnAlta(Expediente expediente) {
		
logger.info("Listando expedientes en Alta:");
		
		try {
			file = new FileWriter(RUTA_ALTA, true);
			pw = new PrintWriter(file);
			
			pw.println("***********************");
			pw.println("Código: " +expediente.getCodigo());
			pw.println("Nombre: "+expediente.getNombre());
			pw.println("Fecha de creación: "+expediente.getFechaCreacion());
			pw.println("Público: "+expediente.getPublico());
			pw.println("Fecha última modificación: "+expediente.getFechaUltimaModificacion());
			pw.println("Estado: "+expediente.getEstado());
			pw.println("***********************");
			pw.println(" ");
			pw.close();
		} catch (IOException ex) {
			System.out.println("Error: ");
		}
		
		logger.info("Fin de listar expediente en Alta.");
	}

	@Override
	public void listarModificados(Expediente expediente) {
		
logger.info("Listando expediente en Modificados:");
		
		try {
			file = new FileWriter(RUTA_MODIFICADO, true);
			pw = new PrintWriter(file);
			
			pw.println("***********************");
			pw.println("Código: " +expediente.getCodigo());
			pw.println("Nombre: "+expediente.getNombre());
			pw.println("Fecha de creación: "+expediente.getFechaCreacion());
			pw.println("Público: "+expediente.getPublico());
			pw.println("Fecha última modificación: "+expediente.getFechaUltimaModificacion());
			pw.println("Estado: "+expediente.getEstado());
			pw.println("***********************");
			pw.println(" ");
			pw.close();
		} catch (IOException ex) {
			System.out.println("Error: ");
		}
		
		logger.info("Fin de listar expediente en Modificados.");
		
	}

	@Override
	public void listarEliminados(Integer codigo) {
		
logger.info("Listando expediente en Eliminados:");
		
		Expediente expedienteEncontrado = expedientes.stream().filter(d -> tieneIgualCodigo(d, codigo)).findFirst()
				.orElseGet(null);

		if (expedienteEncontrado != null) {
			try {
				file = new FileWriter(RUTA_ELIMINADO, true);
				pw = new PrintWriter(file);
				
				pw.println("***********************");
				pw.println("Código: " +expedienteEncontrado.getCodigo());
				pw.println("Nombre: "+expedienteEncontrado.getNombre());
				pw.println("Fecha de creación: "+expedienteEncontrado.getFechaCreacion());
				pw.println("Público: "+expedienteEncontrado.getPublico());
				pw.println("Fecha última modificación: "+expedienteEncontrado.getFechaUltimaModificacion());
				pw.println("Estado: "+expedienteEncontrado.getEstado());
				pw.println("***********************");
				pw.println(" ");
				pw.close();
			} catch (IOException ex) {
				System.out.println("Error: ");
			}
		}
				
		logger.info("Fin de listar expediente en Eliminados.");
		
	}


}
