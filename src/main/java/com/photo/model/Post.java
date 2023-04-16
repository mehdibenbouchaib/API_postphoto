package com.photo.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.List;


@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Integer id;
    private String name;

    @Column(columnDefinition = "text")
    private String caption;
    private  String location;
    private  int likes;
    private Data postedDate;
    private Integer userImageId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private List<Comment>commentList;
    public Post(){}

    public Post(Integer id,
                String name,
                String caption,
                String location,
                int likes,
                Data postedDate,
                Integer userImageId,
                List<Comment> commentList) {
        this.id = id;
        this.name = name;
        this.caption = caption;
        this.location = location;
        this.likes = likes;
        this.postedDate = postedDate;
        this.userImageId = userImageId;
        this.commentList = commentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Data getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Data postedDate) {
        this.postedDate = postedDate;
    }

    public Integer getUserImageId() {
        return userImageId;
    }

    public void setUserImageId(Integer userImageId) {
        this.userImageId = userImageId;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
