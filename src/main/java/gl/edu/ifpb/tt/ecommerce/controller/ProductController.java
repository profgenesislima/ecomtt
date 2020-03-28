package gl.edu.ifpb.tt.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gl.edu.ifpb.tt.ecommerce.service.ProductService;

@Controller

public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public ModelAndView index(ModelAndView modelAndView) {		
		modelAndView.addObject("products", productService.list());
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	
}
