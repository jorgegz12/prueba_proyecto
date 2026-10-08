/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasepoo;

public class Llanta {
 // Atributos privados — encapsulamiento
    private String marca;
    private int    tamanio;
    private double presion;
 
    // Constructor — recibe los 3 valores al crear la llanta
    public Llanta(String marca, int tamanio, double presion) {
        this.marca   = marca;
        this.tamanio = tamanio;
        this.presion = presion;
    }
 
    // Método para mostrar la información en consola
    public void mostrarInformacion() {
        System.out.println("Marca de llanta: " + marca);
        System.out.println("Tamaño: " + tamanio + " pulgadas");
        System.out.println("Presión: " + presion + " PSI");
    }
 
    // Getters
    public String getMarca()   { return this.marca; }
    public int    getTamanio() { return this.tamanio; }
    public double getPresion() { return this.presion; }   
}
