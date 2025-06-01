package ir.digixo.controller;

import ir.digixo.entity.Product;
import ir.digixo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{owner}")
    public Product getProduct(@PathVariable String owner, Principal principal) {
        System.out.println("principal.getName() : " + principal.getName());
        System.out.println("@PathVariable /products/{owner} : " + owner);
        return productService.getProduct(owner);
    }
}

