package com.photo.service;

import com.photo.model.AppUser;
import com.photo.model.Role;

import java.util.List;

public interface AccountService {

    public void saveUser(AppUser appUser);

    public AppUser findByUsername(String username);

    public AppUser findByEmail(String email);

    public List<AppUser> userList();

    public Role findUserRoleByName(String role);

    public Role saveRole(Role role);

    public void updateUser(AppUser appUser);

    public AppUser findById(Long id);

    public void deleteUser(AppUser appUser);

    public void resetPassword(AppUser appUser);

    public List<AppUser> getUserListByUsername(String username);

    public AppUser simpleSave(AppUser appUser);
}
