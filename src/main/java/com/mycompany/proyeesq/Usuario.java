/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyeesq;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author XPC
 */

/*
    La clase de Usuario es esencial para el funcionamiento del programa
    inluye todas las variables utilizadas por usuarios y administradores.
    Se utiliza en todas las funciones del programa.

    Se utiliza para el ingreso y registro de todas las personas que 
    deseen utilizar el programa. Para esto se utiliza del metodo constructor.
    
    Para el guardado y restauracion de datos se utiliza la interfaz
    de Serializable, los objetos pueden ser guardados en archivos y ser
    restaurados mas tarde en su estado original.

*/

public class Usuario implements Serializable {
    
    protected String nombre;
    protected String apellido;
    protected int telefono; 
    protected String correoElectronico;
    protected String direccion;
    protected LocalDate fechaIngreso;
    protected String nombreUsuario;
    protected String pin;
    protected long NumTarjeta;
    protected String ExpDate;
    protected int cvc; 
    protected int montoAPagar = 0; // Monto total a pagar por parquarse y multas
    protected boolean multa = false; 
    protected String placa;
    protected String marca;
    protected String modelo;
    protected int horasEstacionado; // Horas compradas
    protected boolean EstaEstacionado = false; // Utilizado para validar la funcion de parqueo
    protected int Privilegio; // Para validar si la persona es usuario (0) / Administrador (1) / Inspector (2)
    protected String PosicionEstacionado; // String unico generado al registrarse
    protected int PrecioMulta; // Total a pagar, solo de la multa
    protected boolean pagado; // Utilizado para validar si el usuario pago o no al estacionarse.
    protected String placa2;
    protected String PosicionEstacionado2;
    protected int totVech;
    
    
    
    
    // Metodo para el ingreso de Usuarios, administradores y Inspectores.

    /**
     *
     * @param nombre String Primer nombre de usuario
     * @param apellido String Apellido de usuario
     * @param telefono Integer Numero del usuario
     * @param correoElectronico String Correo del usuario
     * @param direccion String Direccion del usuario
     * @param fechaIngreso LocalDate Tomado del sistema al registrarse
     * @param nombreUsuario String Nick de usuario
     * @param pin String PIN del usuario
     * @param NumTarjeta long Numero de tarjeta del usuario
     * @param ExpDate String Expiracion de la tarjeta
     * @param cvc Integer Codigo de seguridad
     * @param Placa String Placa del vehiculo
     * @param Marca String Marca del vehiculo
     * @param Modelo String Modelo del vehiculo
     * @param horasEstacionado Integer Horas compradas
     * @param EstaEstacionado Boolean Si esta en el array parqueo
     * @param privilegio Integer 0 = usuario 1 = administrador 2 = inspector
     * @param PosicionEstacionado String unico
     */
    public Usuario(String nombre, String apellido, int telefono, String correoElectronico, String direccion,
                   LocalDate fechaIngreso, String nombreUsuario, String pin, long NumTarjeta ,String ExpDate, int cvc, String Placa, String Marca, String Modelo, int horasEstacionado, boolean EstaEstacionado, int privilegio, String PosicionEstacionado) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.fechaIngreso = fechaIngreso;
        this.nombreUsuario = nombreUsuario;
        this.pin = pin;
        this.NumTarjeta = NumTarjeta;
        this.ExpDate = ExpDate;
        this.cvc = cvc;
        this.placa = Placa;
        this.marca = Marca;
        this.modelo = Modelo;
        this.horasEstacionado = horasEstacionado;
        this.EstaEstacionado = EstaEstacionado;
        this.Privilegio = privilegio;
        this.PosicionEstacionado = PosicionEstacionado;
    }

    
}
