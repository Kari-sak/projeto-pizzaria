package dominio;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ingrediente")
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 50, nullable = false)
	private String descricaoIngrediente;
	
	@ManyToMany
	private Set <Pizza> pizzas = new HashSet<>();

	public Ingrediente() {

	}

	public Ingrediente(Long codigo, String descricaoIngrediente, Set<Pizza> pizzas) {
		super();
		this.codigo = codigo;
		this.descricaoIngrediente = descricaoIngrediente;
		this.pizzas = pizzas;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricaoIngrediente() {
		return descricaoIngrediente;
	}

	public void setDescricaoIngrediente(String descricaoIngrediente) {
		this.descricaoIngrediente = descricaoIngrediente;
	}

	public Set<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	@Override
	public String toString() {
		return "Ingrediente [codigo=" + codigo + ", descricaoIngrediente=" + descricaoIngrediente + ", pizzas=" + pizzas
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, descricaoIngrediente, pizzas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(descricaoIngrediente, other.descricaoIngrediente)
				&& Objects.equals(pizzas, other.pizzas);
	}

}
