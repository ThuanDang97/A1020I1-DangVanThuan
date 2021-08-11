package vn.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.codegym.models.Admin;

import java.security.Principal;

@Controller
@SessionAttributes("user")
public class LoginController {


    @ModelAttribute("user")
    public Admin setupSession() {
        return new Admin();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String processLogin(@RequestParam String username, String password,
                               @SessionAttribute("user") Admin admin) {
        if ("admin".equals(username) && "123".equals(password)){
            admin.setUserName(username);
            admin.setPassWord(password);
            return "view";
        } else {
            return "login";
        }
    }

    @GetMapping(value = "/view")
    public String showViewPage(@SessionAttribute(name = "user", required = false) Admin admin ) {
        if(admin == null) {
            return "login";
        }

        if (admin.getUserName().equals("admin")) {
            return "view";
        }

        return "redirect:/login";
    }

    @GetMapping("403")
    public String accessDenied(Principal principal) {
        return "error403";
    }

    @GetMapping("logout")
    public String logout() {
        return "redirect:/home";
    }

}
