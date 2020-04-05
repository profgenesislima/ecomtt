package gl.edu.ifpb.tt.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gl.edu.ifpb.tt.ecommerce.entity.Product;
import gl.edu.ifpb.tt.ecommerce.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO dao;

	@Override
	public void save(Product t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> list() {
		
		return StreamSupport.stream(dao.findAll().spliterator(), false)
			    .collect(Collectors.toList());
	}

	@Override
	public Product getById(Long id) {
		
		Optional<Product> product = dao.findById(id);
		return (product.isPresent() ?  product.get(): null);
	}
	
	@Override
	public Product getByName(String name) {
	
		return dao.findByName(name);
	}



	
}
