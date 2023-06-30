package fr.v0.minorease.Controller.mvc;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user", authentication != null && authentication.isAuthenticated());
        return "login";
    }

}
