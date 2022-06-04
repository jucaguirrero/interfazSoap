package com.UntoonSoap.conexionRest.Models;

public class ComicSoap 
{
	private String nombre; 
	private String autor;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	@Override
	public String toString() {
		return "ComicSoap [nombre=" + nombre + ", autor=" + autor + "]";
	}
	public ComicSoap() {
		
	} 
	
	
	 

}
