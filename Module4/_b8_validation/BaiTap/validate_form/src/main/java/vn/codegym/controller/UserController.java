package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.User;
import vn.codegym.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user", name = "userController")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/list")
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable) {
        return new ModelAndView("list", "userList", userService.findAll(pageable));
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createUser(@Valid @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/create";
        } else {
            redirectAttributes.addFlashAttribute("successMsg", "create user " + user.getFirstName() + " " + user.getLastName() + " ok");
            userService.save(user);
            return "redirect:/user/list";
        }
    }
}
