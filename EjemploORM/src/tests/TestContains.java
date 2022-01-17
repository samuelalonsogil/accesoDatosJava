package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Persona;

public class TestContains {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("HibernateEjemplo1");
		em = emf.createEntityManager();
		
		Persona persona = em.find(Persona.class, 1);
		boolean existe = em.contains(persona);
		
		if(existe) System.out.println(persona + "est� en el contexto");
		else System.out.println(persona + "no est� en el contexto");
		
		em.detach(persona);
		System.out.println("Despu�s del detach");
		
		if(existe) System.out.println(persona + "est� en el contexto");
		else System.out.println(persona + "no est� en el contexto");
	}

}
