package es.fpdual.eadmin.eadmin.repositorio.impl;


import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;

public class RepositorioDocumentoTest {
	
	private RepositorioDocumentoImpl repositorioDocumento;
	
	private static final Integer CODIGO_DOCUMENTO = 1;
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Date FECHA_CREACION = new Date();
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Date FECHA_MODIFICACION = new Date();
	private static final Documento DOCUMENTO = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO, FECHA_MODIFICACION, EstadoDocumento.ACTIVO);
	
	@Before
	public void InicializarEnCadaTest() {
		this.repositorioDocumento = new RepositorioDocumentoImpl();
	}
	
	@Test
	public void probarAltaDeUnDocumento() {
		RepositorioDocumentoImpl RepositorioDocumento = new RepositorioDocumentoImpl();
		
		RepositorioDocumento.altaDocumento(DOCUMENTO);
	}
	
	@Test
	public void probarAltaDeDosDocumentos() {
		RepositorioDocumentoImpl RepositorioDocumento = new RepositorioDocumentoImpl();
		
		RepositorioDocumento.altaDocumento(DOCUMENTO);
		RepositorioDocumento.altaDocumento(DOCUMENTO);
	}
	
	@Test
	public void modificarDocumentoQueExiste() {
		this.repositorioDocumento.getDocumentos().add(DOCUMENTO);
		this.repositorioDocumento.modificarDocumento(DOCUMENTO);
		
	}
	
	@Test
	public void modificarDocumentoQueNoExiste() {
		this.repositorioDocumento.modificarDocumento(DOCUMENTO);
		
	}
	
	@Test
	public void eliminarDocumentoQueSiExiste() {
		
		this.repositorioDocumento.getDocumentos().add(DOCUMENTO);
		this.repositorioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		
		assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
	}
	
	@Test
	public void eliminarDocumentoQueNoExiste() {

		this.repositorioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
	}
	
	@Test
	public void obtenerDocumentoPorCodigoSiExiste() {
		this.repositorioDocumento.getDocumentos().add(DOCUMENTO);
		Documento documento2 = this.repositorioDocumento.obtenerDocumentoPorCodigo(DOCUMENTO.getCodigo());
		assertTrue(documento2.equals(DOCUMENTO));
	}
	
	@Test
	public void obtenerDocumentoPorCodigoSiNoExiste() {
		Documento documento2 = this.repositorioDocumento.obtenerDocumentoPorCodigo(DOCUMENTO.getCodigo());
		assertTrue(documento2.equals(DOCUMENTO));
	}
	
	@Test
	public void obtenerTodosLosDocumentos() {
		List<Documento> resultado = this.repositorioDocumento.obtenerTodosLosDocumentos();
		
		assertSame(repositorioDocumento.getDocumentos(), resultado);
		
	}

}


	

