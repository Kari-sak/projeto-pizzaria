package dominio;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tab_pizzaria")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length=60, nullable=false)
	private String nome;
	
	@Column(length=60, nullable=false)
	private String endereco;
	
	@Column(nullable=false)
	private String telefone;
	
	@Column(precision=10, nullable=false)
	private int qtd;
	
	@Column(precision=10, scale=2, nullable=true)
	private double preco;
	
	@Column(name="tipo_pizza", nullable=false)
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Column(name="data_pedido", nullable=false)
	private LocalDate dataPedido;
	
	//@Lob
	//private byte[] foto;
	
	@ManyToMany
	@JoinTable(name = "pizza_ingrediente",
	joinColumns = @JoinColumn(name = "pizza_codigo"),
	inverseJoinColumns = @JoinColumn(name = "ingrediente_codigo"))
	private Set <Ingrediente> ingredientes = new HashSet<>();
	
	public Pizza() {

	}

	public Pizza(Long codigo, String nome, String endereco, String telefone, int qtd, double preco, Tipo tipo,
			LocalDate dataPedido, Set<Ingrediente> ingredientes) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.qtd = qtd;
		this.preco = preco;
		this.tipo = tipo;
		this.dataPedido = dataPedido;
		this.ingredientes = ingredientes;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public String toString() {
		return "Pizza [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", qtd=" + qtd + ", preco=" + preco + ", tipo=" + tipo + ", dataPedido=" + dataPedido
				+ ", ingredientes=" + ingredientes + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, dataPedido, endereco, ingredientes, nome, preco, qtd, telefone, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(dataPedido, other.dataPedido)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(ingredientes, other.ingredientes)
				&& Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco) && qtd == other.qtd
				&& Objects.equals(telefone, other.telefone) && tipo == other.tipo;
	}
	
}
