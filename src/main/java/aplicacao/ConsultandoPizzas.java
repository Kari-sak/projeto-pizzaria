package aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pizza;

public class ConsultandoPizzas {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-pizzaria");
		EntityManager em = emf.createEntityManager();
		
		List <Pizza> pizzas = em.createQuery("select p from Pizza p", Pizza.class).getResultList();
			for (Pizza pizza : pizzas) {
				System.out.println(pizza.getNome() + " - R$ " + pizza.getPreco());
			}

		System.out.println("pronto!");
		em.close(); 
		emf.close();
		
	}

}
