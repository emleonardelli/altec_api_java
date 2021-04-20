package com.altec.api.controller;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.altec.api.persistence.entity.Cliente;
import com.altec.api.persistence.entity.Compra;
import com.altec.api.persistence.entity.CompraProducto;
import com.altec.api.persistence.entity.CompraProductoKey;
import com.altec.api.persistence.entity.Producto;
import com.altec.api.service.ClientService;
import com.altec.api.service.ProductService;
import com.altec.api.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/compras/save")
    public String save(
        @Valid Compra compra, 
        BindingResult bigBindingResult,
        @RequestParam Map<String, String> reqParam,
        Model model
    ) {
        List<Producto> productos = productService.getAll();
        String inputFecha = reqParam.get("fecha");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/M/dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(inputFecha, formatter);
        compra.setFecha(dateTime);
        compra = purchaseService.save(compra);
        for (Producto producto : productos) {
            if (reqParam.get("pr_id_"+producto.getIdProducto()) != null) {
                String input = reqParam.get("pr_id_"+producto.getIdProducto());
                int totalFrom = input.indexOf('$') + 1;
                int totalTo = totalFrom + input.substring(totalFrom, input.length()).indexOf(' ');
                String total = input.substring(totalFrom, totalTo);
                int cantFrom = totalTo + input.substring(totalTo, input.length()).indexOf(':') + 2;
                int cantTo = input.length();
                int cantidad = Integer.parseInt(input.substring(cantFrom, cantTo));
                purchaseService.addDetalle(
                    compra, 
                    producto,
                    cantidad,
                    Double.parseDouble(total)
                );
            }
        }
        return "redirect:/compras";
        
    }
}
