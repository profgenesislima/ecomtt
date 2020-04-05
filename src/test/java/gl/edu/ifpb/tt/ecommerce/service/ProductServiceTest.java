package gl.edu.ifpb.tt.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import gl.edu.ifpb.tt.ecommerce.entity.Product;
import gl.edu.ifpb.tt.ecommerce.repository.ProductDAO;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductDAO productDAO;
	
	
	@Before
	public void setup() {
		Product book = new Product();
		book.setName("Livro Java como Programar");
		
		Mockito.when(productDAO.findByName(book.getName())).thenReturn(book);
	}
	@TestConfiguration
	static class ProductServiceTestContextConfiguration{
		
		@Bean
		public ProductServiceImpl productService() {
			return new ProductServiceImpl();
		}
		
		
	}
	
	@Test
	public void whenValidNameThenProductShoudBeFound() {
	
		String name = "Livro Java como Programar";
		
		Product productFound = productService.getByName(name);
		
		assertEquals(productFound.getName(), name);
	}
	
}
