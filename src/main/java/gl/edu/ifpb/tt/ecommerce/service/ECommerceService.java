package gl.edu.ifpb.tt.ecommerce.service;

import java.util.List;

public interface ECommerceService<T> {

	void save(T t);
	void delete(Long id);
	List<T> list();
	T getById(Long id);
}
