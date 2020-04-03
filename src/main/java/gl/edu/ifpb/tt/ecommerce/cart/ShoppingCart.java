package gl.edu.ifpb.tt.ecommerce.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gl.edu.ifpb.tt.ecommerce.entity.Product;
import gl.edu.ifpb.tt.ecommerce.exceptions.InvalidProductIdException;
import gl.edu.ifpb.tt.ecommerce.service.ProductService;

//@Controller
//@RequestMapping("cart")
public class ShoppingCart  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Item> items = new ArrayList<Item>();
	
	@Autowired
	ProductService productService;
	
	public void addItem(Item item) {		
		this.items.add(item);
	}
	
	@RequestMapping(value="remove/{id}",method = RequestMethod.GET)
	public String removeItem(@PathVariable("id") String id, HttpSession session) {
		
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = this.alreadyExists(id, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:/cart/index";
	}

	public void updateItem(Item item) throws InvalidProductIdException {
		Item itm = this.items.stream()
				.filter(i -> i.equals(item)).findAny().get();	
		if(itm!=null) {			
			itm.setProduct(item.getProduct());
			itm.setQuantity(item.getQuantity());
			itm.setDescription(item.getDescription());
		}
	}
	
	public List<Item> getItems(){
		return this.items;
	}

	public Item getItemByProduct(Product product) {
		return this.items.stream().
				filter(i->i.getProduct() == product).findAny().get();
	}
	
	@RequestMapping("comprar/{id}")
	public String buyItem(@PathVariable("id") String id, HttpSession session) {
		if(session.getAttribute("cart") == null) {
			List<Item> shoppingCart = (List<Item>) session.getAttribute("cart");
			items.add(new Item(productService.getById(Long.parseLong(id)), 1));
			session.setAttribute("cart", shoppingCart);
		}else {
			List<Item> shoppingCart= (List<Item>) session.getAttribute("cart");
			int index = this.alreadyExists(id, items);
			if (index == -1) {
				items.add(new Item(productService.getById(Long.parseLong(id)), 1));
			} else {
				int quantity = items.get(index).getQuantity() + 1;
				items.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", items);

		}
		return "redirect:/cart/index";
	}
	private int alreadyExists(String id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId() == Long.parseLong(id)) {
				return i;
			}
		}
		return -1;
	}
	
}
