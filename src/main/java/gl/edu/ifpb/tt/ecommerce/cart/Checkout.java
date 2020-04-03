package gl.edu.ifpb.tt.ecommerce.cart;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public final class Checkout {

	private final Payment payment;
	private final ShoppingCart shoppintCart;
	
	//private Client client;
}
