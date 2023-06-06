package com.projet1.projet1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet1.projet1.model.Role;

public interface RoleRiposotory extends JpaRepository<Role, Long> {
	 Role findByRole(String role);

}
