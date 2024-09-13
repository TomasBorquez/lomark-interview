package me.tomas.borquez.section3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "home";
    }

    @PostMapping("/addProduct")
    public String addProduct(Product newProduct) {
        productService.addProduct(newProduct);
        return "redirect:/";
    }
}
