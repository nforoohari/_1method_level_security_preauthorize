package ir.digixo.controller;

import ir.digixo.entity.Product;
import ir.digixo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class ProductController {

    private ProductService bookService;

    public ProductController(ProductService bookService) {
        this.bookService = bookService;
    }

   /* @GetMapping("/products/{code}")
    public Product getDetails(@PathVariable String code) {
        return bookService.getBook(code);
    }*/
   @GetMapping("/products/{owner}")
   public Product delete(@PathVariable String owner,Principal principal ) {


       System.out.println(principal.getName());
       System.out.println(owner);
       return bookService.getProduct(owner);
   }
}

