package ir.digixo.service;

import ir.digixo.entity.Product;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {

    private Map<String, Product> products =
            Map.of("mahsa", new Product("iphone", "mahsa"),
                    "ashkan", new Product("ipad", "ashkan"),
                    "nader", new Product("mac", "nader"));

    // @PreAuthorize(value = "#owner == authentication.principal.username")

    @PreAuthorize(value = "hasAuthority('write')"
            + "or authentication.principal.username.equals(#owner) ")
    public Product getProduct(String owner) {
        return products.get(owner);
    }
}
