package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.EnfermedadFacade;
import ec.edu.ups.ejb.FichaFacade;
import ec.edu.ups.modelo.Enfermedad;
import ec.edu.ups.modelo.Ficha;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FichaBean implements Serializable {

	public FichaBean() {
		// TODO Auto-generated constructor stub
	}

	@EJB
	private FichaFacade ejbFichaFacade;
	
	@EJB
	private EnfermedadFacade ejbEnfermedadFacade;
	
	private Ficha ficha;
	private Enfermedad enferdad;

	private List<Ficha> fichas;
	private List<Enfermedad> enfermedades;

	private String presion;
	private String frecuenciaCardiaca;
	private String frecuenciaRespiratoria;
	private int temperatura;
	private String saturacion;
	
	
	private String tipo;
	private String nombre;
	private String sintomas;

	@PostConstruct
	public void init() {

		fichas = ejbFichaFacade.findAll();

	}

	public List<Ficha> getFichas() {
		return fichas;
	}

	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}

	public String getPresion() {
		return presion;
	}

	public void setPresion(String presion) {
		this.presion = presion;
	}

	public String getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(String frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}

	public String getFrecuenciaRespiratoria() {
		return frecuenciaRespiratoria;
	}

	public void setFrecuenciaRespiratoria(String frecuenciaRespiratoria) {
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public String getSaturacion() {
		return saturacion;
	}

	public void setSaturacion(String saturacion) {
		this.saturacion = saturacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	
	

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public Enfermedad getEnferdad() {
		return enferdad;
	}

	public void setEnferdad(Enfermedad enferdad) {
		this.enferdad = enferdad;
	}

	public String add() {
		this.ficha = new Ficha(this.presion, this.frecuenciaCardiaca, this.frecuenciaRespiratoria, this.temperatura, this.saturacion);
		
		ejbFichaFacade.create(this.ficha);
		
		this.enferdad = new Enfermedad(this.tipo, this.nombre, this.sintomas);
		this.enferdad.setFicha(ficha);
		ejbEnfermedadFacade.create(enferdad);
		
		enfermedades.add(enferdad);
		
		ficha.setEnfermedades(enfermedades);
		ejbFichaFacade.edit(ficha);
		
		
		return null;
	}
}
