package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Enfermedad
 *
 */
@Entity

public class Enfermedad implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	private String tipo;
	private String nombre;
	private String sintomas;
	
	@ManyToOne
	@JoinColumn
	private Ficha ficha;
	
	public Enfermedad() {
		
	}

	public Enfermedad(String tipo, String nombre, String sintomas) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.sintomas = sintomas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	
   
}
