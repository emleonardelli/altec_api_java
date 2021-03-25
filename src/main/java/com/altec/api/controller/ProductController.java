package com.altec.api.controller;

import com.altec.api.persistence.entity.Producto;
import com.altec.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getProducts(Model model) {
        List<Producto> productos = productService.getAll();
        model.addAttribute("productos", productos);
        return "products/all";
    }
}
