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
    Hay una configuracion predeterminada para el parqueo.
    Sin embargo no se va a poder utilizar la funcion de parqueo hasta que sea configurado
    Una vez configurado el int de iniciado cambia a 1. Empieza a funcionar
    Configurar el parqueo desde el menu de administrador.


    Con el constructor se le da formato a los datos y son guardados 
    en el array de ajustes de SistemaParqueo
*/

public class ConfigParqueo implements Serializable { // config default
    
    // Fomato de 24 horas
    // Segunda hora debe de ser mayor a la primer hora
    
    
    protected int PrimerHoraNoPagda = 22;
    protected int SegundaHoraNoPagda =24;
    protected int PrecioHora = 50;
    protected int TiempoMinimo = 1; // minimo de horas para poder parquear
    protected int CostoMulta = 50;
    protected int iniciado = 0; // 0 no config / 1 si config
    
    /**
     *
     * @param PrimeraHora Intger Primera hora de no cobro de parqueo
     * @param SegundaHora Intger Segunda hora de no cobro de parqueo
     * @param PrecioHora Integer Precio por hora del parqueo
     * @param TiempoMin Integer Compra minima de horas 
     * @param Multa Integer Precio por multa
     * @param Iniciar Boolean True se puede parquear False no se puede parquear
     */
    public ConfigParqueo(int PrimeraHora, int SegundaHora, int PrecioHora, int TiempoMin, int Multa, int Iniciar){
    
        this.PrimerHoraNoPagda = PrimeraHora;
        this.SegundaHoraNoPagda = SegundaHora;
        this.PrecioHora = PrecioHora;
        this.TiempoMinimo = TiempoMin;
        this.CostoMulta = Multa;
        this.iniciado = Iniciar;

    }
}
