package pl.coderslab.handyman.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.handyman.entity.User;
import pl.coderslab.handyman.repository.UserRepository;

import javax.validation.Valid;

@Controller
@SessionAttributes("logged")
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {

        this.userRepository = userRepository;

    }

    @GetMapping("/logon")
    public String userLogon(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepository.findByEmail(auth.getName());
        model.addAttribute("logged", user);
        return "forms/user/logon";
    }

    @GetMapping("/profile")
    public String userProfile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepository.findByEmail(auth.getName());
        model.addAttribute("logged", user);
        return "forms/user/profile";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable int id, Model model) {
        model.addAttribute("logged", this.userRepository.findById(id));
        return "forms/user/user";
    }

    @PostMapping("/edit/**")
    public String postEditUserForm(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "forms/user/user";
        }
        this.userRepository.save(user);
        return "redirect:/user/profile";
    }

}