package gl.edu.ifpb.tt.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gl.edu.ifpb.tt.ecommerce.cart.ShoppingCart;

@Controller
@RequestMapping("checkout")
public class CheckoutController {

	@RequestMapping("/")
	public String paymentPage() {		
		return "/cart/checkout/index";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String checkout(ShoppingCart cart) {
		
		
		
		return "redirect:/cart/index";
		}
	
	
}
