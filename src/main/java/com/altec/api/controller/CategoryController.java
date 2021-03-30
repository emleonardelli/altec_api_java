package com.altec.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.altec.api.persistence.entity.Categoria;
import com.altec.api.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categorias")
    public String getAll(Model model) {
        List<Categoria> categorias = categoryService.getAll();
        model.addAttribute("categorias", categorias);
        return "categories/all";
    }

    @GetMapping("/categorias/add")
    public String add(Categoria categoria) {
        return "categories/add";
    }

    @PostMapping("/categorias/save")
    public String save(
        @Valid Categoria c,
        BindingResult bindingResult,
        @RequestParam(required = false) Boolean estado
    ) {
        if (bindingResult.hasErrors()) {
            if (c.getIdCategoria() == null) {
                return "categories/add";
            }else{
                return "categories/edit";
            }
        } 
        
        c.setEstado(estado == null ? false : true);
        c = categoryService.save(c);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/edit") 
    public String edit(
        @RequestParam("id") int idCategoria,
        Model model
    ) {
        Categoria c = categoryService.find(idCategoria);
        model.addAttribute("categoria", c);
        return  "/categories/edit";
    }

    @GetMapping("/categorias/delete")
    public String delete(@RequestParam("id") int idCategoria) {
        categoryService.delete(idCategoria);
        return "redirect:/categorias";
    }
}
