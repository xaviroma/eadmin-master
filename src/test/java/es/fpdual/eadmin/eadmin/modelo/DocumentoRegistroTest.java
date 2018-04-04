package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoRegistroTest {
	
	private static final Integer CODIGO_DOCUMENTO = 1;
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Date FECHA_CREACION = new Date();
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Date FECHA_MODIFICACION = new Date();
	private static final String NIFINTERESADO = "123";
	private static final String CONTROL_REGISTRO = "456";

	
	DocumentoRegistro doc_reg1;
	@Before
	public void Inicializar() {
		doc_reg1 = new DocumentoRegistro(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO, FECHA_MODIFICACION, EstadoDocumento.ACTIVO, NIFINTERESADO, CONTROL_REGISTRO);
	}
	
	@Test
	public void DOCUMENTO_CONTABLE() {			
		assertEquals(CONTROL_REGISTRO, doc_reg1.getControlRegistro());
		assertEquals(NIFINTERESADO, doc_reg1.getNifInteresado());
	}
	
	@Test
	public void probarToString() {
		doc_reg1.toString();
	}

}
