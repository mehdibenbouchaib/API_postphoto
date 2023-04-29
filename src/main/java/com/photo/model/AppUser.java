package com.photo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
public class AppUser implements Serializable {

    private static final long serialVersionUID = 164669782975869L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name;

    @Column(unique = true, nullable = false)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String email;

    @Column(columnDefinition = "text")
    private String bio;

    @CreationTimestamp
    private Date createdDate;


    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "appUser_id")
    private List<Post> post;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "likedPostappUser_id")
    private List<Post> likedPost;

    public AppUser() {
    }

    public AppUser(Long id,
                   String name,
                   String username,
                   String password,
                   String email,
                   String bio,
                   Date createdDate,
                   Set<UserRole> userRoles,
                   List<Post> post,
                   List<Post> likedPost) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.bio = bio;
        this.createdDate = createdDate;
        this.userRoles = userRoles;
        this.post = post;
        this.likedPost = likedPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post.add(post);
    }

    public List<Post> getLikedPost() {
        return likedPost;
    }

    public void setLikedPost(List<Post> likedPost) {
        this.likedPost = likedPost;
    }
}
