package ECOM.ChocoCrunchy.dao;



import java.util.List;

import ECOM.ChocoCrunchy.dto.Address;
import ECOM.ChocoCrunchy.dto.Cart;
import ECOM.ChocoCrunchy.dto.User;

public interface UserDAO {
	
	//add an user
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	
	// add an address
	boolean addAddress(Address address);
	
	// alternative
	 //Address getBillingAddress(int userId);
	//List<Address> listShippingAddresses(int userId);
	
	
	
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
	
	
	// update a cart
	boolean updateCart(Cart cart);
	
}
