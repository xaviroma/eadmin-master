package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoContableTest {
	
	private static final Integer CODIGO_DOCUMENTO = 1;
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Date FECHA_CREACION = new Date();
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Date FECHA_MODIFICACION = new Date();
	private static final BigDecimal IMPORTE = new java.math.BigDecimal("0");
	private static final String NIFINTERESADO = "nombre";

	
	DocumentoContable doc_cont1;
	@Before
	public void Inicializar() {
		doc_cont1 = new DocumentoContable(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO, FECHA_MODIFICACION, EstadoDocumento.ACTIVO, IMPORTE, NIFINTERESADO);
	}
	
	@Test
	public void DOCUMENTO_CONTABLE() {
				
		assertEquals(IMPORTE, doc_cont1.getImporte());
		assertEquals(NIFINTERESADO, doc_cont1.getNifInteresado());
	
	}
	
	@Test
	public void probarToString() {
		doc_cont1.toString();
	}

}
