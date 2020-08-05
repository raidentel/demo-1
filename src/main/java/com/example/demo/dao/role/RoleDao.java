package com.example.demo.dao.role;

import com.example.demo.model.authority.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Roles, Long> {
}
