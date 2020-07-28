package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Ficha;

@Stateless
public class FichaFacade extends AbstractFacade<Ficha>{

	public FichaFacade() {
		super(Ficha.class);
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
