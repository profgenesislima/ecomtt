package gl.edu.ifpb.tt.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gl.edu.ifpb.tt.ecommerce.cart.Item;
import gl.edu.ifpb.tt.ecommerce.service.ProductService;

@Controller
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
	public String buy(@PathVariable("id") String id, HttpSession session) {		
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(productService.getById(Long.valueOf(id)),1));
			session.setAttribute("cart", cart);
		} else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = this.exists(Long.valueOf(id), cart);
			if (index == -1) {
				cart.add(new Item(productService.getById(Long.valueOf(id)), 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);
		}
		return "redirect:/cart/index";
	}
	
	private int exists(Long id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}

}
