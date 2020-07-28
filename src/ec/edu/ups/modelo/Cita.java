package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cita
 *
 */
@Entity

public class Cita implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	private Date fecha;
	
	
	@OneToOne
	@JoinColumn
	private Ficha fichamedica;
	
	@ManyToOne
	@JoinColumn
	private Paciente paciente;
	

	public Cita() {
		
	}


	public Cita(Paciente paciente, Date fecha, Ficha fichamedica) {
		super();
		this.paciente = paciente;
		this.fecha = fecha;
		this.fichamedica = fichamedica;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Ficha getFichamedica() {
		return fichamedica;
	}


	public void setFichamedica(Ficha fichamedica) {
		this.fichamedica = fichamedica;
	}
	
	
   
}
