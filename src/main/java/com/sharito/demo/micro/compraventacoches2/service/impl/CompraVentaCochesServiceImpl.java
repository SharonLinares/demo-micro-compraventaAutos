package com.sharito.demo.micro.compraventacoches2.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.sharito.demo.micro.compraventacoches2.controller.CompraVentaCochesController;
import com.sharito.demo.micro.compraventacoches2.dto.CompraVentaCochesDto;
import com.sharito.demo.micro.compraventacoches2.entity.CompraVentaCochesEntity;
import com.sharito.demo.micro.compraventacoches2.repository.CompraVentaCochesRepository;
import com.sharito.demo.micro.compraventacoches2.service.CompraVentaCochesService;

@Service
public class CompraVentaCochesServiceImpl implements CompraVentaCochesService {

	@Autowired
	private CompraVentaCochesRepository compraVentaCochesRepository;

	@Autowired
	private RestTemplate resttemplate;

	@Override
	public CompraVentaCochesDto crear(CompraVentaCochesDto compraVentaCochesDto) {
		boolean respuestaAuto = resttemplate.getForObject(
				"http://localhost:8080/autos/existe/" + compraVentaCochesDto.getMatricula(), Boolean.class);
		if (!respuestaAuto) {
			throw new IllegalArgumentException(" esta matricula no existe");

		}
		boolean respuestaCliente = resttemplate.getForObject(
				"http://localhost:8083/clientes/existe/" + compraVentaCochesDto.getCodigoCliente(), Boolean.class);
		if (!respuestaCliente) {
			throw new IllegalArgumentException(" este cliente no existe");
		}

		boolean respuestaVendedor = resttemplate.getForObject(
				"http://localhost:8081/vendedores/existe/" + compraVentaCochesDto.getCodigoVendedor(), Boolean.class);
		if (!respuestaVendedor) {
			throw new IllegalArgumentException(" este vendedor no existe");
		}

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
		List<CompraVentaCochesEntity> compraVentaCochesEntities = compraVentaCochesRepository.findAll();
		List<CompraVentaCochesDto> compraVentaCochesDtos = new ArrayList<>();
		for (CompraVentaCochesEntity compraVentaCochesEntity : compraVentaCochesEntities) {
			CompraVentaCochesDto compraVentaCochesDto = new CompraVentaCochesDto();
			compraVentaCochesDto.setCodigoCliente(compraVentaCochesEntity.getCodigoCliente());
			compraVentaCochesDto.setMatricula(compraVentaCochesEntity.getMatricula());

			compraVentaCochesDto.setCodigoVendedor(compraVentaCochesEntity.getCodigoVendedor());
			compraVentaCochesDto.setFechaTransaccion(compraVentaCochesEntity.getFechaTransaccion());
			compraVentaCochesDto.setTipotransaccion(compraVentaCochesEntity.getTipotransaccion());

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