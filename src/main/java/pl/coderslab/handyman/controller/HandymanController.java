package pl.coderslab.handyman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.handyman.entity.Handyman;
import pl.coderslab.handyman.entity.OrderUser;
import pl.coderslab.handyman.entity.Skill;
import pl.coderslab.handyman.entity.User;
import pl.coderslab.handyman.repository.HandymanRepository;
import pl.coderslab.handyman.repository.OrderUserRepository;
import pl.coderslab.handyman.repository.RoleRepository;
import pl.coderslab.handyman.repository.SkillRepository;
import pl.coderslab.handyman.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/handyman")
public class HandymanController {

    @Autowired
    UserService userService;

    private HandymanRepository handymanRepository;
    private SkillRepository skillRepository;
    private OrderUserRepository orderUserRepository;

    @Autowired
    public HandymanController(HandymanRepository handymanRepository, SkillRepository skillRepository,
                              OrderUserRepository orderUserRepository) {
        this.handymanRepository = handymanRepository;
        this.skillRepository = skillRepository;
        this.orderUserRepository = orderUserRepository;
    }

    @ModelAttribute("handymans")
    public List<Handyman> getHandymans() {
        return this.handymanRepository.findAll();
    }

    @ModelAttribute("skills")
    public List<Skill> getSkills() {
        return this.skillRepository.findAll();
    }

    @ModelAttribute("orders")
    public List<OrderUser> getOrders() {
        return this.orderUserRepository.findAll();
    }

    @GetMapping("/add")
    public String addHandyman(Model model) {
        model.addAttribute("handyman", new Handyman());
        return "forms/handyman/handyman";
    }

    @PostMapping("/add")
    public String postAddHandyman(@Valid @ModelAttribute Handyman handyman, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "forms/handyman/handyman";
        }
        handyman.setActive(1);
        this.handymanRepository.save(handyman);
        return "redirect:/handyman/handymans";
    }

    @GetMapping("/handymans")
    public String getAllHandymans() {
        return "forms/handyman/handymans";
    }

    @GetMapping("/{id}/details")
    public String getHandymanDetails(@ModelAttribute Handyman handyman, Model model) {
        Long handymanId = handyman.getId();
        model.addAttribute("handyman", this.handymanRepository.getOne(handymanId));
        return "forms/handyman/details";
    }

    @GetMapping("/order/{id}/details")
    public String getOrderDetails(@ModelAttribute OrderUser orderUser, Model model) {
        Long orderUserId = orderUser.getId();
        model.addAttribute("order", this.orderUserRepository.findById(orderUserId));
        return "forms/handyman/orderDetails";
    }

    @GetMapping("/edit/{id}")
    public String editHandymanForm(@PathVariable Long id, Model model) {
        model.addAttribute("handyman", this.handymanRepository.getOne(id));
        return "forms/handyman/handyman";
    }

    @PostMapping("/edit/**")
    public String postEditHandymanForm(@Valid @ModelAttribute Handyman handyman, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "forms/handyman/handyman";
        }
        handyman.setActive(1);
        this.handymanRepository.save(handyman);
        return "redirect:/handyman/handymans";
    }

}
