package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.IdentifierProcessing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("book", bookRepository.findAll());
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/admin/addCategory")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @PostMapping("/admin/processAddCategory")
    public String processAddCategory(@ModelAttribute Category category){
        categoryRepository.save(category);
        return "redirect:/";
    }

    @RequestMapping("/admin/addBook")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addBook";
    }

    @PostMapping("/admin/processAddBook")
    public String processAddBook(@ModelAttribute Book book, Model model){

    }


}
