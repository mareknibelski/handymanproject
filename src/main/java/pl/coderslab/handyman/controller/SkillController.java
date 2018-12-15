package pl.coderslab.handyman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.handyman.entity.Skill;
import pl.coderslab.handyman.entity.User;
import pl.coderslab.handyman.repository.SkillRepository;
import pl.coderslab.handyman.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
public class SkillController {

    private SkillRepository skillRepository;
    private UserRepository userRepository;

    @Autowired
    public SkillController(SkillRepository skillRepository, UserRepository userRepository) {
        this.skillRepository = skillRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/admin/skill/add")
    public String getAddSkillForm(Model model) {
        model.addAttribute("skill", new Skill());
        return "forms/skill/skill";
    }

    @PostMapping("/admin/skill/add")
    public String postAddSkillForm(@Valid @ModelAttribute Skill skill, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "forms/skill/skill";
        }
        this.skillRepository.save(skill);
        return "redirect:/admin/";
    }

    @GetMapping("/admin/skills")
    public void getAllSkills(Model model) {
        List<Skill> skills = this.skillRepository.findAll();
        model.addAttribute("skills", skills);
    }

    @GetMapping("/admin/skill/edit/{id}")
    public String editSkillForm(@PathVariable Long id, Model model) {
        model.addAttribute("skill", this.skillRepository.getOne(id));
        return "forms/skill/skill";
    }

    @PostMapping("/admin/skill/edit/**")
    public String postEditSkillForm(@Valid @ModelAttribute Skill skill, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "forms/skill/skill";
        }
        this.skillRepository.save(skill);
        return "redirect:/admin/";
    }

    @GetMapping("/admin/skill/delete/{id}")
    public String deleteSkill(@PathVariable Long id) {
        this.skillRepository.deleteById(id);
        return "redirect:/admin/";
    }

}
