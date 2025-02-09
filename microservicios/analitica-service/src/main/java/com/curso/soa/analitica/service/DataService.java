package com.curso.soa.analitica.service;

import com.curso.soa.analitica.entity.Data;
import com.curso.soa.analitica.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private DataRepository repository;

    public Data addData(Data dat) {
        return repository.save(dat);
    }


    public List<Data> getData() {
        return repository.findAll();
    }

}