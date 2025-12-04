package com.sharito.demo.micro.compraventacoches2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharito.demo.micro.compraventacoches2.entity.CompraVentaCochesEntity;

@Repository
public interface CompraVentaCochesRepository extends JpaRepository<CompraVentaCochesEntity, Integer> {
	
	
	
	
}
