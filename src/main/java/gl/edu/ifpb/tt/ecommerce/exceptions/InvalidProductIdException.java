package gl.edu.ifpb.tt.ecommerce.exceptions;

public class InvalidProductIdException extends Exception {

	

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		
		return "Um produto deve ter um Id maior que zero";
	}
}
