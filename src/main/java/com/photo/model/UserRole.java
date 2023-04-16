package com.photo.model;

public class UserRole {

    private long userRoleId;
    private AppUser appUser;
    private Role role;

    public UserRole(){}

    public UserRole(long userRoleId, AppUser appUser, Role role) {
        this.userRoleId = userRoleId;
        this.appUser = appUser;
        this.role = role;
    }

    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
