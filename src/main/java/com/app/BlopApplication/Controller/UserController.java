package com.app.BlopApplication.Controller;


import com.app.BlopApplication.model.Post;
import com.app.BlopApplication.model.User;
import com.app.BlopApplication.service.PostService;
import com.app.BlopApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.AuthProvider;
import java.util.List;

@Controller
public class UserController {

    private UserService userService=new UserService();
    private PostService postService=new PostService();

    //GET request to "/users/login"
    @RequestMapping(method= RequestMethod.GET,value="/users/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "users/login";
    }

    //POST request to "/users/login"
    @RequestMapping(method= RequestMethod.POST,value="/users/login")
    public String loginUser(User user){
        //Check if the credential match
        if(userService.login(user)){
            return "redirect:/posts";
        }
        else{
            return "users/login";
        }
    }

    @RequestMapping(method=RequestMethod.GET,value="/users/registration")
    public String registration(){
        return "users/registration";
    }

    @RequestMapping(method=RequestMethod.POST,value="/users/registration")
    public String userRegistration(User user){
        //Business logic to save the cred of user to the given data base.
        return "redirect:/users/login";
    }

    @RequestMapping("/users/logout")
    public String userLogout(Model model){
        List<Post> posts=postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "redirect:/";
    }
}
