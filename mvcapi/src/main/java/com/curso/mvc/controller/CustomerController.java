package com.curso.mvc.controller;
import com.curso.mvc.dto.CustomerDTO;
import com.curso.mvc.entities.Customer;
import  com.curso.mvc.service.*;
import com.curso.mvc.util.ResponseHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Clientes", description = "Operaciones relacionadas con clientes")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Operation(summary = "Devuelve la lista de Clientes", description = "Devuelve la lista de Clientes", operationId = "get", tags = {"get, customers" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Devuelve la lista de Clientes"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @GetMapping
    public ResponseEntity<Object> listCustomers() {
        return ResponseHandler.generateResponse("Customers retrieved successfully", HttpStatus.OK,customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>  getCustomer(@PathVariable Long id) {
        return ResponseHandler.generateResponse("Customer retrieved successfully", HttpStatus.OK,customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<Object>  createCustomer(@RequestBody CustomerDTO customer) {
        return ResponseHandler.generateResponse("Customer created successfully", HttpStatus.CREATED,customerService.saveCustomer(CustomerDTO.from(customer)));
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer Customer) {
        Customer.setId(id);
        return customerService.saveCustomer(Customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}