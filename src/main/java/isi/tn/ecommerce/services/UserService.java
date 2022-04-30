package isi.tn.ecommerce.services;

import java.util.List;
import java.util.Optional;

import isi.tn.ecommerce.entities.User;
import isi.tn.ecommerce.response.MessageResponse;

public interface UserService {
	User saveUser(User user);

	Optional<User> findById(Long id);


	List<User> findAllUsers();

	MessageResponse delete(Long id);

}
