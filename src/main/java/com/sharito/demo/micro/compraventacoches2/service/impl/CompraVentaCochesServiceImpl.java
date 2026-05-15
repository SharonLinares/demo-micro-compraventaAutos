package com.sharito.demo.micro.compraventacoches2.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sharito.demo.micro.compraventacoches2.dto.CompraVentaCochesDto;
import com.sharito.demo.micro.compraventacoches2.entity.CompraVentaCochesEntity;
import com.sharito.demo.micro.compraventacoches2.repository.CompraVentaCochesRepository;
import com.sharito.demo.micro.compraventacoches2.service.CompraVentaCochesService;

@Service
public class CompraVentaCochesServiceImpl implements CompraVentaCochesService {

	private final CompraVentaCochesRepository repository;

	public CompraVentaCochesServiceImpl(CompraVentaCochesRepository repository) {
		this.repository = repository;
	}

	@Override
	public CompraVentaCochesDto crear(CompraVentaCochesDto dto) {

		validar(dto);

		CompraVentaCochesEntity entity = dtoToEntity(dto);
		entity.setFechaTransaccion(LocalDate.now());

		return entityToDto(repository.save(entity));
	}

	@Override
	public CompraVentaCochesDto actualizar(CompraVentaCochesDto dto, Integer id) {

		CompraVentaCochesEntity existente = repository.findById(id).orElse(null);

		if (existente == null) {
			throw new IllegalArgumentException("No existe la transacción");
		}
		validar(dto);

		CompraVentaCochesEntity actualizado = dtoToEntity(dto);
		actualizado.setId(existente.getId());
		actualizado.setFechaTransaccion(LocalDate.now());

		return entityToDto(repository.save(actualizado));
	}

	@Override
	public List<CompraVentaCochesDto> consultarCompraVentaCoches() {

		List<CompraVentaCochesDto> lista = new ArrayList<>();

		for (CompraVentaCochesEntity entity : repository.findAll()) {
			lista.add(entityToDto(entity));
		}

		return lista;
	}

	@Override
	public void eliminar(Integer id) {

		if (!repository.existsById(id)) {
			throw new IllegalArgumentException("No existe la transacción");
		}

		repository.deleteById(id);
	}



	private void validar(CompraVentaCochesDto dto) {

		if (dto.getCodigoCliente() == null || dto.getCodigoCliente().isEmpty()) {
			throw new IllegalArgumentException("Cliente obligatorio");
		}

		if (dto.getCodigoVendedor() == null || dto.getCodigoVendedor().isEmpty()) {
			throw new IllegalArgumentException("Vendedor obligatorio");
		}

		if (dto.getMatricula() == null || dto.getMatricula().isEmpty()) {
			throw new IllegalArgumentException("Matricula obligatoria");
		}
	}


	private CompraVentaCochesEntity dtoToEntity(CompraVentaCochesDto dto) {

		CompraVentaCochesEntity entity = new CompraVentaCochesEntity();

		entity.setCodigoCliente(dto.getCodigoCliente());
		entity.setCodigoVendedor(dto.getCodigoVendedor());
		entity.setMatricula(dto.getMatricula());
		entity.setTipotransaccion(dto.getTipotransaccion());
		entity.setFechaTransaccion(dto.getFechaTransaccion());

		return entity;
	}

	private CompraVentaCochesDto entityToDto(CompraVentaCochesEntity entity) {

		CompraVentaCochesDto dto = new CompraVentaCochesDto();

		dto.setId(entity.getId());
		dto.setCodigoCliente(entity.getCodigoCliente());
		dto.setCodigoVendedor(entity.getCodigoVendedor());
		dto.setMatricula(entity.getMatricula());
		dto.setTipotransaccion(entity.getTipotransaccion());
		dto.setFechaTransaccion(entity.getFechaTransaccion());

		return dto;
	}
}