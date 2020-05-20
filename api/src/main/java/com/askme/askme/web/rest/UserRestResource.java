package com.askme.askme.web.rest;


import java.security.Principal;

import com.askme.askme.models.Projections.UserProjection;
import com.askme.askme.models.Question;
import com.askme.askme.models.User;
import com.askme.askme.models.UserRole;
import com.askme.askme.service.UserRoleService;
import com.askme.askme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/rest")
public class UserRestResource {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void init(){
        User u = new User();
        UserRole ur = new UserRole();
        ur.setName("ROLE_ADMIN");
        userRoleService.save(ur);
        ur = new UserRole();
        ur.setName("ROLE_MEMBER");
        userRoleService.save(ur);


        ur = userRoleService.findById(2L);
        u.setUserRole(ur);
        u.setUsername("sveto");
        u.setProfileImgUrl("https://gix.uw.edu/wp-content/uploads/2019/01/photo-placeholder.jpeg");
        u.setFirstName("Svetislav");
        u.setLastName("Georgievski");
        u.setProfileDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        u.setPassword(passwordEncoder.encode("anonymous"));
        userService.save(u);
    }

//    @PreAuthorize("isAuthenticated()")
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id){
       return userService.findById(id);
    }

    @GetMapping("/user/{id}/questions")
    public List<Question> getUserQuestions(@PathVariable("id") Long id){
        User u = userService.findById(id);
        return u.getQuestions();
    }

    @GetMapping("/username")
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }

    @PostMapping("/register")
    public User createNewUser(@RequestBody User user ){
        UserRole ur = new UserRole();
        ur.setId(2l);
        user.setUserRole(ur);
        return userService.save(user);
    }
}
