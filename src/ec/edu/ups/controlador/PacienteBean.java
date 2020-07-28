package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.PacienteFacade;
import ec.edu.ups.modelo.Paciente;



@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PacienteBean implements Serializable{

	public PacienteBean() {
		// TODO Auto-generated constructor stub
	}
	

	@EJB
	private PacienteFacade ejbPacienteFacade;
	
	private String cedula;
	private String apellido;
	private String correo;
	private String direccion;
	private String nombre;
	
	@PostConstruct
	public void init() {
		System.out.println("listando clientes: ");
		ejbPacienteFacade.create(new Paciente("0124578536", "asdsed", "asds", "asdas", "asdasd"));
		

	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
