package com.tts.d22_GroovyStore_1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.d22_GroovyStore_1.model.User;
import com.tts.d22_GroovyStore_1.service.UserService;

@Controller
public class AuthorizationController {

  @Autowired
  private UserService userService;
  
  @GetMapping(value = "/login")
  public String login() {
    return "login";
  }
  
  @GetMapping(value="/signup")
  public String registration(Model model){
      User user = new User();
      model.addAttribute("user", user);
      return "signup";
  }

  @PostMapping(value = "/signup")
  public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
      User userExists = userService.findByEmail(user.getEmail());
      if (userExists != null) {
          bindingResult.rejectValue("email", "error.user", "That email already has an account");
      }
      if (!bindingResult.hasErrors()) {
          userService.saveNewUser(user);
          model.addAttribute("success", "Sign up successful!");
          model.addAttribute("user", new User());
      }
      return "signup";
  }
  
  @GetMapping(value = "/editProfile")
  public String editProfile() {
	  return "editProfile";
  }
  
  @PostMapping(value = "/editProfile")
  public String editUser(@Valid User user, BindingResult bindingResult, Model model) {
	  
	  return "signup";
  }
}