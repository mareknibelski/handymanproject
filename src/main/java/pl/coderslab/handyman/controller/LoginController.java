package pl.coderslab.handyman.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.handyman.entity.User;
import pl.coderslab.handyman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String userLogout() {
        return "/logout";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "forms/register";

    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(@Valid User user, BindingResult result, Model model) throws Exception {
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            result.rejectValue("email", "error.user",
                    "Użytkownik o podanym adresie e-mail już istnieje.");
        }
        if(result.hasErrors()) {
            return "forms/register";
        } else {
            userService.saveUser(user);
                        model.addAttribute("successMessage", "Użytkownik zarejestrowny.");

            return "forms/registersucces";
        }
    }
}
