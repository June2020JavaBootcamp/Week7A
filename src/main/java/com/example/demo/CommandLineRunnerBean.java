package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public void run (String...args){
        Category category1 = new Category();
        category1.setCategoryName("Fiction");
        categoryRepository.save(category1);

        Category category2 = new Category();
        category2.setCategoryName("Non-fiction");
        categoryRepository.save(category2);

        Category category3 = new Category();
        category3.setCategoryName("Children's");
        categoryRepository.save(category3);

        Book book1 = new Book(
                "9780316769174",
                "The Cathcher in the Rye",
                "J.D. Salinger",
                3,
                1951,
                "https://res.cloudinary.com/cloudim/image/upload/c_scale,w_200/v1596808936/1024px-The_Catcher_in_the_Rye__1951__first_edition_cover_g3lmbp.jpg",
                true);
        book1.setCategory(category1);
        bookRepository.save(book1);

        Book book2 = new Book(
                "0-590-30907-2",
                "Corduroy",
                "Don Freeman",
                1,
                1968,
                "https://res.cloudinary.com/cloudim/image/upload/c_scale,w_200/v1596809439/Corduroy_f5pnfu.jpg",
                true);
        book2.setCategory(category3);
        bookRepository.save(book2);

        User admin = new User(
                "admin",
                "admin",
                true);

        Role adminRole = new Role("admin", "ROLE_ADMIN");
        userRepository.save(admin);
        roleRepository.save(adminRole);
    }

}

