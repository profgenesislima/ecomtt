package gl.edu.ifpb.tt.ecommerce.cart;

import java.util.ArrayList;
import java.util.List;

import gl.edu.ifpb.tt.ecommerce.entity.Product;
import gl.edu.ifpb.tt.ecommerce.exceptions.InvalidProductIdException;

public class ShoppingCart {

	private List<Item> cart = new ArrayList<Item>();
	
	public void addItem(Item item) {		
		this.cart.add(item);
	}
	
	public void removeItem(Item item) {
		this.cart.remove(item);
	}

	public void updateItem(Item item) throws InvalidProductIdException {
		Item itm = this.cart.stream()
				.filter(i -> i.equals(item)).findAny().get();	
		if(itm!=null) {			
			itm.setProduct(item.getProduct());
			itm.setQuantity(item.getQuantity());
			itm.setDescription(item.getDescription());
		}
	}
	
	public List<Item> getCart(){
		return this.cart;
	}

	public Item getItemByProduct(Product product) {
		return this.cart.stream().
				filter(i->i.getProduct() == product).findAny().get();
	}
	
}
