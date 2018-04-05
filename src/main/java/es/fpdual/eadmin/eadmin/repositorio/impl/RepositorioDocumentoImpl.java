package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	final File fichero = new File("documentos.txt");
	final String RUTA_LISTA = "LISTA.txt";
	final String RUTA_ALTA = "ALTA.TXT";
	final String RUTA_MODIFICADO = "MODIFICADO.TXT";
	final String RUTA_ELIMINADO = "ELIMINAR.TXT";
	FileWriter file = null;
	PrintWriter pw = null;
	
	private static final Logger logger = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);

	private List<Documento> documentos = new ArrayList<>();

	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public void altaDocumento(Documento documento) {
		
		

		logger.info("Entrando en altaDocumento");

		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe.");
		}

		documentos.add(documento);
		
		logger.info(documento.toString() + " creado correctamente.");

		logger.info("Saliendo de altaDocumento");

	}

	@Override
	public void modificarDocumento(Documento documento) {

		logger.info("Entrando en modificarDocumento");

		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ha modificar no existe.");
		}

		documentos.set(documentos.indexOf(documento), documento);

		logger.info("Saliendo de modificarDocumento");

	}

	@Override
	public void eliminarDocumento(Integer codigo) {

		logger.info("Entrando en eliminarDocumento");

		/*
		 * Documento documentoEncontrado = null;
		 * 
		 * for (int i = 0; i< documentos.size(); i++) {
		 * if(documentos.get(i).getCodigo().equals(codigo)) { documentoEncontrado =
		 * documentos.get(i); break; } }
		 */

		Documento documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo)).findFirst()
				.orElseGet(null);

		if (documentoEncontrado != null) {
			documentos.remove(documentoEncontrado);
		}

		logger.info("Saliendo de eliminarDocumento");
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {

		logger.info("Entrando en obtenerDocumentoPorCodigo");

		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {

			logger.info("************************************************************");
			logger.info("Documento " + documentoEncontrado.get().getCodigo());
			logger.info("Nombre " + documentoEncontrado.get().getNombre());
			logger.info("Fecha_Creacion " + documentoEncontrado.get().getFechaCreacion());
			logger.info("publico " + documentoEncontrado.get().getPublico());
			logger.info("Fecha_Ulima_Modificacion " + documentoEncontrado.get().getFechaUltimaModificacion());
			logger.info("Estado " + documentoEncontrado.get().getEstado());
			logger.info("************************************************************");
			return documentoEncontrado.get();

		}

		logger.info("Saliendo de obtenerDocumentoPorCodigo");
		return null;

	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {

		logger.info("Entrando en obtenerTodosLosDocumentos");

		for (Documento doc : documentos) {
			logger.info("************************************************************");
			logger.info("Documento: " + doc.getCodigo());
			logger.info("Nombre " + doc.getNombre());
			logger.info("Fecha_creacion " + doc.getFechaCreacion());
			logger.info("publico " + doc.getPublico());
			logger.info("Fecha_Ultima_Modificacion " + doc.getFechaUltimaModificacion());
			logger.info("Estado " + doc.getEstado());
			logger.info("************************************************************");

		}

		logger.info("Saliendo de obtenerTodosLosDocumentos");
		return documentos;

	}

	protected boolean tieneIgualCodigo(Documento documento, Integer codigo) {

		logger.info("Entrando en tieneIgulCodigo");

		logger.info("Saliendo de tieneIgualCodigo");

		return documento.getCodigo().equals(codigo);

	}

	public void cargarDocumentoEnArchivo() {

		logger.info("Inicio de la carga de documentos:");

			try {
				file = new FileWriter(RUTA_LISTA, true);
				pw = new PrintWriter(file);

				for (Documento doc : documentos) {
					pw.println("***********************");
					pw.println("Codigo :" + doc.getCodigo() + " ");
					pw.println("Nombre " + doc.getNombre() + " ");
					pw.println("Fecha de creación: " + doc.getFechaCreacion() + " ");
					pw.println("Publico: " + doc.getPublico() + " ");
					pw.println("Fecha de Ultima Modificación: " + doc.getFechaUltimaModificacion() + " ");
					pw.println("Estado: " + doc.getEstado() + " ");
					pw.println("***********************");
					pw.println(" ");
					
				}
				pw.close();

			} catch (IOException ex) {
				System.out.println("Error: ");
			}

			logger.info("Carga de documentos realizada.");
			
		}
	
	public void listarEnAlta(Documento documento) {
		
		logger.info("Listando documentos en Alta:");
		
		try {
			file = new FileWriter(RUTA_ALTA, true);
			pw = new PrintWriter(file);
			
			pw.println("***********************");
			pw.println("Código: " +documento.getCodigo());
			pw.println("Nombre: "+documento.getNombre());
			pw.println("Fecha de creación: "+documento.getFechaCreacion());
			pw.println("Público: "+documento.getPublico());
			pw.println("Fecha última modificación: "+documento.getFechaUltimaModificacion());
			pw.println("Estado: "+documento.getEstado());
			pw.println("***********************");
			pw.println(" ");
			pw.close();
		} catch (IOException ex) {
			System.out.println("Error: ");
		}
		
		logger.info("Fin de listar en Alta.");
		
	}
	
	public void listarModificados(Documento documento) {
		
		logger.info("Listando documento en Modificados:");
		
		try {
			file = new FileWriter(RUTA_MODIFICADO, true);
			pw = new PrintWriter(file);
			
			pw.println("***********************");
			pw.println("Código: " +documento.getCodigo());
			pw.println("Nombre: "+documento.getNombre());
			pw.println("Fecha de creación: "+documento.getFechaCreacion());
			pw.println("Público: "+documento.getPublico());
			pw.println("Fecha última modificación: "+documento.getFechaUltimaModificacion());
			pw.println("Estado: "+documento.getEstado());
			pw.println("***********************");
			pw.println(" ");
			pw.close();
		} catch (IOException ex) {
			System.out.println("Error: ");
		}
		
		logger.info("Fin de listar en Modificados.");
		
	}
	
	public void listarEliminados(Integer codigo) {
		
		logger.info("Listando documento en Eliminados:");
		
		Documento documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo)).findFirst()
				.orElseGet(null);

		if (documentoEncontrado != null) {
			try {
				file = new FileWriter(RUTA_ELIMINADO, true);
				pw = new PrintWriter(file);
				
				pw.println("***********************");
				pw.println("Código: " +documentoEncontrado.getCodigo());
				pw.println("Nombre: "+documentoEncontrado.getNombre());
				pw.println("Fecha de creación: "+documentoEncontrado.getFechaCreacion());
				pw.println("Público: "+documentoEncontrado.getPublico());
				pw.println("Fecha última modificación: "+documentoEncontrado.getFechaUltimaModificacion());
				pw.println("Estado: "+documentoEncontrado.getEstado());
				pw.println("***********************");
				pw.println(" ");
				pw.close();
			} catch (IOException ex) {
				System.out.println("Error: ");
			}
		}
				
		logger.info("Fin de listar en Eliminados.");
		
	}

	}
