package com.photo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Integer id;
    private String username;

    @Column(columnDefinition = "text")
    private String content;
    private Data postedDate;
    public Comment(){}

    public Comment(Integer id, String username, String content, Data postedDate) {
        this.id = id;
        this.username = username;
        this.content = content;
        this.postedDate = postedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Data getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Data postedDate) {
        this.postedDate = postedDate;
    }
}
