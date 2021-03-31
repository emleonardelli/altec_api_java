package com.altec.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.altec.api.persistence.entity.Cliente;
import com.altec.api.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clientes")
    public String getAll(Model model) {
        List<Cliente> clientes = clientService.getAll();
        model.addAttribute("clientes", clientes);
        return "clients/all";
    }

    @GetMapping("/clientes/show")
    public String add(
        Cliente cliente, 
        Model model, 
        @RequestParam(required = false, name = "id") Integer idCliente
    ) {
        if (idCliente != null) {
            cliente = clientService.find(idCliente);
        }
        model.addAttribute("cliente", cliente);
        return "clients/show";
    }

    @PostMapping("/clientes/save")
    public String save(
        @Valid Cliente cliente,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "clients/show";
        }
        cliente = clientService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/delete")
    public String delete(@RequestParam("id") int idCliente) {
        clientService.delete(idCliente);
        return "redirect:/clientes?success=1";
    }
}
