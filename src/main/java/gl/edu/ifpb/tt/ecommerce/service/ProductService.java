package gl.edu.ifpb.tt.ecommerce.service;

import java.util.List;

import gl.edu.ifpb.tt.ecommerce.entity.Product;

public interface ProductService {

	void save(Product product);
	void delete(Long id);
	List<Product> list();
	Product getById(Long id);
	Product getByName(String name);
}
