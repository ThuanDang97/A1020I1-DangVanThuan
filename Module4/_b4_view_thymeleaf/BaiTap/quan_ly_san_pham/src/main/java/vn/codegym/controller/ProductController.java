package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;

@Controller
@RequestMapping(value = {"product", ""}, name = "productController")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showProductList() {
        return new ModelAndView("list", "products", productService.findAll());
    }

    @GetMapping(value = "/create")
    public String showCreateProduct(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/create")
    public String CreateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successMsg", "create product: "
                + product.getNameProduct() + " OK");
        productService.save(product);
        return "redirect:/list";
    }

    @GetMapping(value = "/edit/{id:[0-100]}", name = "showEditPage")
    public String showEditPage(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @DeleteMapping (value = "/delete")
    public String DeleteProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successMsg", "Delete product: "
                + product.getNameProduct() + " OK");
        productService.delete(product.getId());
        return "redirect:/list";
    }
}
