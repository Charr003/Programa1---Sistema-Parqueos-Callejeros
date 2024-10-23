/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyeesq;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;
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

public class SistemaParqueo {
    

    Scanner scan = new Scanner(System.in);
    SistemaCorreos correo = new SistemaCorreos(); // Clase de generacion de correos
    SistemaPDF PDF = new SistemaPDF(); // Clase de generacion de reportes en PDF
    
    private ArrayList<Usuario> usuarios = new ArrayList<>(); // Lista para informacion de todos los usuarios.
    private ArrayList<RegistroParqueo> parqueo = new ArrayList<>(); // Lista ACTUAL del parqueo, utilizada para parquear y desaparcar
    private ArrayList<ConfigParqueo> ajustes = new ArrayList<>(); // Lista donde se guarda la configuracion del parqueo y si esta iniciado o no
    private ArrayList<RegistroMultas> multas = new ArrayList<>(); // Lista de historial de multas
    private ArrayList<RegistroParqueo> historial = new ArrayList<>(); // Lista de historial del parqueo
    
    private final int capacidad = 10; // Capacidad máxima de parqueo
    

    static class RegistroParqueo implements Serializable {
        
        /*
            Utilizada por la lista de parqueo y su historial para guardar y serializar a toda
            persona que se estacione.
            
        */   
        Usuario usuario; // Se toma toda la informacion del usuario.

        int horasParqueo;
        boolean pagado;
        String Placa;
        int TotalPagar;
        String Posicion;
        LocalDate Fecha;
        int PrecioUsuarioMulta;
        
        /**
         *
         * @param usuario Clase Usuario
         * @param horasParqueo Integer Horas compradas por el usuario
         * @param pagado Boolean True si se pago, False si no y se multa
         * @param Placa String Input del usuario
         * @param TotalPago Integer Monto total a pagar
         * @param Posicion String Unico para cada usuario
         * @param Fecha LocalDate tomado del sistema
         * @param PrecioUsuarioMulta Precio actual de las multas en el parqueo
         */
        public RegistroParqueo(Usuario usuario, int horasParqueo, boolean pagado, String Placa, int TotalPago, String Posicion, LocalDate Fecha, int PrecioUsuarioMulta) {
            
            this.usuario = usuario;
            this.horasParqueo = horasParqueo;
            this.pagado = pagado;
            
            this.Placa = Placa;
            this.TotalPagar = TotalPago;
            this.Posicion = Posicion;
            this.Fecha = Fecha;
        }
    }
    
    /**
     *
     * @param usuario Clase Usuario
     * @param horasParqueo Integer Horas compradas por el usuario
     * @param pagado Boolean True si se pago, False si no y se multa
     * @param Placa String Input del usuario
     * @param MontoAPagar Integer Monto total a pagar
     * @param Posicion String Unico para cada usuario
     * @param Fecha LocalDate tomado del sistema
     * @param CostoMulta Precio actual de las multas en el parqueo
     * @return Agrega al usuario al array de parqueo
     */
    
    public boolean parquear(Usuario usuario, int horasParqueo, boolean pagado, String Placa, int MontoAPagar,String Posicion, LocalDate Fecha , int CostoMulta ) {
        
        // Toma info del usuario y su vehiculo y lo almacena en el parqueo
        
        // Método para parquear el vehículo de un usuario
        // La lista de parqueo es la que se utiliza para simular el parqueo por lo que al parquear o desaparcar
        // esta cambia.
        // La lista de historial es lo mismo pero no se modifica en ningun momento y es para guardar un registro        
        
        if (parqueo.size() < capacidad) { // Max 10 en el parqueo al mismo tiempo
            
            parqueo.add(new RegistroParqueo(usuario, horasParqueo, pagado, Placa, MontoAPagar, Posicion, Fecha, CostoMulta));
            historial.add(new RegistroParqueo(usuario, horasParqueo, pagado, Placa, MontoAPagar, Posicion, Fecha, CostoMulta));
            
            return true;
        }
        System.out.println("No hay espacio disponible en el parqueo.");
        return false;
    }

    /**
     *
     * @param usuario Clase Usuario
     * @return Boolean Elimina al usuario del array del parqueo
     */
    
    public boolean desaparcar(Usuario usuario) {
        // Toma la lista de parqueo y elimina de esta al usuario selecionado

        // Método para desaparcar el vehículo de un usuario
        // La lista de parqueo es la que se utiliza para simular el parqueo por lo que al parquear o desaparcar
        // esta cambia.        
        
        for (int i = 0; i < parqueo.size(); i++) { // se cicla por la lista
            
            if (parqueo.get(i).usuario.equals(usuario)) { // se valida el usuario en cuestion
                parqueo.remove(i);
                System.out.println("El usuario " + usuario.nombre + " ha desaparecado.");
                return true;
            }
        }
        System.out.println("El usuario no está parqueado.");
        return false;
    }
    
     public boolean desaparcarNeo(Usuario usuario) {
        // Toma la lista de parqueo y elimina de esta al usuario selecionado

        // Método para desaparcar el vehículo de un usuario
        // La lista de parqueo es la que se utiliza para simular el parqueo por lo que al parquear o desaparcar
        // esta cambia.        
        int ind = 0;
        
        for (RegistroParqueo registro : parqueo){
        
            if(usuario.placa2.equalsIgnoreCase(registro.Placa)){
            
                parqueo.remove(ind);
                return true;
            }
            
            ind++;
        }
        System.out.println("El usuario no está parqueado.");
        return false;
      
    }

    /**
     *
     * @return String Lista actual de las personas parqueadas
     */
    
    public String mostrarParqueo() {
        
        // Método para mostrar el estado del parqueo
        // Utilizado por reportes de PDF
        // Regresa una lista actual de las personas parqueadas
        
        String ParqueoActual = "";

        
        if (parqueo.isEmpty()) {
            
            ParqueoActual += ("El parqueo está vacío.");
            
        } else {
            for (RegistroParqueo registro : parqueo) {
                ParqueoActual += ("\n\n Usuario: " + registro.usuario.nombre + " " + registro.usuario.apellido +
                                   "Horas Parqueado: " + registro.horasParqueo 
                                  +" Placa: " + registro.Placa
                                  +" Posicion: " + registro.Posicion
                                  +" Total a Pagar: "+ registro.usuario.montoAPagar
                                  +" Multado: "+ registro.usuario.multa
                                  +" Fecha:" +registro.usuario.fechaIngreso
                                  +" Pagado: " + (registro.pagado ? "Sí" : "No"));
                                  
            }
        }
        
        return ParqueoActual;
    }
    
