package gl.edu.ifpb.tt.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gl.edu.ifpb.tt.ecommerce.entity.Order;

@Repository
public interface OrderDAO extends CrudRepository<Order, Long>{

}
