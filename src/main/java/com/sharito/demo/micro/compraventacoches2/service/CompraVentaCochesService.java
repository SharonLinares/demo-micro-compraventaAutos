package com.sharito.demo.micro.compraventacoches2.service;

import java.util.List;

import com.sharito.demo.micro.compraventacoches2.dto.CompraVentaCochesDto;

public interface CompraVentaCochesService {

	public CompraVentaCochesDto crear(CompraVentaCochesDto compraVentaCochesDto);

	public CompraVentaCochesDto actualizar(CompraVentaCochesDto compraVentaCochesDto, Integer id);

	public List<CompraVentaCochesDto> consultarCompraVentaCoches();

	public void eliminar(Integer id);

}