    /**
     *
     * @return String lista de los espacios ocupados y vacios en el parqueo actual.
     */
    public String ReporteTodosParqueo() {
        // Utilizado por los reportes de PDF
        // Regresa una lista de los espacios ocupados y vacios en el parqueo actual.
        
        String ParqueoActual = "";
        if (parqueo.isEmpty()) {
            
            ParqueoActual += ("El parqueo está vacío.");
            
        } else {
            for (RegistroParqueo registro : parqueo) {
                ParqueoActual += ("\n\nUsuario: " + registro.usuario.nombre + " " + registro.usuario.apellido +
                                   " Horas Parqueado: " + registro.horasParqueo 
                                  +" Placa: " + registro.Placa
                                  +" Posicion: " + registro.Posicion
                                  +" Total a Pagar: "+ registro.usuario.montoAPagar
                                  +" Multado: "+ registro.usuario.multa
                                  +" Fecha:" +registro.usuario.fechaIngreso
                                  +" Pagado: " + (registro.pagado ? "Sí" : "No"));      
            }
        }
        
        String vacios = ReporteSoloVacios();
        ParqueoActual += vacios;
        
        return ParqueoActual;
    }
    
    /**
     *
     * @return String Reporte de espacios vacios en el parqueo.
     */
    public String ReporteSoloVacios(){
        // Parte de la funcion de ReporteTodosParqueo()
        // Despues de que se cicla por los espacios ocupados, los demas espacios
        // son rellenados con esto.
        
        String vacios = " ";
        int EspaciosOcupados = 10 - parqueo.size();

        for(int i =0; i<EspaciosOcupados;i++){
        
            vacios += ("\n\nUsuario: " 
                                  + " Horas Parqueado: "   
                                  +" Placa: " 
                                  +" Posicion: " 
                                  +" Total a Pagar: "
                                  +" Multado: "
                                  +" Pagado: " 
                                  +" Fecha:");
        }        
        return vacios;
    }
    
    /**
     *
     * @return String Reporte de ingresos de dinero por todos los espacios en el parqueo.
     */
    public String Reporte1(){
        // Primer reporte para administrador y Inspector.
        // Regresa en PDF ingresos de dinero por todos los espacios en el parqueo
        
        String mostrarIngresos = "";
        int i = 0;
        int MontoTotalsinMultas = 0;
        
        if (parqueo.isEmpty()) {
            System.out.println("El parqueo está vacío.");
        } else {
            for (RegistroParqueo registro : parqueo) {
                
                mostrarIngresos += ("\n\nEstacionamiento Numero: " + (i+1)
                                  + " Horas Parqueado: " + registro.horasParqueo 
                                  + " Placa: " + registro.Placa
                                  + " ID: " + registro.Posicion
                                  + " Total a Pagar: "+ registro.usuario.montoAPagar
                                  + " \nFecha:" +registro.usuario.fechaIngreso);
                                  i +=1;
                                  MontoTotalsinMultas += registro.usuario.montoAPagar;
            }
        }
        
        String Parte1= Integer.toString(MontoTotalsinMultas);
        mostrarIngresos +="\n\nMonto Total Generado por los Estacionamientos: " +Parte1;
        return mostrarIngresos;  
    }
    
    /**
     *
     * @return String historial completo de toda persona que se haya estacionado en el parqueo.
     */
    public String mostrarHistorial() {
        // Funcion utilizada para el reporte de los PDF
        // Regresa un historial completo de toda persona que se haya estacionado en el parqueo
        
        String TotalHistorial =" ";
        
        if (historial.isEmpty()) {
            System.out.println("El parqueo está vacío.");
        } else {
            for (RegistroParqueo registro : historial) {
                TotalHistorial += (" Usuario: " + registro.usuario.nombre + " " + registro.usuario.apellido +
                                   "\n Horas Parqueado: " + registro.horasParqueo 
                                   +" Placa: " + registro.Placa
                                   +" Posicion: " + registro.Posicion
                                   +" Total a Pagar: "+ registro.usuario.montoAPagar
                                   +" Multado: "+ registro.usuario.multa
                                   +" Fecha:" +registro.usuario.fechaIngreso
                                   +" Pagado: " + (registro.pagado ? "Sí" : "No"));
                                   
            }
        }
        
        return TotalHistorial;
    }
    
    /**
     *
     * @return String historial completo de todas las multas realizadas
     */
    public String mostrarMulta() {
        // Funcion utilizada para el reporte de los PDF
        // Regresa un historial completo de todas las multas realizadas
        
        String Multa = " ";
        
        if (multas.isEmpty()) {
            System.out.println("No hay multas.");
            
        } else {
            for (RegistroMultas registro : multas) {
                Multa += (" Usuario: " + registro.Nombre+ " " + registro.Apellidos +
                                   "\n Fecha: " + registro.Fecha 
                                  +" Placa: " + registro.Placa
                                  +" Posicion: " + registro.Posicion
                                  +" Nombre Inspector: "+ registro.NombreInspector
                                  +" Detalles: "+ registro.Detalles);
            }
        }
        return Multa;
    }
    
    /**
     *
     * @param park Ajustes actuales del parqueo
     * @return String Estadistica detallada del porcentaje de uso y no uso.
     */
    public String Reporte3(ConfigParqueo park){
        // Reporte 3 de los administradores y Inspectores
        // Regresa una estadistica detallada del porcentaje de uso y no uso de 
        // los espacios del parqueo.
        
        String mostrarUso = "";
        int i = 0;
      
        
        if (parqueo.isEmpty()) {
            mostrarUso += (" ");
            
        } else {
            for (RegistroParqueo registro : parqueo) {
                
            double horasDisponibles = 24 - (park.SegundaHoraNoPagda - park.PrimerHoraNoPagda); // Calculo de horas utilizadas por el usuario
            double porcentajeUso = (registro.horasParqueo / horasDisponibles) * 100;// Calculo de uso
            double NoUso = 100 - porcentajeUso; // Calculo de no uso
            
            String porcentajeUsoFormat = String.format("%.2f", porcentajeUso); // Solo toma dos decimales del resultado
            String NoUsoFormat = String.format("%.2f", NoUso); // Solo toma dos decimales del resultado
                
                mostrarUso += ("\n\nEstacionamiento Numero: " + (i+1)
                                  + " Horas Parqueado: " + registro.horasParqueo 
                                  + " Placa: " + registro.Placa
                                  + " ID: " + registro.Posicion
                                  + " Total a Pagar: "+ registro.usuario.montoAPagar
                                  + " Porcentaje de uso: " +porcentajeUsoFormat
                                  + " Porcentaje de NO uso: " + NoUsoFormat
                                  + " \nFecha:" +registro.usuario.fechaIngreso);
                                  i++;
                                  
            }
        }
        
        return mostrarUso;    
    }

