package com.altec.api.controller;

import com.altec.api.persistence.entity.Categoria;
import com.altec.api.persistence.entity.Producto;
import com.altec.api.service.CategoryService;
import com.altec.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.Valid;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/productos")
    public String getAll(Model model) {
        List<Producto> productos = productService.getAll();
        model.addAttribute("productos", productos);
        return "products/all";
    }

    @GetMapping("/productos/add")
    public String add(Model model, Producto producto) {
        List<Categoria> categorias = categoryService.getActives();
        model.addAttribute("categorias", categorias);
        return "products/add";
    }

    @PostMapping("/productos/save") 
    public String save(
        @Valid Producto p,
        BindingResult bindingResult,
        Model model
    ) {
        List<Categoria> categorias = categoryService.getActives();
        model.addAttribute("categorias", categorias);
        if (bindingResult.hasErrors()) {
            if (p.getIdProducto() == null) {
                return "products/add";
            }else{
                return "products/edit";
            }
        } 
        p = productService.save(p);
        return  "redirect:/productos";
    }

    @GetMapping("/productos/edit") 
    public String edit(
        @RequestParam("id") int idProducto,
        Model model
    ) {
        List<Categoria> categorias = categoryService.getActives();
        model.addAttribute("categorias", categorias);
        Producto p = productService.find(idProducto);
        model.addAttribute("producto", p);
        return  "/products/edit";
    }

    @GetMapping("/productos/delete")
    public String delete(@RequestParam("id") int idProducto) {
        productService.delete(idProducto);
        return "redirect:/productos?success=1";
    }
}
