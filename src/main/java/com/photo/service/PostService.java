package com.photo.service;

import com.photo.model.AppUser;
import com.photo.model.Post;
import org.springframework.security.core.parameters.P;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

public interface PostService {

    public Post savePost(AppUser appUser, HashMap<String, String> request, String postImageName);

    public List<Post> postList();

    public Post getPostById(Long id);

    public List<Post> findPostByUsername(String username);

    public Post deletPost(Post post);

    public String savePostImage(MultipartFile multipartFile, String fileName);

}
