package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import com.oracle.tools.packager.mac.MacAppBundler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.IdentifierProcessing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CloudinaryConfiguration cloudinaryConfiguration;

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
    public String processAddBook(@ModelAttribute Book book, @RequestParam("file") MultipartFile file, Model model){
        if(file.isEmpty()){
            return "redirect:/admin/addBook";
        }
        try {
            Map uplaodResult = cloudinaryConfiguration.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
            book.setBookImage(uplaodResult.get("url").toString());
            bookRepository.save(book);
        }catch (IOException e){
            e.printStackTrace();
            return "redirect:/admin/addBook";
        }

    return "redirect:/admin/viewBooks";
    }

    @RequestMapping("/admin/viewBooks")
    public String adminViewBooks(Model model){
        model.addAttribute("book", bookRepository.findAll());
        return "adminViewBooks";
    }


    @RequestMapping("/admin/updateBook/{id}")
    public String updateBook(@PathVariable("id") Long id,  Model model){
        model.addAttribute("book",bookRepository.findById(id).get());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("message", "New image required for update");
        return "addBook";
    }

    @RequestMapping("/viewBookDetails/{id}")
    public String bookDetails(@PathVariable("id") long id, Model model){
        Book book = bookRepository.findById(id).get();
        model.addAttribute("book", book);
        return "bookDetails";
    }

}
