package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CitaFacade;
import ec.edu.ups.ejb.FichaFacade;
import ec.edu.ups.ejb.PacienteFacade;
import ec.edu.ups.modelo.Cita;
import ec.edu.ups.modelo.Ficha;
import ec.edu.ups.modelo.Paciente;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CitaBean implements Serializable {

	public CitaBean() {
		// TODO Auto-generated constructor stub
	}
	
	@EJB
	private PacienteFacade ejbPacienteFacade;
	
	@EJB
	private CitaFacade ejbCitaFacade;
	
	@EJB
	private FichaFacade ejbFichaFacade;
	
	private int codigoF;
	private String codigoP;
	
	private List<Paciente> pacientes;
	private List<Ficha> fichas;
	private List<Cita> citas;
	
	
	private Ficha fichaMedica;
	private String fecha;
	private Paciente paciente;
	
	@PostConstruct
	public void init() {

		pacientes=ejbPacienteFacade.findAll();
		fichas = ejbFichaFacade.findAll();
		citas = ejbCitaFacade.findAll();

	}

	public int getCodigoF() {
		return codigoF;
	}

	public void setCodigoF(int codigoF) {
		this.codigoF = codigoF;
	}



	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Ficha> getFichas() {
		return fichas;
	}

	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}
	
	

	public String getCodigoP() {
		return codigoP;
	}

	public void setCodigoP(String codigoP) {
		this.codigoP = codigoP;
	}

	public Ficha getFichaMedica() {
		return fichaMedica;
	}

	public void setFichaMedica(Ficha fichaMedica) {
		this.fichaMedica = fichaMedica;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public String add() {
		Date fecha = new Date();
		Ficha fi = new Ficha();
		fi=ejbFichaFacade.find(this.codigoF);
		paciente= ejbPacienteFacade.find(codigoP);
		
		ejbCitaFacade.create(new Cita(paciente, fecha, fi));
		
		citas = ejbCitaFacade.findAll();
		return null;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
	
	
	

}
