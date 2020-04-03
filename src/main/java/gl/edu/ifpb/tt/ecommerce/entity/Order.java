package gl.edu.ifpb.tt.ecommerce.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TB_ORDER")
@Data
public final class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private final LocalDate date;
	
	@ManyToMany
	@JoinTable(name="order_product", joinColumns = @JoinColumn(name="proudct_id"), inverseJoinColumns = @JoinColumn(name="order_id"))
	private final List<Product> products;
	
	public Order(LocalDate date, List<Product> products) {
		super();
		this.date = date;
		this.products = products;
	}
	
	
	
}
