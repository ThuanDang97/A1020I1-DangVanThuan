package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.customer.Customer;
import vn.codegym.service.CustomerService;

import javax.validation.Valid;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/customer_list")
    public ModelAndView showList(@PageableDefault(value = 5) Pageable pageable) {
        return new ModelAndView("customer/list", "customerList", customerService.findAll(pageable));
    }

    @GetMapping(value = "/customer_create")
    public String showCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping(value = "/customer_create")
    public String createCustomer (@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            return "customer/create";
        } else {
            redirectAttributes.addFlashAttribute("successMsg", "Create New Customer " + customer.getName() + " Successfully !!!");
            customerService.save(customer);
            return "redirect:/customer/list";
        }
    }
}
