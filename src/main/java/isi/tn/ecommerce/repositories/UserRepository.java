package isi.tn.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import isi.tn.ecommerce.entities.User;
@Repository 
public interface UserRepository extends JpaRepository<User,Long>{
}
