package ir.digixo.service;

import ir.digixo.entity.Product;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {

    private final Map<String, Product> products =
            Map.of("bita", new Product("iphone", "bita"),
                    "borna", new Product("ipad", "borna"),
                    "bardia", new Product("mac", "bardia"));


    @PreAuthorize(value = "(hasAuthority('write') or hasAuthority('ROLE_write'))" + " and authentication.principal.username.equals(#owner) ")
    public Product getProduct(String owner) {
        System.out.println("ProductService.getProduct : " + owner);
        return products.get(owner);
    }
}
