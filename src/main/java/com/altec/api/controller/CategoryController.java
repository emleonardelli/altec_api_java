package com.altec.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.altec.api.persistence.entity.Categoria;
import com.altec.api.service.CategoryService;
import com.altec.api.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/categorias")
    public String getAll(Model model) {
        List<Categoria> categorias = categoryService.getAll();
        model.addAttribute("categorias", categorias);
        return "categories/all";
    }

    @GetMapping("/categorias/show")
    public String add(
        Categoria categoria, 
        Model model, 
        @RequestParam(required = false, name = "id") Integer idCategoria
    ) {
        if (idCategoria != null) {
            categoria = categoryService.find(idCategoria);
        }
        model.addAttribute("categoria", categoria);
        return "categories/show";
    }

    @PostMapping("/categorias/save")
    public String save(
        @Valid Categoria c,
        BindingResult bindingResult,
        @RequestParam(required = false) Boolean estado
    ) {
        if (bindingResult.hasErrors()) {
            return "categories/show";
        } 
        c = categoryService.save(c);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/delete")
    public String delete(@RequestParam("id") int idCategoria) {
        if (productService.categoryHasProducts(idCategoria)) {
            return "redirect:/categorias?fail=1";    
        }else{
            categoryService.delete(idCategoria);
            return "redirect:/categorias?success=1";
        }
    }
}
