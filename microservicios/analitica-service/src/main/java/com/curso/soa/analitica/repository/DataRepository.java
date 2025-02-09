package com.curso.soa.analitica.repository;

import com.curso.soa.analitica.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {

}