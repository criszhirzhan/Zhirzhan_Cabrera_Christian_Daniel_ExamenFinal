package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ficha
 *
 */
@Entity

public class Ficha implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	
	private String presion;
	private String frecuenciaCardiaca;
	private String frecuenciaRespiratoria;
	private int temperatura;
	private String saturacion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ficha")
	private List<Enfermedad> enfermedades;

	public Ficha() {
		
	}

	public Ficha(List<Enfermedad> enfermedades, String presion, String frecuenciaCardiaca,
			String frecuenciaRespiratoria, int temperatura, String saturacion) {
		
		this.enfermedades = enfermedades;
		this.presion = presion;
		this.frecuenciaCardiaca = frecuenciaCardiaca;
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
		this.temperatura = temperatura;
		this.saturacion = saturacion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<Enfermedad> getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(List<Enfermedad> enfermedades) {
		this.enfermedades = enfermedades;
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
	
	
   
}
