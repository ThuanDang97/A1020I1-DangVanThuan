package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.customer.Customer;
import vn.codegym.service.CustomerService;

@Controller
@RequestMapping(value = "/customer", name = "customerController")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/list")
    public ModelAndView showList(@PageableDefault(value = 5) Pageable pageable) {
        return new ModelAndView("customer/list", "customerList", customerService.findAll(pageable));
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

}
