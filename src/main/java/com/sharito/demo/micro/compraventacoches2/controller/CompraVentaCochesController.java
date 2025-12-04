package com.sharito.demo.micro.compraventacoches2.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharito.demo.micro.compraventacoches2.dto.CompraVentaCochesDto;
import com.sharito.demo.micro.compraventacoches2.service.CompraVentaCochesService;

@RestController
@RequestMapping("compraventa")
public class CompraVentaCochesController {

	@Autowired
	private CompraVentaCochesService compraVentaService;

	@PostMapping("/crear")
	public ResponseEntity<CompraVentaCochesDto> crear(@RequestBody CompraVentaCochesDto compraVentaCochesDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(compraVentaService.crear(compraVentaCochesDto));
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<CompraVentaCochesDto> actualizar(@RequestBody CompraVentaCochesDto compraVentaCochesDto,
			@PathVariable Integer id) {

		return ResponseEntity.status(HttpStatus.CREATED).body(compraVentaService.actualizar(compraVentaCochesDto, id));
	}

	@GetMapping("/consultarCompraVentaCoches")
	public ResponseEntity<List<CompraVentaCochesDto>> consultarCompraVentaCoches() {
		return ResponseEntity.ok(compraVentaService.consultarCompraVentaCoches());
	}
	

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		compraVentaService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
