package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.edu.ups.modelo.Paciente;

@Stateless
public class PacienteFacade extends AbstractFacade<Paciente> {

	public PacienteFacade() {
		super(Paciente.class);
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName= "citas")
	private EntityManager entityManager;
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

}