    /**
     *
     * @return String Ingreso total generado multas por cada usuario
     */
    public String Reporte2() {
        // Segundo reporte de Administradores y Inspectores
        // Regresa el ingreso total generado multas por cada usuario
        // y al final una sumatoria del monto generado entre todos.
        
        String Multa = "";
        int i = 0;
        int TotalMulta = 0;        
                
        if (multas.isEmpty()) {
            
            
        } else {
            for (RegistroMultas registro : multas) {
                Multa += ("Multa "+ (i+1) + "\nUsuario: " + registro.Nombre+ " " + registro.Apellidos
                                  +" Placa: " + registro.Placa
                                  +" Posicion: " + registro.Posicion
                                  +" Monto de la Multa: "+ registro.CostoMulta
                                  +"\n\n Fecha: "+ registro.Fecha+"\n\n");
                                  i++;
                                  TotalMulta += registro.CostoMulta;
                                  
            }
        }
        
        String Parte2 = Integer.toString(TotalMulta);
        Multa += "\n\nMonto Total Generado por las Multas: " +Parte2;
         
        return Multa;
    }       
    
    /**
     *
     * @param usuario Clase Usuario
     * @return String multas con al nombre del usuario
     */
    public String mostrarMultaPorNombre(Usuario usuario){
        
        // Se genera un PDF para los usuarios
        // Se regresa unicamente multas con al nombre del usuario
        
        String Multa = " ";
        
        if (multas.isEmpty()) {
            System.out.println("No hay multas.");
            
        } else {
            for (RegistroMultas registro : multas) {
                if(registro.Nombre.equalsIgnoreCase(usuario.nombre)){
                Multa += ("\n\n Usuario: " + registro.Nombre+ " " + registro.Apellidos +
                                   "Fecha: " + registro.Fecha 
                                  +" Placa: " + registro.Placa
                                  +" Posicion: " + registro.Posicion
                                  +" Nombre Inspector: "+ registro.NombreInspector
                                  +" Detalles: "+ registro.Detalles);
            }
            }
        }
        return Multa;
    
    }
    
    /**
     *
     * @param usuario Clase Usuario
     * @return String reporte con todas las veces que el usuario se ha parqueado
     */
    public String mostrarHistorialPorNombre(Usuario usuario) {
        // Se genera un PDF con un historial del parqueo
        // Se regresa un reporte con todas las veces que el usuario se ha parqueado
        
        String Historial = "";
        
        if (historial.isEmpty()) {
            System.out.println("El parqueo está vacío.");
            
        } else {
            for (RegistroParqueo registro : historial) {
                
                if(registro.usuario.nombre.equalsIgnoreCase(usuario.nombre)){
                Historial +=      ("\nNombre: " + registro.usuario.nombre + " " + registro.usuario.apellido +
                                    " Horas Parqueado: " + registro.horasParqueo 
                                   +" Placa: " + registro.Placa
                                   +" Posicion: " + registro.Posicion //registro.usuario.PosicionEstacionado
                                   +" Total a Pagar: "+ registro.TotalPagar
                                   +" Multado: "+ registro.usuario.multa
                                   +" Fecha: " +registro.usuario.fechaIngreso
                                   +" Pagado: " + (registro.pagado ? "Sí\n" : "No\n"));

                }
                                   
            }
            
        }
        return Historial;
    }     

    /**
     *
     * @param nombre Nombre de usuario
     * @return Regresa datos del usuario 
     */
    public Usuario buscarUsuarioPorNombre(String nombre) {
        // Método para buscar un usuario por su nombre
        
        for (Usuario usuario : usuarios) {
            if (usuario.nombreUsuario.equalsIgnoreCase(nombre)) {
                return usuario; // Devuelve el usuario encontrado
            }
        }
        return null; // Si no se encuentra ningún usuario con ese nombre
    }

    /**
     *
     * @param usuario Datos del usuario
     */
    public void agregarUsuario(Usuario usuario) {
       // Método para agregar un nuevo usuario 
        // Utilizado por el metodo constructor de usuario
        
        usuarios.add(usuario);
        correo.EnviarCorreoInfoUser(usuario); // confirmacion de creacion de usuario
    }
    
    /**
     *
     * @param usuario Datos del usuario
     */
    public void eliminarUsuario(Usuario usuario){
        
    // Método eliminar un usuario del array de usuarios
    // Utilizado por el Administrador    
        String nombre = usuario.nombre;
        usuarios.remove(usuario);
        JOptionPane.showMessageDialog(null, nombre+" ha sido eliminado.");
    }
    
    /**
     *
     * @param configpark Ajustes actuales del parqueo
     */
    public void agregarAjustes(ConfigParqueo configpark) {
        // Método agregar ajustes al array de configuracion del parqueo
        ajustes.add(configpark);
        //correo.EnviarCorreoInfoUser(usuario);
    }
    
    /**
     *
     * @param multa Array de multas
     */
    public void agregarMulta(RegistroMultas multa) {
        
        
        // Metodo para agregar una multa al historial de multas
        multas.add(multa);
        //correo.EnviarCorreoInfoUser(usuario);
    }
        

