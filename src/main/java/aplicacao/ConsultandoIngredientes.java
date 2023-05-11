package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Ingrediente;
import dominio.Pizza;

public class ConsultandoIngredientes {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-pizzaria");
		EntityManager em = emf.createEntityManager();

		Pizza p1 = em.find(Pizza.class, 1L);
		System.out.println("Pizza: " + p1.getNome());
		
		for (Ingrediente ingrediente : p1.getIngredientes()) {
			System.out.println("Ingrediente: " + ingrediente.getDescricaoIngrediente());
		}
		
		System.out.println("Feito!");
		
		em.close(); 
		emf.close();
		
		}

	}

