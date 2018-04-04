package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoTest {
	
	private static final Integer CODIGO_DOCUMENTO = 1;
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Date FECHA_CREACION = new Date();
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Date FECHA_MODIFICACION = new Date();
	
	Documento documento1;
	
	@Before
	public void Inicializar() {
		documento1 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO, FECHA_MODIFICACION, EstadoDocumento.ACTIVO);
	}
	
	
	/* Método para comprobar los métodos "get" */
	
	@Test
	public void DOCUMENTO_PUBLICO() {
				
		assertEquals(CODIGO_DOCUMENTO, documento1.getCodigo());
		assertEquals(NOMBRE_DOCUMENTO, documento1.getNombre());
		assertEquals(FECHA_CREACION, documento1.getFechaCreacion());
		assertEquals(DOCUMENTO_PUBLICO, documento1.getPublico());
		assertEquals(EstadoDocumento.ACTIVO, documento1.getEstado());
	
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {
		final Documento doc2 = new Documento(CODIGO_DOCUMENTO, null, null, null, null, null);

		final Boolean resultado = doc2.equals(documento1);
		assertTrue(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
		final Documento doc2 = new Documento(5, null, null, null, null, null);

		final Boolean resultado = doc2.equals(documento1);
		assertFalse(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiNoEsUnDocumento() {
		final boolean resultado = documento1.equals(new Date());
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverHasCodeDelCodigo() {
		final int resultado = documento1.hashCode();
		Documento doc2 = new Documento(CODIGO_DOCUMENTO, "nombre", null, null, null, null);
		
		assertEquals(resultado, doc2.hashCode());
	}
	
	@Test
	public void NoDevolvervacio() {
		assertNotNull(toString());
	}

	
	
}
