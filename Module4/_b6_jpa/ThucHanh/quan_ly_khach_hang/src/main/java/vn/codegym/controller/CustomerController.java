package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Customer;
import vn.codegym.service.CustomerService;

@Controller
@RequestMapping(value = "/customer", name = "customerController")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/list")
    public ModelAndView showCustomerList() {
        return new ModelAndView("list", "customerList", customerService.findAll());
    }

    @GetMapping(value = "/create")
    public String showCreateCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successMsg", "create new customer: "
                + customer.getName() + " OK");
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditCustomer(@PathVariable("id") int id, ModelMap modelMap){
        modelMap.addAttribute("customer", customerService.findbyID(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String updateCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successMsg", "update new customer: "
                + customer.getName() + " OK");
        customerService.update(customer);
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findbyID(id);

        if (customer!= null){
            redirectAttributes.addFlashAttribute("successMsg", "Delete customer: "
                    + customer.getName() + " OK");
            customerService.remove(customer);
        } else {
            redirectAttributes.addFlashAttribute("successMsg", "Customer not found!!!");
        }
        return "redirect:/customer/list";
    }
}
