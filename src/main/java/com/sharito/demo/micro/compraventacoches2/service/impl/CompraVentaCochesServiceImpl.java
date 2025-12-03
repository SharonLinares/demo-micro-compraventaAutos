package com.sharito.demo.micro.compraventacoches2.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sharito.demo.micro.compraventacoches2.dto.CompraVentaCochesDto;
import com.sharito.demo.micro.compraventacoches2.entity.CompraVentaCochesEntity;
import com.sharito.demo.micro.compraventacoches2.repository.CompraVentaCochesRepository;
import com.sharito.demo.micro.compraventacoches2.service.CompraVentaCochesService;

public class CompraVentaCochesServiceImpl implements CompraVentaCochesService {

	@Autowired
	private CompraVentaCochesRepository compraVentaCochesRepository;

	@Override
	public CompraVentaCochesDto crear(CompraVentaCochesDto compraVentaCochesDto) {
		CompraVentaCochesEntity compraVentaCochesEntity = new CompraVentaCochesEntity();
		compraVentaCochesEntity.setCodigoVendedor(compraVentaCochesDto.getCodigoVendedor());
		compraVentaCochesEntity.setCodigoCliente(compraVentaCochesDto.getCodigoCliente());
		compraVentaCochesEntity.setMatricula(compraVentaCochesDto.getMatricula());
		compraVentaCochesEntity.setTipotransaccion(compraVentaCochesDto.getTipotransaccion());
		compraVentaCochesEntity.setFechaTransaccion(LocalDate.now());
		compraVentaCochesRepository.save(compraVentaCochesEntity);

		return compraVentaCochesDto;
	}

	@Override
	public CompraVentaCochesDto actualizar(CompraVentaCochesDto compraVentaCochesDto, Integer id) {
		CompraVentaCochesEntity compraVentaCochesEntity = compraVentaCochesRepository.findById(id).orElse(null);
		compraVentaCochesEntity.setCodigoCliente(compraVentaCochesDto.getCodigoCliente());
		compraVentaCochesEntity.setMatricula(compraVentaCochesDto.getMatricula());
		compraVentaCochesEntity.setFechaTransaccion(LocalDate.now());
		compraVentaCochesRepository.save(compraVentaCochesEntity);
		return compraVentaCochesDto;
	}

	@Override
	public List<CompraVentaCochesDto> consultarCompraVentaCoches() {
		List<CompraVentaCochesEntity> compraVentaCochesEntity = compraVentaCochesRepository.findAll();
		List<CompraVentaCochesDto> compraVentaCochesDtos = new ArrayList<>();
		for (CompraVentaCochesEntity compraVentaCochesEntity2 : compraVentaCochesEntity) {
			CompraVentaCochesDto compraVentaCochesDto = new CompraVentaCochesDto();
			compraVentaCochesDto.setCodigoCliente(compraVentaCochesEntity2.getCodigoCliente());
			compraVentaCochesDto.setMatricula(compraVentaCochesEntity2.getMatricula());

			compraVentaCochesDtos.add(compraVentaCochesDto);

		}

		return compraVentaCochesDtos;
	}

	@Override
	public void eliminar(Integer id) {
		if (compraVentaCochesRepository.existsById(id)) {
			compraVentaCochesRepository.deleteById(id);
		}
	}

}