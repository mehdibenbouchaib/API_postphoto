package com.photo.repo;

import com.photo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    public Role findRoleByName(String name);
}
