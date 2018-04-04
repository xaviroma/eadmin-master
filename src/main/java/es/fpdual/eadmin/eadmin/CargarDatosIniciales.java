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
		
		repositorioDocumento.altaDocumento(new Documento (1,"documento1", FECHA, true, FECHA, EstadoDocumento.ACTIVO));
		repositorioDocumento.altaDocumento(new Documento (2, "documento2", FECHA, false, FECHA, EstadoDocumento.APROBADO));
		repositorioDocumento.altaDocumento(new Documento (3, "documeno3", FECHA, true, FECHA, EstadoDocumento.ELIMINADO));
		
		repositorioExpediente.altaExpediente(new Expediente(1, "expediente1", FECHA, true, FECHA, FECHA, EstadoExpediente.ARCHIVADO,null));
			
	}
	
	

}
