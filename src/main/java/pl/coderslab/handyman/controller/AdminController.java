package pl.coderslab.handyman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.handyman.entity.Role;
import pl.coderslab.handyman.entity.Skill;
import pl.coderslab.handyman.entity.User;
import pl.coderslab.handyman.repository.RoleRepository;
import pl.coderslab.handyman.repository.SkillRepository;
import pl.coderslab.handyman.repository.UserRepository;
import pl.coderslab.handyman.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
@SessionAttributes("loggedAdmin")
public class AdminController {

    @Autowired
    private UserService userService;

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private SkillRepository skillRepository;

    @Autowired
    public AdminController(UserRepository userRepository, RoleRepository roleRepository, SkillRepository skillRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.skillRepository = skillRepository;
    }

    @ModelAttribute("skills")
    public List<Skill> getSkills() {
        return this.skillRepository.findAll();
    }

    @GetMapping("")
    public String loginAdmin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Role role = this.roleRepository.findByRole("USER");
        User user = this.userRepository.findByEmail(auth.getName());
        if (user.getRoles().equals(role)) {
            return "forms/user/logon";
        }
        return "forms/admin/logon";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerAdmin(Model model) {
        model.addAttribute("user", new User());
        return "forms/admin/register";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewAdmin(@Valid User admin, BindingResult result, Model model) throws Exception {
        User userExists = userService.findUserByEmail(admin.getEmail());
        if (userExists != null) {
            result.rejectValue("email", "error.user",
                    "Użytkownik o podanym adresie e-mail już istnieje.");
        }
        if(result.hasErrors()) {
            return "forms/admin/register";
        } else {
            userService.saveAdmin(admin);
            model.addAttribute("successMessage", "Użytkownik zarejestrowny.");

            return "forms/admin/registersucces";
        }
    }

}
