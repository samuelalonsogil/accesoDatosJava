package tests;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Persona;
import model.Persona.Estado;

public class Test01 {

	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	
	
	public static void main(String[] args) {
		
		//entityManagerFactory  es una interfaz que contiene los metodos para gestionar la bbdd
		
		entityManagerFactory = Persistence.createEntityManagerFactory("HibernateEjemplo1");
		entityManager = entityManagerFactory.createEntityManager();
		
		
		//abrimos transaccion
		entityManager.getTransaction().begin();
		
		//creamos el objeto persona
		Persona persona = new Persona();
		persona.setApellidos("Alonso");
		persona.setEstado(Estado.Soltero);
		persona.setFechaNacimiento(Calendar.getInstance());
		persona.setNombre("Samuel");
		persona.setSalario(2000.4);
		
		entityManager.persist(persona);
		entityManager.getTransaction().commit();
		//cierra el em
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("Fin del programa");
	}
}
