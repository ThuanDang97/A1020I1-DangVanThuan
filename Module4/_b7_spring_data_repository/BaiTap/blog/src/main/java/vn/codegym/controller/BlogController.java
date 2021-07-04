package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Blog;
import vn.codegym.service.BlogService;

import java.sql.Date;

@Controller
@RequestMapping(value = "/blog", name = "blogController")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping(value = "/list")
    public ModelAndView showListBlog(@PageableDefault(value = 5) Pageable pageable) {
        return new ModelAndView("list", "blogList", blogService.findAll(pageable));
    }

    @GetMapping(value = "/create")
    public String showCreatePage(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successMsg", "create blog " + blog.getName() + " ok");
        blog.setDate(new Date(System.currentTimeMillis()));
        blogService.save(blog);
        return "redirect:/blog/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditPage(@PathVariable("id") int blogId, ModelMap modelMap) {
        modelMap.addAttribute("blog", blogService.findById(blogId));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDate(new Date(System.currentTimeMillis()));
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("successMsg", "Update blog " + blog.getName() + " ok");
        return "redirect:/blog/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteBlog(@PathVariable("id") int blogId, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(blogId);
        if (blog != null) {
            redirectAttributes.addFlashAttribute("successMsg", "Delete blog " + blog.getName() + " ok");
            blogService.delete(blog);
        } else {
            redirectAttributes.addFlashAttribute("successMsg", "Delete not found!!!");
        }

        return "redirect:/blog/list";
    }
}
