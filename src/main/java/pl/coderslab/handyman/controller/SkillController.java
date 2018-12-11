package pl.coderslab.handyman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.handyman.entity.Skill;
import pl.coderslab.handyman.repository.SkillRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    SkillRepository skillRepository;

    @ModelAttribute("skills")
    public List<Skill> getSkills() {
        return this.skillRepository.findAll();
    }

    @GetMapping("/add")
    public String getAddSkillForm(Model model) {
        model.addAttribute("skill", new Skill());
        return "forms/admin/skill";
    }

    @PostMapping("/add")
    public String postAddSkillForm(@Valid @ModelAttribute Skill skill, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "forms/admin/skill";
        }
        this.skillRepository.save(skill);
        return "redirect:/skill/skills";
    }

    @GetMapping("/skills")
    public String getAllSkills() {
        return "forms/admin/skills";
    }

}
