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

/* Estudiante: Carlos Andrés Gutiérrez González
   2023396058 
   Curso: Programación Orientada a Objectos
   Grupo #2
    
    I Proyecto: Programa Parqueos Callejeros

    II SEMESTRE 2024 
    Profesor: William Mata Rodríguez 
*/

/*
    Clase utilizada por el array de multas en la clase de SistemaParqueo.
    Se da formato a los datos antes de ser agregada a esta.
    Para esto se utilza de un metodo constructor.
*/




public class RegistroMultas implements Serializable {
    protected String Nombre;
    protected String Apellidos;
    protected String Posicion;
    protected String Placa;
    protected LocalDate Fecha;
    protected String Detalles;
    protected String NombreInspector; 
    protected int CostoMulta;
            
    /**
     *
     * @param Nombre String Primer nombre de usuario
     * @param Apellidos String Apellido de usuario
     * @param Posicion String unico
     * @param Placa String Placa del vehiculo
     * @param Fecha LocalDate Tomado del sistema al registrarse
     * @param Detalles String motivo de multa
     * @param NombreInspector String Entidad que hace la multa
     * @param costomulta Integer Costo actual de la multa
     */
    public RegistroMultas(String Nombre, String Apellidos, String Posicion,String Placa, LocalDate Fecha, String Detalles, String NombreInspector, int costomulta){

        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Posicion = Posicion;
        this.Placa = Placa;
        this.Fecha = Fecha;
        this.Detalles = Detalles;
        this.NombreInspector = NombreInspector;
        this.CostoMulta = costomulta;
        

    }
    
}
