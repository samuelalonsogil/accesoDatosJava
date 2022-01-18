package tests;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Persona;
import model.Persona.Estado;

public class TestDetach {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("HibernateEjemplo1");
		em = emf.createEntityManager();
		
		Persona persona = new Persona();
		
		System.out.println(persona);
		
		em.detach(persona);
		
		em.getTransaction().begin();
		persona.setApellidos("Alonso");
		persona.setEstado(Estado.Divorciado);
		persona.setFechaNacimiento(Calendar.getInstance());persona.setNombre("Samuel");
		persona.setSalario(2000);
		
		em.persist(persona);
		em.getTransaction().commit();
		
		System.out.println("Después de actualizar");
		System.out.println(persona);
		
		emf.close();
		em.close();
	}

}
