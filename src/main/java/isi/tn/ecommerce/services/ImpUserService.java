package isi.tn.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import isi.tn.ecommerce.entities.User;
import isi.tn.ecommerce.repositories.UserRepository;
import isi.tn.ecommerce.response.MessageResponse;

@Service
public class ImpUserService implements UserService{
	@Autowired
	UserRepository urepos;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return urepos.save(user);
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return urepos.findById(id);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) urepos.findAll();
	}

	@Override
	public MessageResponse delete(Long  id) {
		try {
			urepos.deleteById(id);
			return new MessageResponse("Action réalisée avec succés ✔");
		} catch (Exception e) {
			// TODO: handle exception
			return new MessageResponse("Echec 💥🛑❌");
		}
	}
}
