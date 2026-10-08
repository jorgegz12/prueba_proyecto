
package clasepoo;


public class Vehiculo {
 // Atributos privados (encapsulamiento)
    private String marca;
    private String modelo;
    private int    anio;
    private double precio;
    private Llanta llanta;  // Composición: Vehiculo "tiene" una Llanta
 
    // Constructor con todos los parámetros
    public Vehiculo(String marca, String modelo, int anio, double precio, Llanta llanta) {
        this.marca  = marca;
        this.modelo = modelo;
        this.anio   = anio;
        this.llanta = llanta;
        setPrecio(precio);  // Usamos el setter para validar el precio
    }
 
    // Setter con validación — no permite precios negativos
    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            System.out.println("Error: el precio debe ser mayor que cero");
        }
    }
 
    // Getters
    public String getMarca()  { return this.marca; }
    public String getModelo() { return this.modelo; }
    public int    getAnio()   { return this.anio; }
    public double getPrecio() { return this.precio; }
    public Llanta getLlanta() { return this.llanta; }
 
    // Muestra toda la información del vehículo y su llanta en consola
    public void mostrarInformacion() {
        System.out.println("Marca: "   + marca);
        System.out.println("Modelo: "  + modelo);
        System.out.println("Año: "     + anio);
        System.out.println("Precio: Q" + precio);
        System.out.println("Información de la llanta:");
        llanta.mostrarInformacion();
    }
}   

