package gl.edu.ifpb.tt.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gl.edu.ifpb.tt.ecommerce.entity.Order;
import gl.edu.ifpb.tt.ecommerce.repository.OrderDAO;

@Service
public class OrderService implements ECommerceService<Order>{

	@Autowired
	private OrderDAO orderDAO;
	
	
	@Override
	public void save(Order order) {
		orderDAO.save(order);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
