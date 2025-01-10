package org.example.skincareeshop.repository;

import org.example.skincareeshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
