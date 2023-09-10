package com.springmvc.controllers;

import com.springmvc.models.User;
import com.springmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    // Show user creation form
    @GetMapping("/users/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user_new";
    }

    // Process user creation
    @PostMapping("/users/new")
    public String createUser(@ModelAttribute User user) {
        if (user != null) {
            userService.add(user);
        }
        return "redirect:/users";
    }

    // Edit user form
    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Integer id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "user_edit";
    }

    @PostMapping("/users/edit/{id}")
    public String updateUser(@PathVariable Integer id, @ModelAttribute User user) {
        if (user != null) {
            userService.updateUser(id, user);
        }
        return "redirect:/users";
    }

    @GetMapping("/users/get/{id}")
    @ResponseBody
    public String getUser(@PathVariable Integer id) {
        User user = userService.getUser(id);
        if (user == null) {
            user = new User();
        }
        return user.toString();
    }

    @GetMapping("/users/delete/{id}")
    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
