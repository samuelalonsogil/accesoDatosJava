package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import model.Direccion;
import model.Empleado;

public class Test01Persist {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("HibernateEjemplo1");
		em = emf.createEntityManager();
		
		
		/*persistir un empleado*/
		/*primero crear el objeto direccion*/
		Direccion direccion = new Direccion();
		direccion.setId(01);
		direccion.setCiudad("Moaña");
		direccion.setDireccion("calle falsa 123");
		direccion.setProvincia("Pontevedra");
		
		Empleado empleado= new Empleado();
		empleado.setApellidos("Alonso");
		empleado.setCodigo(02);
		empleado.setDireccion(direccion);
		empleado.setNombre("Samuel");
		empleado.setSueldo(2000);
		
		try {
		em.getTransaction().begin();
		em.persist(empleado);
		em.getTransaction().commit();
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		em.close();
		emf.close();

	}

}
