package gl.edu.ifpb.tt.ecommerce.entity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import gl.edu.ifpb.tt.ecommerce.exceptions.InvalidProductIdException;

@RunWith(JUnit4.class)
public class ProductTest {

	
private Product product;



	
	@Before
	public void initValues() throws InvalidProductIdException {
		this.product = new Product();
		
		
	}
	@Test(expected = InvalidProductIdException.class)
	public void produtoDeveTerId() throws InvalidProductIdException{
		this.product.setId((long) 0);

	}
	
	
	
}
