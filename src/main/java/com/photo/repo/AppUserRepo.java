package com.photo.repo;

import com.photo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    public AppUser findByUsername(String username);

    public AppUser findByEmail(String email);

    public AppUser findUserById(Long id);

    public List<AppUser> findByUsernameContaining(String username);

}
