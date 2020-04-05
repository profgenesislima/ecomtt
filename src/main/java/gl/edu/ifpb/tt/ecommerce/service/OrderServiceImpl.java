package gl.edu.ifpb.tt.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gl.edu.ifpb.tt.ecommerce.entity.Order;
import gl.edu.ifpb.tt.ecommerce.repository.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDAO orderDAO;

	@Override
	public void save(Order order) {
		orderDAO.save(order);
		
	}
	
	
	

	
}