    public void guardarDatos() {
    // Metodo para el guardado de todos los arrays del programa
    // Se serializan y son guardados en "parqueo.dat"     
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("parqueo.dat"))) {
            oos.writeObject(usuarios);
            oos.writeObject(parqueo);
            oos.writeObject(ajustes);
            oos.writeObject(multas); 
            oos.writeObject(historial); 
        } catch (IOException e) {
            System.out.println("Error al guardar los datos.");
        }
    }
    

    public void cargarDatos() {
    // Metodo para leer y cargar datos de "parqueo.dat"
    // Se restauran todos los arrays incluso despues de cerrar el programa.
    
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("parqueo.dat"))) {
            usuarios = (ArrayList<Usuario>) ois.readObject();
            parqueo = (ArrayList<RegistroParqueo>) ois.readObject();
            ajustes = (ArrayList<ConfigParqueo>) ois.readObject(); 
            multas = (ArrayList<RegistroMultas>) ois.readObject();
            historial = (ArrayList<RegistroParqueo>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos.");
        }
    }   
    
    /**
     *
     * @param nombre String Nombre de usuario
     * @param Pin String PIN de usuario
     * @return
     */
    public Usuario validarUSER(String nombre, String Pin) {
        
    //Metodo para validar al usuario y regresar su informacion
    // Toma las credenciales y regresa el usuario si son correctos   
        
        for (Usuario usuario : usuarios) {
            if (usuario.nombreUsuario.equalsIgnoreCase(nombre)) {
                
                if (usuario.pin.equalsIgnoreCase(Pin)) {
                    return usuario; // Devuelve el usuario encontrado
                }
            }
        }
        return null; // Si no se encuentra ningún usuario con ese nombre
    }
    
    /**
     *
     * @param nombre String Nombre de Usuario
     * @return Datos del usuario
     */
    public Usuario encontrarUSER(String nombre) { 

    // Para admins y insp para encontrar y modificar usuarios 
    
        for (Usuario usuario : usuarios) {
            if (usuario.nombreUsuario.equalsIgnoreCase(nombre)) {
                
                
                    return usuario; // Devuelve el usuario encontrado
                
            }
        }
        return null; // Si no se encuentra ningún usuario con ese nombre
    }
    
    /**
     *
     * @param usuario Datos de usuario
     * @param park Ajustes de Parqueo
     * @param NombreInspector String Nombre
     * @param Detalles String Motivo
     */
    
    public void HacerMultaManual(Usuario usuario,ConfigParqueo park,String NombreInspector,String Detalles){
        
        /*
        Existen dos formas de que un usuario sea multado en el programa. Automaticamente o manualmente.
        Automatica: Al parquear su vehiculo, el usuario no pago por el estacionamiento.
        Es multado y notificado sin ningun input.
    
        Manual: Funcion del Inspector, con el nombre de usuario, el inspector puede multar a cualquier persona
        haya pagado por el estacionamiento o no.
        */


        // Toma informacion del usuario y configuracion actual del parqueo.
        // Genera y agrega la multa a su historial y notifica al usuario.
        // Regeresa informacion actualizada al usuario y el monto a pagar
        
        if(usuario != null){
            
            
            if(EstaEnParqueo(usuario.PosicionEstacionado)){
                
                for(RegistroParqueo parking : parqueo){
            
                    if(parking.Posicion.equalsIgnoreCase(usuario.PosicionEstacionado)){ 
                
                        parking.PrecioUsuarioMulta += park.CostoMulta;
                        parking.TotalPagar += park.CostoMulta;
                        usuario.multa = true;
                        usuario.montoAPagar += park.CostoMulta;
                    }
                }
                
                JOptionPane.showMessageDialog(null, "Se ha multado al usuario y actualizado el monto a pagar");
                
                agregarMulta(new RegistroMultas(usuario.nombre, usuario.apellido, usuario.PosicionEstacionado, usuario.placa, usuario.fechaIngreso
                , Detalles, NombreInspector,park.CostoMulta));
                
                correo.EnviarCorreoMulta(usuario, Detalles, NombreInspector);
                
            }else{ // El usuario no esta en el parqueo actualmente
            
                JOptionPane.showMessageDialog(null, "Usuario no esta parqueado.");       
       
            }

        }else{ // El inspector indico un nombre de usuario incorrecto o que no existe.
        
            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
            
        }
    }
    
    public boolean UserPlacaEstaEstacionado(Usuario usuario, Integer VechNum){
        
        if(parqueo.size() == 0){
        
            return false;
            
        }else{
        
            if (VechNum ==1){
            
                for(RegistroParqueo parking : parqueo){
        
                    if(usuario.placa.equalsIgnoreCase(parking.Placa)){
                    
                        return true;
                    }
                }
            }else if(VechNum ==2){
        
                for(RegistroParqueo parking : parqueo){
        
                    if(usuario.placa2.equalsIgnoreCase(parking.Placa)){
                    
                        return true;
                    }
                } 
        
            }
            return false;
        }
    }
    
    /**
     *
     * @param posicion String unico
     * @return Boolean True si esta, False si no
     */
    public boolean EstaEnParqueo(String posicion){
        
        // Funcion utilizada por HacerMultaManual()
        // Cicla por el parqueo actual y revisa si el usuario esta en el parqueo estacionado
        // Toma el String unico del usuario al registrarse. String posicion
    
        for(RegistroParqueo parking : parqueo){
        
            if(parking.Posicion.equalsIgnoreCase(posicion)){
            
                return true;
            }
        
        }
        return false;
    
    }
    
    /**
     *
     * @param usuario Datos de usuario
     */
    public void AdminEliminarUser(Usuario usuario){
        //Funcion de admin
        // Toma info de usuario y la elimina del array de usuarios
        
        if(usuario != null){
        
            eliminarUsuario(usuario);
        
        }else{ // Nombre de usuario no encontrado
        
            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
            
        }
    }
    
    /**
     *
     * @param nombre String nombre de usuario
     * @param Pin String PIN de usuario
     */
    public void MostrarMenuUsuario(String nombre, String Pin){ // DISPLAY USUARIO
        
        // Toma el pin y nombre de usuario
        // Hace un llamado al menu del usuario al ingresar exitosamente sus credenciales
        
        Usuario usuario = validarUSER(nombre,Pin); // validarUSER regresa informacion de usuario
        
        ConfigParqueo park = validarAjustes(); // Se toman los ajustes actuales del parqueo
        
        if(usuario != null){
            
            if(usuario.Privilegio ==0){
            MenuUsuario menuUser = new MenuUsuario(usuario);
            menuUser.setVisible(true);
            menuUser.setLocationRelativeTo(null);
            }else{
                JOptionPane.showMessageDialog(null,"No cumple con los requisitos.");
            }   
        }else{ 
        
            JOptionPane.showMessageDialog(null,"Usuario no encontrado.");
        
        }
    }
    
    /**
     *
     * @param nombre String nombre de usuario
     * @param Pin String PIN de usuario
     * @param choice Integer Recibido de MenuUsuario
     */
    public void mostrarUSER(String nombre, String Pin, int choice) { // SE TOMA PARA OPCIONES
        
        /*
            Se reciben instruciones desde el frame del menu de usuario y se procesean 
            en este metodo.
        
        */
        
        cargarDatos();
        Usuario usuario = validarUSER(nombre,Pin); // se regresa info de usuario
        
        ConfigParqueo park = validarAjustes(); // se regresa ajustes del parqueo
        
        int allgood = 0; // Inetger para validar parqueo
        int size = 10 - parqueo.size(); // Tamaño actual del parqueo
        boolean confpago = false; // Validar si hay multa automatica o no
        
        if (usuario != null) {
            
               switch(choice){
                  
                   case 1: // funcion de parquear
                       
                       try{
                       
                       int VechNum = SelePlacaUser(usuario);      
                           
                       if(park.iniciado == 1  && usuario.totVech < 2){ //Validacion: usuario ha sido configurado y el usuario no esta estacionado en el parqueo
                           
                            int horas = Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantas horas se quiere comprar?"));
                            
                            if(horas >= park.TiempoMinimo){ // Se toman horas minimas configuradas por el administrador
                                
                                allgood++;
                            }
                            
                            int pagare = JOptionPane.showConfirmDialog(null, "Desea pagar por el parqueo?", 
                                    "Confirmacion de pago", JOptionPane.YES_NO_OPTION);
                            
                            if(pagare == JOptionPane.YES_OPTION){ // No se hara una multa automatica
                                
                                 confpago = true;
                                    
                            }else if(pagare == JOptionPane.NO_OPTION){ // Se hara una multa automatica 
                            
                                 confpago = false;
                            
                            }

                            boolean pagar = confpago;
                            
                            if(pagar == true){
                                
                                allgood++;
                                
                            }else{ // Se hace la multa al usuario por no pagar
                                
                                allgood++;
                                usuario.multa = true;
                                HacerMultaAutomatica(usuario,park);
    
                            }
                            
                            if(UserPlacaEstaEstacionado(usuario,VechNum) == false){
                            
                                allgood += 1;
                            }
                            
                            if(allgood ==3){ // Se procede si si cumplen los requisitos
                                
                                // Se guarda informacion actualizada en el usuario
                                
                                usuario.horasEstacionado = horas;
                                usuario.EstaEstacionado = true;
                                usuario.pagado = pagar;
                                usuario.totVech += 1;
                                
                                if(usuario.multa){ // Precio total a pagar por usuario, si es multado se toma el costo actual de la multa
                                    
                                    usuario.montoAPagar = (usuario.horasEstacionado * park.PrecioHora)+park.CostoMulta;
                               
                                }else{ // Precio total a pagar por el usuario, no hay multas
                                    
                                    usuario.montoAPagar = usuario.horasEstacionado * park.PrecioHora;
                                }
                                
                                if(VechNum ==1){
                                    
                                    parquear(usuario, horas, pagar, usuario.placa,usuario.montoAPagar,usuario.PosicionEstacionado, usuario.fechaIngreso
                                    , park.CostoMulta); // Se almacena en array parqueo
                                
                                    JOptionPane.showMessageDialog(null,"Su vehículo ha sido parqueado por " + horas + " horas.");
                                    guardarDatos();
                                    break;
                                    
                                }else if(VechNum == 2){
                                    
                                    
                                    parquear(usuario, horas, pagar, usuario.placa2,usuario.montoAPagar,usuario.PosicionEstacionado2, usuario.fechaIngreso
                                     , park.CostoMulta); // Se almacena en array parqueo
                                    
            
                                    
                                    guardarDatos();
                                    break;
                                    
                                }else{
                                    
                                    JOptionPane.showMessageDialog(null,"No se cumplen requisitos para parquear.");
                                    break;
                                }
                                
                                
                            }else{ // Datos ingresados no cumplen con requisitos para parquear
                                JOptionPane.showMessageDialog(null,"No se cumplen requisitos para parquear.");
                                break;
                            }

                       }else{
                           JOptionPane.showMessageDialog(null,"No se ha iniciado el parqueo o el usuario ya esta estacionado. ");
                           break;
                       }
                       
                       }catch(Exception e ){
                           
                           JOptionPane.showMessageDialog(null,"No se ha configurado el parqueo.");
                           break;
                       }
                       
                       
                   case 2: // Funcion de transacción de más horas
                       cargarDatos();
                       int desa = 0; // Int para validar que se cumplen requisitos para compra
                       
                       try{
                           
                           if(usuario.EstaEstacionado == true){ // Validacion
                               
                                int VechNum = SelePlacaUser(usuario);
                                
                                if(VechNum==1){
                                    
                                    int horasAntes = usuario.horasEstacionado; // Se almacena horas anteriormente adquiridas
                                    int horas = Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantas horas se quiere comprar?" ));
                                
                                
                                    if(horas >= park.TiempoMinimo){ // Se toma ajustes del parqueo realizados por el administrador
                                
                                    desa++; 
                                    }
                                
                                    if(desa ==1){ // Si se cumple requisito de horas minimas se procede
                                   
                                        /*
                                            Para hacer mas facil el proceso de comprar horas y reutilizar codigo
                                            simplemente se desaparca y se vuelve a parquear.
                                            Se calcula nuevo monto a pagar y se sobreescriben datos del usuario.
                                        */
                                        
                                        desaparcar(usuario); 
                                        usuario.horasEstacionado = horas;
                                        usuario.montoAPagar = 0;
                                   
                                        if(usuario.multa){
                                    
                                            usuario.montoAPagar = (usuario.horasEstacionado * park.PrecioHora)+park.CostoMulta;
                                        }else{
                                    
                                            usuario.montoAPagar = usuario.horasEstacionado * park.PrecioHora;
                                        }
                                   
                                   
                                        parquear(usuario, usuario.horasEstacionado, usuario.pagado, usuario.placa,usuario.montoAPagar,usuario.PosicionEstacionado, usuario.fechaIngreso
                                                 , park.CostoMulta); // Se vuelve a agregar el usuario a la lista de parqueo
                                   
                                        JOptionPane.showMessageDialog(null,"Su vehículo ha sido parqueado por " + horas + " horas.");
                                        correo.EnviarConfMasHoras(usuario, horasAntes); // correo de conf de mas horas y de transaccion
                                        guardarDatos();
                                        break;
                               
                                    }else{ // No se cumplen requisitos
                                        JOptionPane.showMessageDialog(null,"No se puede comprar mas horas");
                                        break;
                                    }
                               
                               
                             }else if(VechNum==2){
                                
                                    int horasAntes = usuario.horasEstacionado; // Se almacena horas anteriormente adquiridas
                                    int horas = Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantas horas se quiere comprar?" ));
                                
                                
                                    if(horas >= park.TiempoMinimo){ // Se toma ajustes del parqueo realizados por el administrador
                                
                                    desa++; 
                                    }
                                
                                    if(desa ==1){ // Si se cumple requisito de horas minimas se procede
                                   
                                        /*
                                            Para hacer mas facil el proceso de comprar horas y reutilizar codigo
                                            simplemente se desaparca y se vuelve a parquear.
                                            Se calcula nuevo monto a pagar y se sobreescriben datos del usuario.
                                        */
                                        
                                        desaparcarNeo(usuario); 
                                        
                                        usuario.horasEstacionado = horas;
                                        usuario.montoAPagar = 0;
                                   
                                        if(usuario.multa){
                                    
                                            usuario.montoAPagar = (usuario.horasEstacionado * park.PrecioHora)+park.CostoMulta;
                                        }else{
                                    
                                            usuario.montoAPagar = usuario.horasEstacionado * park.PrecioHora;
                                        }
                                   
                                   
                                        parquear(usuario, usuario.horasEstacionado, usuario.pagado, usuario.placa2,usuario.montoAPagar,usuario.PosicionEstacionado2, usuario.fechaIngreso
                                                 , park.CostoMulta); // Se vuelve a agregar el usuario a la lista de parqueo
                                   
                                        JOptionPane.showMessageDialog(null,"Su vehículo ha sido parqueado por " + horas + " horas.");
                                        correo.EnviarConfMasHoras(usuario, horasAntes); // correo de conf de mas horas y de transaccion
                                        guardarDatos();
                                        break;
                               
                                    }else{ // No se cumplen requisitos
                                        JOptionPane.showMessageDialog(null,"No se puede comprar mas horas");
                                        break;
                                    }
                                
                                
                                 
                                 
                                 
                                }else{
                             
                                  JOptionPane.showMessageDialog(null,"No se puede comprar mas horas");
                                  break;
                             }  
                           }
                       
                       }catch(Exception e){
                       
                       }
                       
                       
                   case 3: // Funcion de desaparcar
                       
                       if(usuario.EstaEstacionado == true){ // Validacion
                           
                            int VechNum = SelePlacaUser(usuario);
                            
                            if(VechNum == 1){
                                
                                desaparcar(usuario); // Toma datos del usuario y los elimina del array de parqueo

                                
                                usuario.totVech -= 1;
                                
                                
                                //JOptionPane.showMessageDialog(null,"Monto total a pagar: " + usuario.montoAPagar);
                                correo.EnviarConfDesaparcar(usuario, park); // Email confirmacion al desaparcar
                                JOptionPane.showMessageDialog(null,"Se ha desaparcado.");
                                
                                usuario.totVech -= 1;
                                
                                usuario.montoAPagar = 0;
                                usuario.horasEstacionado = 0;
                                usuario.EstaEstacionado = false; // Actualiza datos de usuario para poder utilizar parqueo de nuevo
                                usuario.multa = false; // Se simula que se pago la deuda y multa
                                
                                guardarDatos();
                                break;
                                
                            }else if(VechNum == 2) {
                            
                                 Boolean opc = desaparcarNeo(usuario); // Toma datos del usuario y los elimina del array de parqueo
                                
                                
                                if(opc == true){
                                    
                                    usuario.totVech -= 1;
                               
                                    
                                    //JOptionPane.showMessageDialog(null,"Monto total a pagar: " + usuario.montoAPagar);
                                    correo.EnviarConfDesaparcar2(usuario, park); // Email confirmacion al desaparcar
                                    JOptionPane.showMessageDialog(null,"Se ha desaparcado.");
                            
                                    guardarDatos();
                                    break;     
                                    
                                }else
                                {
                                    JOptionPane.showMessageDialog(null,"No esta parqueado.");
                                    break;
                                
                                }
                            }

                       }else{ // Usuario no esta en el array de parqueo
                       
                           JOptionPane.showMessageDialog(null,"No esta parqueado.");
                           break;
                       
                       }
                       
                   case 4: // Funcion de reportes para usuarios
                       
                        String historial = mostrarHistorialPorNombre(usuario); // Regresa historial de parqueo para usuario
                        String multa = mostrarMulta(); // Regresa historial de todas las multas de usuario
                        
                        PDF.ReporteHistorialUsuario(historial, usuario); // Historial de todas las veces que el usuario ha usado el parqueo
                        //PDF.ReporteEspaciosDisponibles(capacidad); 
                        PDF.ReporteSoloVacios(ReporteSoloVacios());  // Regresa cuantos espacios disponbles hay en array parqueo
                        PDF.ReporteDataUsuarios(usuario); // Regresa reporte con los datos del usuario
                        PDF.MultasUsuario(mostrarMultaPorNombre(usuario)); // Reporte de todas las multas a nombre de usuario
                        
                        JOptionPane.showMessageDialog(null,"Se han generado los reportes.");
                        break;
                      
                               
                   case 5: // Funcion para modificar datos de usuario
                       
                       ModificacionUser(usuario);
                       break;
                    
                   case 6: // Funcion para agregar nuevo vehiculo
                       
                       AgregarVech2(usuario);
                       break;
                       
                   default:
                       break;
                                    
               }
            
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
    
    /**
     *
     * @param nombre String Nombre de usuario
     * @return Datos de usuario
     */
    public Usuario ValidarSoloUsuario(String nombre) {
        
        // Funcion para encontrar usuarios solo con nombre de usuario
        // Utilizado por NuevoPIN()
        
        for (Usuario usuario : usuarios) {
            
            if (usuario.nombreUsuario.equalsIgnoreCase(nombre)) {
                
                    return usuario; // Devuelve el usuario encontrado
                
            }
        }
        return null; // Si no se encuentra ningún usuario con ese nombre
    }
    
    /**
     *
     * @param USnombre String Nombre de Usuario
     */
    public void NuevoPIN(String USnombre){
        
        // En caso de perder el PIN, genera uno nuevo
        // Toma el nombre de usuario y lo busca en el array de usuarios
        // Si existe se genera un pin nuevo y cambiado. Se envia email con el pin
        
        cargarDatos();
        Usuario usuario = ValidarSoloUsuario(USnombre);
        
        if( usuario != null){
        
            String cadenaAleatoria = generarStringAleatorio(4); // Pin aletorio
            System.out.println("El nuevo PIN del usuario "+ usuario.nombreUsuario + " es: "
            + cadenaAleatoria); // debugging
            
            usuario.pin = cadenaAleatoria; // Guardado de pin
            
            JOptionPane.showMessageDialog(null,"Se ha enviado un correo con el PIN de recuperacion.");
            correo.EnviarCorreoPIN(usuario);

        }else{
        
            JOptionPane.showMessageDialog(null,"Usuario no encontrado.");
        
        }
    }
    
    /**
     *
     * @param longitud Integer Numero deseado para randomizar
     * @return String aletorio
     */
    public static String generarStringAleatorio(int longitud) {
       
       // Funcion utilizada por NuevoPIN();
       // regresa un string aletorio de 4 caracteres
       
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(longitud);

        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(letras.length());
            sb.append(letras.charAt(indice));
        }
        
        return sb.toString();
    }
    
    /**
     *
     * @param nombre String Nombre de Usuario
     * @param Pin String PIN de Usuario
     */
    public void MostrarMenuAdmin(String nombre, String Pin){ // DISPLAY USUARIO
        
        // Toma el pin y nombre de usuario
        // Hace un llamado al menu del usuario al ingresar exitosamente sus credenciales 
        
        Usuario usuario = validarUSER(nombre,Pin); // Regresa informacion de usuario
        
        ConfigParqueo park = validarAjustes(); // Regresa ajustes actuales del parqueo

        if(usuario != null){
            
            if(usuario.Privilegio ==1){ // Se valida privilegio de administrador
            MenuAdmin menAdmin = new MenuAdmin(usuario);
            menAdmin.setVisible(true);
            menAdmin.setLocationRelativeTo(null);
            
            }else{ // Un usuario o administrador intento ingresar a cuenta de administrador
                JOptionPane.showMessageDialog(null,"Usuario no tiene privilegios.");
            }
        
        }else{ // No se encontro el nombre de usuario
        
            JOptionPane.showMessageDialog(null,"Usuario no encontrado.");
        }
    }    
    
    /**
     *
     * @param nombre String Nombre de Usuario
     * @param Pin String PIN de Usuario
     * @param choice Integer Recibido de menu de administrador
     */
    public void mostrarAdmin(String nombre, String Pin, int choice){
        
        /*
            Se reciben instruciones desde el frame del menu de usuario y se procesean 
            en este metodo.
        
        */
        cargarDatos();
        Usuario usuario = validarUSER(nombre,Pin); // Regresa datos del usuario
        ConfigParqueo park = validarAjustes(); // Regresa ajustes actuales del parqueo
        int size = parqueo.size();
        
        
        if (usuario != null) { 
            
            if(usuario.Privilegio ==1 || usuario.Privilegio ==2){ // Validacion de privilegios
               
                    switch(choice){
               
                        case 1: // Metodo de configuracion de ajustes del parqueo
                            
                            AjustarPark(); // Configurar el parqueo
                            correo.EnviarAvisoCambioPark(usuario, park); // confirmacion de ajustes
                            JOptionPane.showMessageDialog(null,"Se ha configurado el parqueo.");
                            guardarDatos();
                            break;
                            
                        case 2: // Metodo de reportes para administrador y inspector
                            cargarDatos();
                            
                            
                            PDF.Reporte1(Reporte1()); // Reporte de Ingresos del parqueo
                            PDF.Reporte2(Reporte2()); // Reporte de Ingresos por multas
                            PDF.ReporteAjustesActualesParqueo(park); // Reporte de ajustes actuales del parqueo
                            PDF.ReporteTotalHistorial(mostrarHistorial()); // Historial del parqueo
                            PDF.ReporteHistorialMultas(mostrarMulta()); // Historial de multas
                            PDF.Reporte3(Reporte3(park)); // Reporte de estadisticas de uso y no uso del parqueo
                            PDF.ReporteDataUsuarios(usuario); // Reporte de informacion del usuario
                            
                            JOptionPane.showMessageDialog(null,"Se han generado los reportes.");
                            break;
                       
                            
                        case 3: // Metodo para modificar informacion de usuarios
                            
                            String username = JOptionPane.showInputDialog("Ingrese el nombre de usuario que debe de ser actualizado: ");
                            Usuario user = encontrarUSER(username);
                            ModificacionUser(user);
                            
                            guardarDatos();
                            break;
                            
                            
                        case 4: //  Metodo para eliminar usuario
                            
                            String username1 = JOptionPane.showInputDialog("Ingrese el nombre de usuario que debe de ser eliminado: ");
                            Usuario user1 = encontrarUSER(username1);
                            AdminEliminarUser(user1);
                            guardarDatos();
                            break;
                        
                        case 5: //Reporte Mostrar Todos los Espacios
                            
                            PDF.ReporteTodosParqueo(ReporteTodosParqueo());
                            break;
                        
                        case 6: //Reporte Mostrar solo los ocupaods
                            PDF.ReporteSoloOcupados(mostrarParqueo());
                            break;
                            
                        case 7: //Reporte Mostrar solo espacios vacios
                            PDF.ReporteSoloVacios(ReporteSoloVacios());
                            break;
                                 
                        default:
                            System.out.println("Error!");
                            break;
                    }
                    
            } else { // Credenciales no validas
                JOptionPane.showMessageDialog(null,"Usuario no encontrado.");
              }    
        
        }
    }
    
    /**
     *
     * @param nombre String Nombre de usuario
     * @param Pin String PIN de usuario
     */
    public void MostrarMenuInspector(String nombre, String Pin){ // DISPLAY USUARIO

        // Toma el pin y nombre de usuario
        // Hace un llamado al menu del usuario al ingresar exitosamente sus credenciales 
        
        Usuario usuario = validarUSER(nombre,Pin); // Regresa informacion del usuario
        
        ConfigParqueo park = validarAjustes(); // Regresa ajustes actuales del parqueo
        
        
        if(usuario != null){
            
            if(usuario.Privilegio ==2){
            MenuInspector menIns = new MenuInspector(usuario);
            menIns.setVisible(true);
            menIns.setLocationRelativeTo(null);
            
            }else{ // Un usuario intento ingresar a cuenta de inspector
                JOptionPane.showMessageDialog(null,"Usuario no tiene privilegios.");
            }
        
        }else{
        
            JOptionPane.showMessageDialog(null,"Usuario no encontrado.");
        
        }
        
    }
    
    /**
     *
     * @param nombre String Nombre de usuario
     * @param Pin String PIN de usuario
     * @param choice Integer recibido de MenuInspector
     */
    public void mostrarInsp(String nombre, String Pin,int choice){ 
            
        /*
            Se reciben instruciones desde el frame del menu de usuario y se procesean 
            en este metodo.
        
        */   
        cargarDatos();
        Usuario usuario = validarUSER(nombre,Pin); // Se recibe informacion del usuario
        ConfigParqueo park = validarAjustes(); // Se reciben ajustes actulaes del parqueo
        
        if (usuario != null) {
            
            
            if(usuario.Privilegio ==2){ // privilegio 2 es inspector
                
                    switch(choice){
               
                        case 1: // Revisar parqueo y que muestre que espacios estan pagados
                            String TotalParqueo = mostrarParqueo();
                            JOptionPane.showMessageDialog(null, TotalParqueo);
                            break;
                            
                        case 2: // Reportes (iguales al de Administrador)
                            
                            cargarDatos();
                            
                            
                            PDF.Reporte1(Reporte1()); // Reporte de Ingresos del parqueo
                            PDF.Reporte2(Reporte2()); // Reporte de Ingresos por multas
                            PDF.ReporteAjustesActualesParqueo(park); // Reporte de ajustes actuales del parqueo
                            PDF.ReporteTotalHistorial(mostrarHistorial()); // Historial del parqueo
                            PDF.ReporteHistorialMultas(mostrarMulta()); // Historial de multas
                            PDF.Reporte3(Reporte3(park)); // Reporte de estadisticas de uso y no uso del parqueo
                            PDF.ReporteDataUsuarios(usuario); // Reporte de informacion del usuario
                            
                            JOptionPane.showMessageDialog(null,"Se han generado los reportes.");
                            break;
                       
                        case 3: // Metodo para multar de forma manual
                            
                            // Toma nombre de usuario de persona que debe de ser multada
                            
                            String username = JOptionPane.showInputDialog("Ingrese el nombre de usuario que debe de ser multado: ");
                            Usuario user = encontrarUSER(username);
                            HacerMultaManual(user,park,usuario.nombre,"Multado por el inspector.");
                            guardarDatos();                         
                            
                            break;
                           
                       
                        case 4: // Metodo para mostrar historial de multas 
                            
                            String TotalMultas = mostrarMulta();
                            
                            if (TotalMultas !=""){
                                
                            JOptionPane.showMessageDialog(null, TotalMultas);
                            
                            }else{
                            
                                JOptionPane.showMessageDialog(null, "No hay multas");
                            }
                            break;
                            
                        case 5: // Reporte Mostrar Todos los Espacios
                            PDF.ReporteTodosParqueo(ReporteTodosParqueo());
                            break;
                            
                        case 6: //Reporte Mostrar solo los ocupaods
                            PDF.ReporteSoloOcupados(mostrarParqueo());
                            break;
                            
                        case 7: //Reporte Mostrar solo espacios vacios
                            PDF.ReporteSoloVacios(ReporteSoloVacios());
                            break;         
                            
                        default:
                            System.out.println("Error!");
                            break;
                    }

            } else { // Credenciales no validas
                System.out.println("Usuario no encontrado.");
              }    
        
        }
    }    
    
    /**
     *
     * @param usuario Datos de usuario
     */
    public void ModificacionUser(Usuario usuario){
        
        // Metodo para realizar cambios en informacion de usuaraio
        // Recibe al usuario y regresa cambios en este
        // Al igual que el registro de personas, se valida todos los inputs
        
        int allgood = 0; // Para validar si se cumplen requisitos
        if(usuario != null){
            
            try{
                        
                        String name = JOptionPane.showInputDialog(null,"Ingrese el nombre: ");
                        
                        if(name instanceof String && name.length() >= 2 && name.length() <= 20 ){
            
                           allgood++;
                
                        }else{
                            throw new IllegalArgumentException(" \nFormato Invalido.\n");
                        }     
                        
                        
                        
                        String lastname = JOptionPane.showInputDialog(null,"Ingrese el apellido: ");
                        
                        
                        if(lastname instanceof String && lastname.length() >= 1 && lastname.length() <= 40 ){
            
                            allgood++;
                
                        }else{
                            throw new IllegalArgumentException(" \nFormato Invalido.\n");
                        }             
                        
                        
                        
                        String tel = JOptionPane.showInputDialog(null,"Ingrese el numero de telefono: ");
                        
                        if(tel.matches("\\d{8}")){ // solo 8
                            
                            allgood++;
                        
                        }else{
                            throw new IllegalArgumentException(" \nFormato Invalido.\n");
                        }            

                        if(allgood ==3){ // Si es 3, se procede a realizar cambios
                            
                            usuario.nombre = name;
                            usuario.apellido = lastname;
                            usuario.telefono= Integer.parseInt(tel);
                            JOptionPane.showMessageDialog(null,"Se han actualizado los datos.");
                            correo.CorreoModificaciones(usuario);
                            guardarDatos();
                            
                        }else{
                        
                            JOptionPane.showMessageDialog(null,"No se cumplen los requisitos para actualizar los datos.");
                        }
                       
            }catch(Exception e){
            
                System.out.println("Error de formato");
            }
        
        
        }
        
    }
    
    public void AgregarVech2(Usuario usuario){
    
       String plate = JOptionPane.showInputDialog("Ingrese el numero de placa del segundo vehiculo:");
       

       if(plate instanceof String && plate.length() >= 1 ){ // Min 1 Max 6
                            
            usuario.placa2 = plate;
            usuario.PosicionEstacionado2 = generarStringAleatorio(5);
            guardarDatos();
                               
        }else{
           JOptionPane.showMessageDialog(null,"Valores invalidos!");
       
       }
       
    }
    
    public int SelePlacaUser(Usuario usuario){

        
            if(usuario.placa2 ==null){
            
                return 1;
                
            }else if(usuario.placa2 != null){
        
                String Sel = JOptionPane.showInputDialog("Selecione una placa :"+"1."+ usuario.placa + "  2. " + usuario.placa2);
                
                    if(Sel.equalsIgnoreCase("1")){
                        return 1; 
                                
                    }else if(Sel.equalsIgnoreCase("2")){
                    
                        return 2;
                    }
            }else{
            
                JOptionPane.showMessageDialog(null,"Valores invalidos!");
                return 0;

            }
            
        return 0;
    }
    /**
     *
     */
    public void AjustarPark(){
        
        // Metodo para configurar y iniciar el parqueo
        // Se puede ajustar la primera, segunda hora de no pago, precio por hora, compra minima y precio por multa
        // La primera hora tiene que ser menor a la segund hora de no pago ej: primra hora: 22 segunda hora :24
        // Para la logica del programa utilizar formato de 24 horas
        
        // Regresa la configuracion al array de ajustes
        
        int allgood = 0;
        
        try{
            
             int PrimeraHora = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la primera hora de no pago: ")); 
             
            
             int SegundaHora = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la segunda hora de no pago: "));
             
      
             int PrecioHora = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cuanto se cobra por hora: "));
             
             
             int TiempoMin = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese cuanto es el tiempo minimo de compra: "));
             
             int Multa = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese cuanto se paga por multa: "));
             
             if(SegundaHora>PrimeraHora && PrimeraHora <=24 && SegundaHora <=24){
             
                 allgood++;
             }
             
             if (allgood ==1){
                agregarAjustes(new ConfigParqueo(PrimeraHora,SegundaHora,PrecioHora,TiempoMin,Multa,1));
                guardarDatos();
                
             }else{
             
                 JOptionPane.showMessageDialog(null,"No se cumplen los requisitos!");
             }
        
        }catch(Exception e){ 
        
            JOptionPane.showMessageDialog(null,"Algo salio mal!");
        }
    }
    
    /**
     *
     * @return Regresa la configuracion mas reciente del array de ajustes
     */
    public ConfigParqueo validarAjustes() { // Cicla por los ajustes y regresa la configuracion mas reciente 
        
        /*
            Al ser ajustes un array, cada vez que se configure el parqueo se va a guardar
            nueva informacion. Es por esto que se crea este metodo.
          
            Consigue y retorna la configuracion mas reciente del array de ajustes
        */  
          
         int tam = ajustes.size()-1;
         int i =0;
         
        for (ConfigParqueo park : ajustes) {
             
            if(i == tam){
                return park; // Devuelve el usuario encontrado
            }
            i++;
        }
        return null; // Si no se encuentra ningún usuario con ese nombre
    }
      
    /**
     *
     * @param usuario Datos del usuario
     * @param park Ajustes actuales del parqueo
     */
    public void HacerMultaAutomatica(Usuario usuario, ConfigParqueo park){
        
       // Metodo para hacer y agregar multa al usuario si no se paga por el estacionamiento
       // Se agrega a multas y retorna informacion actualizada
        
        String Inspector = "Automatico";
        String detail = " El usuario no ha pagado por el estacionamiento al parquear el vechiculo.";
        agregarMulta(new RegistroMultas(usuario.nombre, usuario.apellido, usuario.PosicionEstacionado, usuario.placa, usuario.fechaIngreso
        , detail, Inspector,park.CostoMulta));
        correo.EnviarCorreoMulta(usuario, detail, Inspector); // Email de multa
    }
    

    

}
