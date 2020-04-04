package gl.edu.ifpb.tt.ecommerce.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import gl.edu.ifpb.tt.ecommerce.exceptions.InvalidProductIdException;
import lombok.Data;


@Data
@Entity
@Table(name="TB_PRODUCT")
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="product_id")
	private Long id;
	private String name;
	private String description;	
	private double price;
	private String image;
	@ManyToMany(mappedBy = "products",fetch = FetchType.EAGER)
	private List<Order> orders;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) throws InvalidProductIdException {
		if(id>0) {
			this.id = id;
		}else {
			throw new InvalidProductIdException();
		}
		
	}
	
	
	
	
	
}
