package isi.tn.ecommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.tn.ecommerce.entities.User;
import isi.tn.ecommerce.response.MessageResponse;
import isi.tn.ecommerce.services.UserService;

@RestController
@CrossOrigin(origins = "*") // api sera consommée par Angular
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService userv;

	@PostMapping("/addusert")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User createUser(@Validated @RequestBody User user) {
		return userv.saveUser(user);
	}

	@GetMapping("/user/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Optional<User> getUserById(@PathVariable(value = "id") Long Id) {
		return userv.findById(Id);
		// .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}

	@GetMapping("/users")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> getAllUsers() {
		List<User> pro = userv.findAllUsers();
		return pro;

	}

	@DeleteMapping("/user/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public MessageResponse deleteUser(@PathVariable(value = "id") Long userId) {
		// .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		// userRepository.deleteById(userId);
		return userv.delete(userId);

	}

	@PutMapping("/user/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User updateUser(@PathVariable(value = "id") Long Id, @Validated @RequestBody User userDetails) {

		User user = userv.findById(Id).orElseThrow(null);

		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		user.setUsername(userDetails.getUsername());

		User updatedUser = userv.saveUser(user);
		return updatedUser;
	}

	@GetMapping("/allusers")
	public String displayUsers() {
		return "Display All Users";
	}

	@GetMapping("/displayuser")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public String displayToUser() {
		return "Display to both user and admin";
	}

	@GetMapping("/displayadmin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String displayToAdmin() {
		return "Display only to admin";
	}
}
