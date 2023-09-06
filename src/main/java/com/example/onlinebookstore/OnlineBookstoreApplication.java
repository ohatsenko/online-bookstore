package com.example.onlinebookstore;

import com.example.onlinebookstore.model.Book;
import com.example.onlinebookstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineBookstoreApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book threeComrades = new Book();
            threeComrades.setTitle("Three Comrades");
            threeComrades.setAuthor("Erich Maria Remarque");
            threeComrades.setIsbn("9780449912423");
            threeComrades.setPrice(BigDecimal.valueOf(19.99));

            bookService.save(threeComrades);
            System.out.println(bookService.findAll());
        };
    }

}
