package gl.edu.ifpb.tt.ecommerce.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gl.edu.ifpb.tt.ecommerce.cart.Item;
import gl.edu.ifpb.tt.ecommerce.entity.Order;
import gl.edu.ifpb.tt.ecommerce.entity.Product;
import gl.edu.ifpb.tt.ecommerce.service.OrderService;

@Controller
@RequestMapping("checkout")
public class CheckoutController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(name="/", method=RequestMethod.GET)
	public String paymentPage() {		
		return "/cart/checkout/index";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String checkout(HttpSession session) {
             
		List<Product> products = new ArrayList<Product>();
		List<Item> cartItems = (List<Item>) session.getAttribute("cart");
		cartItems.stream().map(i -> i.getProduct()).forEach(p-> {
			products.add(p);
		});
		
		orderService.save(new Order(LocalDate.now(),products));	
		
		return "redirect:/cart/index";
		}
	
	
}
