package aplicacao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Ingrediente;
import dominio.Pizza;
import dominio.Tipo;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-pizzaria");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Ingrediente massa = new Ingrediente();
		massa.setDescricaoIngrediente("Massa de pizza");
		Ingrediente tomate = new Ingrediente();
		tomate.setDescricaoIngrediente("Tomate");
		Ingrediente queijo = new Ingrediente();
		queijo.setDescricaoIngrediente("Queijo mussarela");
		Ingrediente calabresa = new Ingrediente();
		calabresa.setDescricaoIngrediente("Calabresa");
		Ingrediente catupiry = new Ingrediente();
		catupiry.setDescricaoIngrediente("Catupiry");
		Ingrediente frango = new Ingrediente();
		frango.setDescricaoIngrediente("Frango");
		Ingrediente cebola = new Ingrediente();
		cebola.setDescricaoIngrediente("Cebola");
		Ingrediente milho = new Ingrediente();
		milho.setDescricaoIngrediente("Milho");
		Ingrediente azeitona = new Ingrediente();
		azeitona.setDescricaoIngrediente("Azeitona");
		Ingrediente azeite = new Ingrediente();
		azeite.setDescricaoIngrediente("Azeite");
		Ingrediente oregano = new Ingrediente();
		oregano.setDescricaoIngrediente("Orégano");
		Ingrediente morango = new Ingrediente();
		morango.setDescricaoIngrediente("Morango");
		Ingrediente chocolate = new Ingrediente();
		chocolate.setDescricaoIngrediente("Chocolate");
		
		em.persist(massa);
		em.persist(tomate);
		em.persist(queijo);
		em.persist(calabresa);
		em.persist(catupiry);
		em.persist(frango);
		em.persist(cebola);
		em.persist(milho);
		em.persist(azeitona);
		em.persist(azeite);
		em.persist(oregano);
		em.persist(morango);
		em.persist(chocolate);
		
		Pizza p1 = new Pizza();
		p1.setNome("Mussarela - Pizza Hut");
		p1.setEndereco("R. Maria Cândida, 929 - Vila Guilherme");
		p1.setTelefone("(11) 2626-7867");
		p1.setQtd(1);
		p1.setPreco(84.90);
		p1.setTipo(Tipo.SALGADA);
		p1.setDataPedido(LocalDate.of(2023, 05, 05));
		p1.getIngredientes().add(massa);
		p1.getIngredientes().add(tomate); 
		p1.getIngredientes().add(queijo); 
		p1.getIngredientes().add(azeite); 
		p1.getIngredientes().add(oregano);
		
		Pizza p2 = new Pizza();
		p2.setNome("Calabresa - Pizzaria Jenagio");
		p2.setEndereco("R. Dona Gabriela, 95 - Parada Inglesa");
		p2.setTelefone("(11) 2987-2963");
		p2.setQtd(2);
		p2.setPreco(35.00);
		p2.setTipo(Tipo.SALGADA);
		p2.setDataPedido(LocalDate.of(2023, 05, 07));
		p2.getIngredientes().add(massa); 
		p2.getIngredientes().add(calabresa);
		p2.getIngredientes().add(cebola); 
		p2.getIngredientes().add(azeitona);
		p2.getIngredientes().add(azeite); 
		p2.getIngredientes().add(oregano);
		
		Pizza p3 = new Pizza();
		p3.setNome("Nutella com Morangos (Individual) - Pizzaria 1900");
		p3.setEndereco("R. Itapura, 787 - Tatuapé");
		p3.setTelefone("(11) 5575-1900");
		p3.setQtd(1);
		p3.setPreco(75.00);
		p3.setTipo(Tipo.DOCE);
		p3.setDataPedido(LocalDate.of(2023, 05, 28));
		p3.getIngredientes().add(massa); 
		p3.getIngredientes().add(morango); 
		p3.getIngredientes().add(chocolate); 
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		em.getTransaction().commit();
		
		System.out.println("Feito!");
		
		em.close();
		emf.close();

	}

}
