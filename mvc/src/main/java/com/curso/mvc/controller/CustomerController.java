package com.curso.mvc.controller;
import com.curso.mvc.entities.Customer;
import  com.curso.mvc.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
@Tag(name = "Clientes", description = "Operaciones relacionadas con clientes")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    @Operation(summary = "Listar clientes", description = "Obtiene una lista de todos los clientes.")
    @ApiResponse(responseCode = "200", description = "Lista de clientes obtenida correctamente.")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers/list";
    }

    @GetMapping("/new")
    @Operation(summary = "Mostrar formulario de cliente", description = "Muestra el formulario para crear un nuevo cliente.")
    @ApiResponse(responseCode = "200", description = "Formulario mostrado correctamente.")
    public String showCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/form";
    }

    @PostMapping
    @Operation(summary = "Crear cliente", description = "Crea un nuevo cliente.")
    @ApiResponse(responseCode = "302", description = "Cliente creado correctamente.")
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
}