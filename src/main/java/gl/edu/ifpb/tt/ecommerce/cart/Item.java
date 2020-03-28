package gl.edu.ifpb.tt.ecommerce.cart;

import gl.edu.ifpb.tt.ecommerce.entity.Product;
import lombok.Data;

@Data
public class Item {

	private Product product;
	private int quantity;
	private String description;
	
	public Item(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	
}
