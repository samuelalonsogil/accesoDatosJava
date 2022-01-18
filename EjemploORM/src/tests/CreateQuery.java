package tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Persona;

public class CreateQuery {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("HibernateEjemplo1");
		em = emf.createEntityManager();
		
		String hql = "FROM Persona WHERE p.apellido='Alonso'";
		List <Persona> personas = em.createQuery(hql).getResultList();
		
		for(Persona per : personas) {
			System.out.println(per);
			System.out.println(per.getApellidos()+"\t"+per.getNombre());
		}
		
	}
}
