package com.photo.service;

import com.photo.model.Comment;
import com.photo.model.Post;

public interface CommentService {

    public void saveComment(Post post, String username, String content);
}
