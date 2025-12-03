package com.sharito.demo.micro.compraventacoches2.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Compraventacoches")
public class CompraVentaCochesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer id;
	@Column(nullable = false)
	private String codigoVendedor;
	@Column(nullable = false)
	private String codigoCliente;
	@Column(nullable = false)
	private String matricula;
	@Column(nullable = false)
	private String tipotransaccion; // solo debe tener dos valores [compra o venta]
	@Column(nullable = false)
	private LocalDate fechaTransaccion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
