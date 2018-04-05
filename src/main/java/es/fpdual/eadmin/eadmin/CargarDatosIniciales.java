package es.fpdual.eadmin.eadmin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.modelo.EstadoExpediente;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;


@Component
public class CargarDatosIniciales implements ApplicationRunner {
	
	private final RepositorioDocumento repositorioDocumento;
	private final RepositorioExpediente repositorioExpediente;
	
	private static final Date FECHA = new Date();
	
	@Autowired
	public CargarDatosIniciales(RepositorioDocumento repositorioDocumento, RepositorioExpediente repositorioExpediente) {
		this.repositorioDocumento = repositorioDocumento;
		this.repositorioExpediente = repositorioExpediente;
	}
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Documento documento1 = new Documento (1,"documento1", FECHA, true, FECHA, EstadoDocumento.ACTIVO);
		repositorioDocumento.altaDocumento(documento1);
		repositorioDocumento.listarEnAlta(documento1);
		
		Documento documento2 = new Documento (2, "documento2", FECHA, false, FECHA, EstadoDocumento.APROBADO);
		repositorioDocumento.altaDocumento(documento2);
		repositorioDocumento.listarEnAlta(documento2);
				
		Documento documento3 = new Documento (3, "documeno3", FECHA, true, FECHA, EstadoDocumento.ACTIVO);
		repositorioDocumento.altaDocumento(documento3);
		repositorioDocumento.listarEnAlta(documento3);
		
		Documento documento4 = new Documento (4, "documeno4", FECHA, true, FECHA, EstadoDocumento.ELIMINADO);
		repositorioDocumento.altaDocumento(documento4);
		repositorioDocumento.listarEnAlta(documento4);
	
		Documento documento5 = new Documento (5, "documeno5", FECHA, true, FECHA, EstadoDocumento.APROBADO);
		repositorioDocumento.altaDocumento(documento5);
		repositorioDocumento.listarEnAlta(documento5);
		
		repositorioDocumento.cargarDocumentoEnArchivo();
		
		Documento documento2Nuevo = new Documento (2, "documento2modificado", FECHA, true, FECHA, EstadoDocumento.APROBADO);
		repositorioDocumento.modificarDocumento(documento2Nuevo);
		repositorioDocumento.listarModificados(documento2Nuevo);
		
		Documento documento4nuevo = new Documento (4, "documeno3modificado", FECHA, false, FECHA, EstadoDocumento.ELIMINADO);
		repositorioDocumento.modificarDocumento(documento4nuevo);
		repositorioDocumento.listarModificados(documento4nuevo);
		
		repositorioDocumento.cargarDocumentoEnArchivo();

		repositorioDocumento.listarEliminados(documento1.getCodigo());
		repositorioDocumento.eliminarDocumento(documento1.getCodigo());		
		
		repositorioDocumento.listarEliminados(documento3.getCodigo());
		repositorioDocumento.eliminarDocumento(documento3.getCodigo());
		
		repositorioDocumento.listarEliminados(documento5.getCodigo());
		repositorioDocumento.eliminarDocumento(documento5.getCodigo());
		
		repositorioDocumento.cargarDocumentoEnArchivo();
		
	}
	
	

}
