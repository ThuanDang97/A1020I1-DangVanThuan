package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Promotion;
import vn.codegym.service.PromotionService;

@Controller
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    PromotionService promotionService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 9) Pageable pageable, Model model) {
        Page<Promotion> promotion;
        promotion = promotionService.findAll(pageable);
        model.addAttribute("promotions", promotion);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("promotion", new Promotion());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute Promotion promotion, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new Promotion().validate(promotion, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            promotionService.save(promotion);
            redirectAttributes.addFlashAttribute("message", "Added promotion " + promotion.getTitle() + " successfully!");
            model.addAttribute("promotion", promotion);
            return "redirect:/promotion";
        }
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("promotion", promotionService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute Promotion promotion, BindingResult bindingResult, RedirectAttributes redirect) {
        new Promotion().validate(promotion, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            promotionService.save(promotion);
            redirect.addFlashAttribute("message", "Updated promotion " + promotion.getTitle() + " successfully!");
            return "redirect:/promotion";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Promotion promotion, RedirectAttributes redirect) {
        promotionService.findById(id);
        promotionService.delete(promotion);
        redirect.addFlashAttribute("message", "Removed promotion successfully!");
        return "redirect:/promotion";
    }

    @GetMapping("/search")
    public String deleteCustomer(@RequestParam String key, @PageableDefault(value = 4) Pageable pageable, Model model) {
        Page<Promotion> promotions = promotionService.findAllByKey(key, pageable);
        if (promotions.isEmpty()) {
            model.addAttribute("promotions", promotionService.findAll(pageable));
        } else {
            model.addAttribute("key", promotionService.findAllByKey(key, pageable));
            model.addAttribute("promotions", promotions);
        }
        return "list";
    }

}
