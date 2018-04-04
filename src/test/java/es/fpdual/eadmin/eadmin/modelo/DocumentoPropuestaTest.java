package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoPropuestaTest {
	
	private static final Integer CODIGO_DOCUMENTO = 1;
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Date FECHA_CREACION = new Date();
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Date FECHA_MODIFICACION = new Date();
	private static final Integer CODIGO_PROPUESTA = 123;
	private static final Integer EJERCICIO_PROPUESTA = 56;
	private static final String GRUPO_POLITICO = "VACIO";

	
	DocumentoPropuesta doc_pro1;
	@Before
	public void Inicializar() {
		doc_pro1 = new DocumentoPropuesta(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO, FECHA_MODIFICACION, EstadoDocumento.ACTIVO, CODIGO_PROPUESTA, EJERCICIO_PROPUESTA, GRUPO_POLITICO);
	}

	@Test
	public void DOCUMENTO_CONTABLE() {
				
		assertEquals(CODIGO_PROPUESTA, doc_pro1.getCodigo_pro());
		assertEquals(EJERCICIO_PROPUESTA, doc_pro1.getEjercicio());
		assertEquals(GRUPO_POLITICO, doc_pro1.getGrupoPolitico());
	
	}
	
	public void pruebaToString() {
		doc_pro1.toString();
	}
	
	
}
