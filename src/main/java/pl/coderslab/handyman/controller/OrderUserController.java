package pl.coderslab.handyman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.handyman.entity.OrderUser;
import pl.coderslab.handyman.entity.User;
import pl.coderslab.handyman.repository.OrderUserRepository;
import pl.coderslab.handyman.repository.UserRepository;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class OrderUserController {

    private OrderUserRepository orderUserRepository;
    private UserRepository userRepository;

    @Autowired
    public OrderUserController(OrderUserRepository orderUserRepository, UserRepository userRepository) {
        this.orderUserRepository = orderUserRepository;
        this.userRepository = userRepository;
    }

    @ModelAttribute("orders")
    public List<OrderUser> getAllOrderUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepository.findByEmail(auth.getName());
        return this.orderUserRepository.findByUser(user);
    }

    @GetMapping("/user/order/add")
    public String addOrderUserForm(Model model) {
        model.addAttribute("order", new OrderUser());
        return "forms/orderUser/order";
    }

    @PostMapping("/user/order/add")
    public String postAddOrderUserForm(@Valid @ModelAttribute OrderUser orderUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "forms/orderUser/order";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepository.findByEmail(auth.getName());
        orderUser.setUser(user);
        LocalDateTime ldt = LocalDateTime.now();
        orderUser.setTime(ldt);
        this.orderUserRepository.save(orderUser);
        return "redirect:/user/logon";
    }

    @GetMapping("/user/orders")
    public void getAllUserOrders(@ModelAttribute OrderUser orderUser, Model model) {
        List<OrderUser> orderUsers = this.orderUserRepository.findByUser(orderUser.getUser());
        model.addAttribute("orders", orderUsers);
    }

    @GetMapping("/handyman/orders")
    public String getAllOrderUser(Model model) {
        List<OrderUser> orderUsers = this.orderUserRepository.findAll();
        model.addAttribute("orders", orderUsers);
        return "forms/orderUser/orders";
    }

    @GetMapping("/user/order/{id}/details")
    public String getOrderDetails(@ModelAttribute OrderUser orderUser, Model model) {
        Long orderUserId = orderUser.getId();
        model.addAttribute("order", this.orderUserRepository.findById(orderUserId));
        return "forms/orderUser/details";
    }

    @GetMapping("/user/order/edit/{id}")
    public String getEditOrderForm(@PathVariable Long id, Model model) {
        model.addAttribute("order", this.orderUserRepository.findById(id));
        return "forms/orderUser/order";
    }

    @PostMapping("/user/order/edit/**")
    public String postEditOrderForm(@Valid @ModelAttribute OrderUser orderUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "forms/orderUser/order";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepository.findByEmail(auth.getName());
        orderUser.setUser(user);
        LocalDateTime newldt = LocalDateTime.now();
        orderUser.setTime(newldt);
        this.orderUserRepository.save(orderUser);
        return "redirect:/user/logon";
    }

}
