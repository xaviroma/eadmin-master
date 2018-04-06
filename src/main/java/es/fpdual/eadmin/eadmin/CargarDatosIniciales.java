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
		
		Documento documento2 = new Documento (2, "documento2", FECHA, false, FECHA, EstadoDocumento.APROBADO);
		repositorioDocumento.altaDocumento(documento2);
				
		Documento documento3 = new Documento (3, "documeno3", FECHA, true, FECHA, EstadoDocumento.ACTIVO);
		repositorioDocumento.altaDocumento(documento3);
		
		Documento documento4 = new Documento (4, "documeno4", FECHA, true, FECHA, EstadoDocumento.ELIMINADO);
		repositorioDocumento.altaDocumento(documento4);
	
		Documento documento5 = new Documento (5, "documeno5", FECHA, true, FECHA, EstadoDocumento.APROBADO);
		repositorioDocumento.altaDocumento(documento5);
		
		repositorioDocumento.cargarDocumentoEnArchivo();
		
		Documento documento2Nuevo = new Documento (2, "documento2modificado", FECHA, true, FECHA, EstadoDocumento.APROBADO);
		repositorioDocumento.modificarDocumento(documento2Nuevo);
		
		Documento documento4nuevo = new Documento (4, "documeno3modificado", FECHA, false, FECHA, EstadoDocumento.ELIMINADO);
		repositorioDocumento.modificarDocumento(documento4nuevo);
		
		repositorioDocumento.cargarDocumentoEnArchivo();

		repositorioDocumento.eliminarDocumento(documento1.getCodigo());
		repositorioDocumento.eliminarDocumento(documento3.getCodigo());
		repositorioDocumento.eliminarDocumento(documento5.getCodigo());
		
		repositorioDocumento.cargarDocumentoEnArchivo();
		
		
		Expediente expediente1 = new Expediente(1,"Expediente1",FECHA, true, FECHA,FECHA,EstadoExpediente.INICIADO,null);
		repositorioExpediente.altaExpediente(expediente1);
		
		Expediente expediente2 = new Expediente(2,"Expediente2",FECHA, true, FECHA,FECHA,EstadoExpediente.EN_TRAMITE,null);
		repositorioExpediente.altaExpediente(expediente2);
		
		Expediente expediente3 = new Expediente(3,"Expediente3",FECHA, true, FECHA,FECHA,EstadoExpediente.ARCHIVADO,null);
		repositorioExpediente.altaExpediente(expediente3);
		
		Expediente expediente4 = new Expediente(4,"Expediente4",FECHA, true, FECHA,FECHA,EstadoExpediente.ARCHIVADO,null);
		repositorioExpediente.altaExpediente(expediente4);
		
		Expediente expediente5 = new Expediente(5,"Expediente5",FECHA, true, FECHA,FECHA,EstadoExpediente.INICIADO,null);
		repositorioExpediente.altaExpediente(expediente5);
		
		repositorioExpediente.cargarExpedienteEnArchivo();
		
		Expediente expediente1modificado = new Expediente(1,"Expediente1modificado",FECHA, true, FECHA,FECHA,EstadoExpediente.INICIADO,null);
		repositorioExpediente.modificarExpediente(expediente1modificado);
		
		Expediente expediente2modificado = new Expediente(2,"Expediente2modificado",FECHA, true, FECHA,FECHA,EstadoExpediente.EN_TRAMITE,null);
		repositorioExpediente.modificarExpediente(expediente2modificado);
		
		repositorioExpediente.cargarExpedienteEnArchivo();
		
		repositorioExpediente.eliminarExpediente(expediente3.getCodigo());
		repositorioExpediente.eliminarExpediente(expediente4.getCodigo());
		repositorioExpediente.eliminarExpediente(expediente5.getCodigo());
		
		repositorioExpediente.cargarExpedienteEnArchivo();
		
	}
	
	

}
