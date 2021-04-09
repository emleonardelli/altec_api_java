package com.altec.api.controller;

import java.util.List;

import com.altec.api.persistence.entity.Cliente;
import com.altec.api.persistence.entity.Compra;
import com.altec.api.persistence.entity.Producto;
import com.altec.api.service.ClientService;
import com.altec.api.service.ProductService;
import com.altec.api.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;

    @GetMapping("/compras")
    public String getAll(Model model) {
        List<Compra> compras = purchaseService.getAll();
        model.addAttribute("compras", compras);
        return "purchases/all";
    }

    @GetMapping("/compras/show")
    public String add(
        Model model, 
        Compra compra,
        @RequestParam(required = false, name = "id") Integer idCompra
    ) {
        Cliente cliente = null;
        if (idCompra != null) {
            compra = purchaseService.find(idCompra);
            cliente = clientService.find(compra.getIdCliente());
        }
        List<Cliente> clientes = clientService.getAll();
        model.addAttribute("clientes", clientes);

        List<Producto> productos = productService.getAll();
        model.addAttribute("productos", productos);

        model.addAttribute("cliente", cliente);
        model.addAttribute("compra", compra);
        return "purchases/show";
    }
}
