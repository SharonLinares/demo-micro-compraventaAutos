package com.sharito.demo.micro.compraventacoches2.dto;

import java.time.LocalDate;

public class CompraVentaCochesDto {

	private String codigoVendedor;
	private String codigoCliente;
	private String matricula;
	private String tipotransaccion; // solo debe tener dos valores [compra o venta]
	private LocalDate fechaTransaccion;
	private AutoDto autoDto;

	public CompraVentaCochesDto() {
		super();
	}

	public CompraVentaCochesDto(String codigoVendedor, String codigoCliente, String matricula, String tipotransaccion,
			LocalDate fechaTransaccion) {
		super();
		this.codigoVendedor = codigoVendedor;
		this.codigoCliente = codigoCliente;
		this.matricula = matricula;
		this.tipotransaccion = tipotransaccion;
		this.fechaTransaccion = fechaTransaccion;
	}

	public String getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(String codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTipotransaccion() {
		return tipotransaccion;
	}

	public void setTipotransaccion(String tipotransaccion) {
		this.tipotransaccion = tipotransaccion;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public AutoDto getAutoDto() {
		return autoDto;
	}

	public void setAutoDto(AutoDto autoDto) {
		this.autoDto = autoDto;
	}
	
	

}
