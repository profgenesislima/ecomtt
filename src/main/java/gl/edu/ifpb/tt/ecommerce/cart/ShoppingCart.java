package gl.edu.ifpb.tt.ecommerce.cart;

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
public class ShoppingCart {

	private List<Item> cart = new ArrayList<Item>();
	
	@Autowired
	ProductService productService;
	
	public void addItem(Item item) {		
		this.cart.add(item);
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
	
	@RequestMapping("comprar/{id}")
	public String buyItem(@PathVariable("id") String id, HttpSession session) {
		if(session.getAttribute("cart") == null) {
			List<Item> shoppingCart = (List<Item>) session.getAttribute("cart");
			cart.add(new Item(productService.getById(Long.parseLong(id)), 1));
			session.setAttribute("cart", shoppingCart);
		}else {
			List<Item> shoppingCart= (List<Item>) session.getAttribute("cart");
			int index = this.alreadyExists(id, cart);
			if (index == -1) {
				cart.add(new Item(productService.getById(Long.parseLong(id)), 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);

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
