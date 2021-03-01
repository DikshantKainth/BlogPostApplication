package com.app.BlopApplication.Controller;


import com.app.BlopApplication.model.Post;
import com.app.BlopApplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    //IOC-> Inversion of control | Dependency injection

    @Autowired
    private PostService postService;

    @RequestMapping("/posts")
    public String getUserPost(Model model) {
        //PostService postService=new PostService();
        List<Post> posts=postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "posts";
    }

    @RequestMapping(method= RequestMethod.GET,value="/posts/newpost")
    public String newPost(){
        return "posts/create";
    }

    @RequestMapping(method = RequestMethod.POST, value="/posts/create")
    public String createNewPost(Post newPost){

        //PostService postService=new PostService();
        newPost.setDate(new Date());
        postService.createPost(newPost);
        return "redirect:/posts";
    }
}
