package com.photo.service.impl;

import com.photo.model.Comment;
import com.photo.model.Post;
import com.photo.repo.CommentRepo;
import com.photo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;


    @Override
    public void saveComment(Post post, String username, String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUsername(content);
        comment.setPostedDate(new Date());
        post.setComments(comment);
        commentRepo.save(comment);

    }
}
