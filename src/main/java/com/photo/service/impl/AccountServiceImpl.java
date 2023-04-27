package com.photo.service.impl;

import com.photo.model.AppUser;
import com.photo.model.Role;
import com.photo.repo.AppUserRepo;
import com.photo.repo.RoleRepo;
import com.photo.service.AccountService;
import com.photo.utility.EmailConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Random;

public class AccountServiceImpl implements AccountService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private EmailConstructor emailConstructor;

    @Autowired
    private JavaMailSender mailSender;


    @Override
    public void saveUser(AppUser appUser) {
        String password = RandomStringUtils.randomAlphanumeric(10);
        String encrytedPassword = bCryptPasswordEncoder.encode(password);
        appUser.setPassword(encrytedPassword);
        appUserRepo.save(appUser);
        mailSender.send(emailConstructor.contructNewUserEmail(appUser, password));
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepo.findByUsername(username);
    }

    @Override
    public AppUser findByEmail(String email) {
        return appUserRepo.findByEmail(email);
    }

    @Override
    public List<AppUser> userList() {
        return appUserRepo.findAll();
    }

    @Override
    public Role findUserRoleByName(String name) {
        return roleRepo.findRoleByName(name);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void updateUser(AppUser appUser) {
        String password = appUser.getPassword();
        String encryptedPassword = bCryptPasswordEncoder.encode(password);
        appUser.setPassword(encryptedPassword);
        appUserRepo.save(appUser);
        mailSender.send(emailConstructor.constructUpdateUserProfileEmail(appUser));

    }

    @Override
    public AppUser findById(Long id) {
        return appUserRepo.findUserById(id);
    }

    @Override
    public void deleteUser(AppUser appUser) {
        appUserRepo.delete(appUser);
    }

    @Override
    public void resetPassword(AppUser appUser) {
        String password = RandomStringUtils.randomAlphanumeric(10);
        String encryptedPassword = bCryptPasswordEncoder.encode(password);
        appUser.setPassword(encryptedPassword);
        appUserRepo.save(appUser);
        mailSender.send(emailConstructor.constructResetPasswordEmail(appUser, password));


    }

    @Override
    public List<AppUser> getUserListByUsername(String username) {
        return appUserRepo.findByUsernameContaining(username);
    }

    @Override
    public AppUser simpleSave(AppUser appUser) {
        appUserRepo.save(appUser);
        mailSender.send(emailConstructor.constructUpdateUserProfileEmail(appUser));
        return appUser;
    }
}
