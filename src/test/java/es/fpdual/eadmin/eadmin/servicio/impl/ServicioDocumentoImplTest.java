package es.fpdual.eadmin.eadmin.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

public class ServicioDocumentoImplTest {
	
	private ServicioDocumentoImpl servicioDocumento;

	private static final Documento DOCUMENTO = mock (Documento.class);
	// Instanciamos mock
	
	private final RepositorioDocumento repositorioDocumento = mock (RepositorioDocumento.class);  
	// Instanciamos mock
	
	
	@Before
	public void InicializarEnCadaTest() {
		
		this.servicioDocumento = spy(new ServicioDocumentoImpl(repositorioDocumento));
		// Con el SPY modificamos el comportamieno de un objeto de verdad, en este caso el servicio.
		
	}
	
	@Test
	public void deberiaAlmacenarUnDocumento() {

		final Documento documentoModificado = mock (Documento.class);

		
		// Definimos el comportamiento para el SPY
		doReturn(documentoModificado).
		when(this.servicioDocumento).devolverConFechaCorrecta(DOCUMENTO); 

		final Documento resultado = this.servicioDocumento.altaDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).altaDocumento(documentoModificado);
		
		assertSame(resultado, documentoModificado);

	}
	
	@Test
	public void deberiaModificarUnDocumento() {
		
		final Documento documentoModificado = mock (Documento.class);
		
		doReturn(documentoModificado).
		when(this.servicioDocumento).agregarFechaModificacion(DOCUMENTO);
		
		final Documento resultado = this.servicioDocumento.modificarDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).modificarDocumento(documentoModificado);
		
		assertSame(resultado, documentoModificado);

	}
	
	@Test
	public void deberiaEliminarUnDocumento() {
		
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		
		this.servicioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		
		verify(this.repositorioDocumento).eliminarDocumento(1);
	}
	
	@Test
	public void deberiaObtenerDocumentoPorCodigo() {
		
		when(this.repositorioDocumento.obtenerDocumentoPorCodigo(1)).
		thenReturn(DOCUMENTO);
		
		final Documento resultado = this.repositorioDocumento.obtenerDocumentoPorCodigo(1);
		
		assertSame(resultado, DOCUMENTO);
	}
	
	@Test
	public void deberiaObtenerTodosDocumentos() {
		
		final List<Documento> documentos = new ArrayList<>();
		
		when(this.repositorioDocumento.obtenerTodosLosDocumentos()).
		thenReturn(documentos);
		
		final List<Documento> resultado = this.repositorioDocumento.obtenerTodosLosDocumentos();
				
		assertSame(resultado, documentos);

	}

}

