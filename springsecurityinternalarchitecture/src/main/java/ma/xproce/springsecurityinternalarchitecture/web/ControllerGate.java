package ma.xproce.springsecurityinternalarchitecture.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerGate {

    @GetMapping("/public")
    public String publicPage(Model model) {
        return "public";
    }

    @GetMapping("/")
    public String root(Model model) {
        return "redirect:/public";
    }


    @GetMapping("/private")
    public String privatePage(Authentication authentication, Model model) {
        model.addAttribute("name", getName(authentication));
        return "private";
    }

    @GetMapping("/toomanyrequests")
    public String toomanyrequests(Model model) {
        model.addAttribute("remainingTime", 60);
        return "toomanyrequests";
    }

    private static String getName(Authentication authentication) {
        return authentication.getName();
    }

}
