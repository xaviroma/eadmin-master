package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ExpedieteTest {
	
	private static final Integer CODIGO_EXP = 1;
	private static final String NOMBRE_EXP = "nombre";
	private static final Date FECHA_CREACION_EXP = new Date();
	// private static final Date FECHA_ARCHIVADO_EXP = new Date();
	private static final Boolean PUBLICO_EXP = true;
	private static final Date FECHA_MODIFICACION = new Date();
	
	
	Expediente EXP1;
	@Before
	public void Inicializar() {
		EXP1 = new Expediente(CODIGO_EXP, NOMBRE_EXP, FECHA_CREACION_EXP, PUBLICO_EXP, FECHA_MODIFICACION, null, EstadoExpediente.INICIADO, null);
	}
	
	
	/* Método para comprobar los métodos "get" */
	
	@Test
	public void EXPEDIENTE_PUBLICO() {
				
		assertEquals(CODIGO_EXP, EXP1.getCodigo());
		assertEquals(NOMBRE_EXP, EXP1.getNombre());
		assertEquals(FECHA_CREACION_EXP, EXP1.getFechaCreacion());
		assertEquals(PUBLICO_EXP, EXP1.getPublico());
		assertEquals(EstadoExpediente.INICIADO, EXP1.getEstado());
	
	}
	
	@Test
	public void deberiaDevolverTrueSiTodoEsIgual() {
		final Expediente EXP2 = new Expediente(CODIGO_EXP, NOMBRE_EXP, FECHA_CREACION_EXP, PUBLICO_EXP, FECHA_MODIFICACION, null, EstadoExpediente.INICIADO, null);

		final Boolean resultado = EXP2.equals(EXP1);
		assertTrue(resultado);
	}
	
	@Test
	public void deberiaDevolverFalseSiElCodigoNoEsIgual() {
		final Expediente EXP2 = new Expediente(5, null, null, null, null, null, null, null);

		final Boolean resultado = EXP2.equals(EXP1);
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverFalseSiNoEsUnExpediente() {
		final Expediente EXP2 = new Expediente(5, null, null, null, null, null, null, null);
		
		final boolean resultado = EXP1.equals(new Date());
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverHasCodeDelCodigo() {
		final int resultado = EXP1.hashCode();
		final Expediente EXP2 = new Expediente(CODIGO_EXP, NOMBRE_EXP, FECHA_CREACION_EXP, PUBLICO_EXP, FECHA_MODIFICACION, null, EstadoExpediente.INICIADO, null);
		
		assertEquals(resultado,EXP2.hashCode());
	}
		
	
}
