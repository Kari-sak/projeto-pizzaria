package aplicacao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dominio.Ingrediente;
import dominio.Pizza;
import dominio.Tipo;

public class ExibindoPizza {

	public static void main(String[] args) throws IOException {
		
		Path path = FileSystems.getDefault().getPath("arquivos-extras/pizza-mussarela.jpg");
		byte[] foto = Files.readAllBytes(path);
		
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
		//p1.setFoto(foto);
		p1.getIngredientes().add(massa);
		p1.getIngredientes().add(tomate); 
		p1.getIngredientes().add(queijo); 
		p1.getIngredientes().add(azeite); 
		p1.getIngredientes().add(oregano);
		
		em.persist(p1);
		
		em.getTransaction().commit();

		System.out.println("Feito!");
		
		em.detach(p1);
	
		//Pizza pizza1 = em.find(Pizza.class, p1.getCodigo());
		//if (pizza1.getFoto() != null) {
		//	BufferedImage img = ImageIO.read(new ByteArrayInputStream(pizza1.getFoto()));
		//	JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
		//} else {
		//	System.out.println("Pizza não possui foto.");
		//}
		
		em.close(); 
		emf.close();
		
	}

}
