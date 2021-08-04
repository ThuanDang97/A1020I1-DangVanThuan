package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.account.Admin;

@Controller
@SessionAttributes("case")

@RequestMapping(value = "")
public class LoginController {

    @ModelAttribute("case")
    public Admin setupSession() {
        return new Admin();
    }

    @GetMapping(value = "/login")
    public String showLogin () {
        return "login";
    }

    @PostMapping(value = "/login")
    public String processLogin(@RequestParam String username, String password,
                               @SessionAttribute("case") Admin admin) {
        if ("admin".equals(username) && "admin".equals(password)){
            admin.setUserName(username);
            admin.setPassWord(password);
            return "redirect:/view";
        } else {
            return "login";
        }
    }

    @GetMapping(value = "/view")
    public String showViewPage(@SessionAttribute(name = "case", required = false) Admin admin ) {
        if(admin == null) {
            return "login";
        }

        if (admin.getUserName().equals("admin")) {
            return "view";
        }

        return "redirect:/login";
    }

}
