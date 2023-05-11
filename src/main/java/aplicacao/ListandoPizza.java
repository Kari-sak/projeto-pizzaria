package aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Pizza;

public class ListandoPizza {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-pizzaria");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("select p from Pizza p");
				
		@SuppressWarnings("unchecked")
		List <Pizza> pizzas = query.getResultList();
		for (Pizza pizza : pizzas) {
			System.out.println(pizza.getCodigo() + " - "
					+ pizza.getNome() + " - "
					+ pizza.getEndereco() + " - "
					+ pizza.getTelefone() + " - "
					+ pizza.getQtd() + " - "
					+ pizza.getPreco() + " - "
					+ pizza.getTipo() + " - "
					+ pizza.getDataPedido() + " - " 
					+ pizza.getIngredientes());
		}
		
		System.out.println("Feito!");
		
		em.close();
		emf.close();

	}

}
