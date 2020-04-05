package gl.edu.ifpb.tt.ecommerce.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import gl.edu.ifpb.tt.ecommerce.entity.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private ProductDAO productDAO;
	
	/*Testa método do repositório que retorna produto pelo nome. Vale ressaltar que a 
	 * interface CrudRepository é implementada em tempo de execução (Runtime), 
	 * ou seja, o método findByName é criado no momento que é invocado e a 
	 * e o spring book framework utiliza-se do artifício da convenção ao invés de configuração
	 * (convention over configuration) para gerar a declaração JPQL responsável por 
	 * encontrar (find) uma ou mais linhas buscando por uma determinada propriedade (byName). 
	 * Ver documentação do Spring Boot para mais informações.
	 */
	
	@Test
	public void whenFindByNameThenReturnProduct() {
		
		//Dado... (Give)
		Product product = new Product();
		product.setName("JPA Professional");
		product.setDescription("Livro JPA Professional 2 Edição");
		
		//Quando... (When)
		testEntityManager.persist(product);
		testEntityManager.flush();
		
		//Então...(Then)
		Product productFound = productDAO.findByName(product.getName());
		assertEquals(productFound.getName(), product.getName());
		
		
	}
}
