package com.evaluaciontecnica.servicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluaciontecnica.servicio.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,String> {
	

}
