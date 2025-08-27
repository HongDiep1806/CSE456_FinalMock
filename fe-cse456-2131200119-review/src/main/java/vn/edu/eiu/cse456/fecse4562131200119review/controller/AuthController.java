package vn.edu.eiu.cse456.fecse4562131200119review.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.eiu.cse456.fecse4562131200119review.model.User;
import vn.edu.eiu.cse456.fecse4562131200119review.service.UserService;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLogin(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/auth")
    public String authLogin(@ModelAttribute User user, HttpSession session, RedirectAttributes redirectAttributes) {
        User foundUser = userService.findByUserName(user.getUserName());
        if (foundUser == null) {
            redirectAttributes.addFlashAttribute("errLogin", "Username or passsword is wrong");
            return "redirect:/login";
        }
        if (!foundUser.getPassword().equals(user.getPassword())) {
            redirectAttributes.addFlashAttribute("errLogin", "Wrong password");
            return "redirect:/login";
        }
        session.setAttribute("user", foundUser);
        return "redirect:/equipments";
    }
}
