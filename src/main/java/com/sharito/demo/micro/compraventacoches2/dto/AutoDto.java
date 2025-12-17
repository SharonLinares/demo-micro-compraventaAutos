package com.sharito.demo.micro.compraventacoches2.dto;

public class AutoDto {

	public String marca;
	public String modelo;
	public String anioDeMatriculacion;
	public String matricula;

	public AutoDto() {
		super();
	}

	public AutoDto(String marca, String modelo, String anioDeMatriculacion, String matricula) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.anioDeMatriculacion = anioDeMatriculacion;
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAnioDeMatriculacion() {
		return anioDeMatriculacion;
	}

	public void setAnioDeMatriculacion(String anioDeMatriculacion) {
		this.anioDeMatriculacion = anioDeMatriculacion;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
