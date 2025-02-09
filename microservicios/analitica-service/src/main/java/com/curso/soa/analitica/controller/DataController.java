package com.curso.soa.analitica.controller;

import com.curso.soa.analitica.entity.Data;
import com.curso.soa.analitica.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analitica")
public class DataController {

    @Autowired
    private DataService service;

    @PostMapping
    public Data addData(@RequestBody Data data) {
        return service.addData(data);
    }

    @GetMapping
    public List<Data> autenticarCliente() {
        return service.getData();
    }
}