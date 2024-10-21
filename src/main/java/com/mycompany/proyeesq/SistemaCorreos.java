/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyeesq;


import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
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

public class SistemaCorreos {
    
    /*
        Clase para la creacion de correos y envio de correos electronicos.
        Se utiliza para enviar datos al usuario como el numero PIN ademas
        de notificar cambios en su cuenta.
    */

    /**
     *
     * @param fromEmail String Correo Electronico del sistema
     * @param password String Contraseña del correo del sistema
     * @param toEmail String Correo destino
     * @param subject String Titular del correo
     * @param messageBody String Cuerpo del correo
     * @throws Exception Catch
     */

    
    public static void sendEmail(String fromEmail, String password, String toEmail, String subject, String messageBody) throws Exception {
        
        // Validar los inputs
        if (fromEmail == null || !fromEmail.contains("@")) {
            throw new IllegalArgumentException("Correo del remitente inválido");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Contraseña inválida");
        }
        if (toEmail == null || !toEmail.contains("@")) {
            throw new IllegalArgumentException("Correo del destinatario inválido");
        }
        
        // Configurar las propiedades de conexion
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Autenticacion
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Crear el mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(messageBody);

            // Enviar el mensaje
            Transport.send(message);
            System.out.println("Correo enviado correctamente");

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al enviar el correo");
        }
    }
    
    /**
     *
     * @param usuario Datos del usuario
     */
    public void EnviarCorreoInfoUser(Usuario usuario){
            
            // Toma los datos del usuario
        
            // Metodo para enviar confirmacion de datos al usuario
            // al crear su cuenta en el sistema
            
            // En este metodo se toma en cuenta si es usuario
            // o administrador para no enviar informacion
            // inecesaria.
            
            
         try {
             
            String fromEmail = "parksysp11@gmail.com"; // Reemplaza con tu correo
            String password = "nvei wqaw cugk qtvf"; // Reemplaza con tu contraseña
            String toEmail = usuario.correoElectronico; // Correo del destinatario
            String subject = "Registro de Nuevo Usuario";
            String messageBody = "";
            
        if(usuario.Privilegio ==0){ // Si es usuario    
            messageBody = " Se ha registrado correctamente al siguiente usuario " + "\nNombre: " + usuario.nombre + " " + usuario.apellido
            +"\nTeléfono: " + usuario.telefono
            +"\nCorreo Electrónico: " + usuario.correoElectronico
            +"\nDirección: " + usuario.direccion
            +"\nFecha de Ingreso: " + usuario.fechaIngreso
            +"\nNombre de Usuario: " + usuario.nombreUsuario
            +"\nMonto a Pagar: " + usuario.montoAPagar
            +"\nNumero de Tarjeta: " + usuario.NumTarjeta
            +"\nNumero de Placa: " + usuario.placa
            +"\nMarca de Vechiculo: " + usuario.marca
            +"\nModelo de Vechiculo: " + usuario.modelo
            +"\nNumero de PIN: " + usuario.pin;
            
        }else{ // Si es administrador o inspector
        
            messageBody = " Se ha registrado correctamente al siguiente usuario " + "\nNombre: " + usuario.nombre + " " + usuario.apellido
            +"\nTeléfono: " + usuario.telefono
            +"\nCorreo Electrónico: " + usuario.correoElectronico
            +"\nDirección: " + usuario.direccion
            +"\nFecha de Ingreso: " + usuario.fechaIngreso
            +"\nNombre de Usuario: " + usuario.nombreUsuario
            +"\nNumero de PIN: " + usuario.pin;                    
        
        }    

            sendEmail(fromEmail, password, toEmail, subject, messageBody);

        } catch (IllegalArgumentException e) {
            System.out.println("Error en los parámetros: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }   
    
    }
    
    /**
     *
     * @param usuario Datos del usuario
     */
    public void EnviarCorreoPIN(Usuario usuario){
        
        // Toma datos del usuario
        // Usada por el metodo de cambiarPIN en el frame de SistemaIngreso
        // Una vez encontrado el usuario se envia el nuevo PIN al correo electronico
        
        try {
            String fromEmail = "parksysp11@gmail.com"; // Reemplaza con tu correo
            String password = "nvei wqaw cugk qtvf"; // Reemplaza con tu contraseña
            String toEmail = usuario.correoElectronico; // Correo del destinatario
            String subject = "Cambio del PIN";
            
            
            String messageBody = " Estimado usuario " + usuario.nombreUsuario +"\n\nSe ha generado un nuevo PIN para el inicio de seccion."
                    + "\nEl nuevo PIN es: " +usuario.pin;

            sendEmail(fromEmail, password, toEmail, subject, messageBody);

        } catch (IllegalArgumentException e) {
            System.out.println("Error en los parámetros: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     *
     * @param usuario Datos del usuario
     * @param park Datos del ajuste del parqueo
     */
    public void EnviarAvisoCambioPark(Usuario usuario, ConfigParqueo park){
        
        // Toma datos del usuario y ajustes actuales del parqueo
        
        // Cada vez que el administrador haga un cambio en los 
        // ajustes del parqueo, se genera un correo electronico
        // para notificar los cambios.
        // Se despliegan todos los ajustes del parqueo
        
        try {
            String fromEmail = "parksysp11@gmail.com"; // Reemplaza con tu correo
            String password = "nvei wqaw cugk qtvf"; // Reemplaza con tu contraseña
            String toEmail = usuario.correoElectronico; // Correo del destinatario
            String subject = "Cambio Ajustes del Parqueo";
            
            
            String messageBody = " Estimado usuario " + usuario.nombreUsuario +"\n\nSe ha generado una nueva configuracion para el parqueo."
                    + "\nNueva Primera Hora de No Pago: " +park.PrimerHoraNoPagda
                    + "\nNueva Segunda Hora de No Pago: " +park.SegundaHoraNoPagda
                    + "\nNuevo Precio por Hora : " +park.PrecioHora
                    + "\nNuevo Tiempo Minimo : " +park.TiempoMinimo
                    + "\nNuevo Costo de Multa : " +park.CostoMulta;

            sendEmail(fromEmail, password, toEmail, subject, messageBody);

        } catch (IllegalArgumentException e) {
            System.out.println("Error en los parámetros: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     *
     * @param correo String Correo destino
     */
    public void EnviarConfCreacion(String correo){
        
            // Toma los datos del correo del usuario
            // Al crear el usuario en el sistema, se envia una
            // notificacion al correo como confirmacion.
    
            try {
            String fromEmail = "parksysp11@gmail.com"; // Reemplaza con tu correo
            String password = "nvei wqaw cugk qtvf"; // Reemplaza con tu contraseña
            String toEmail = correo; // Correo del destinatario
            String subject = "Confirmacion de Cuenta";
            
            
            String messageBody = "Se ha creado exitosamente su perfil en sistema de parqueo.";

            sendEmail(fromEmail, password, toEmail, subject, messageBody);

        } catch (IllegalArgumentException e) {
            System.out.println("Error en los parámetros: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     *
     * @param usuario Datos del usuario
     * @param horasAntes Integer horas anteriormente adquiridas
     */
    public void EnviarConfMasHoras(Usuario usuario, int horasAntes){
        
        // Toma los datos de usuario y las horas adquiridas previamente por el
        
        // Cada  vez que el usuario haga una transaccion por mas horas o 
        // un cambio de horas al parquearse, se genera un correo de notificacion
        // con las horas nuevas y con las horas anteriores.
        
       try {
            String fromEmail = "parksysp11@gmail.com"; // Reemplaza con tu correo
            String password = "nvei wqaw cugk qtvf"; // Reemplaza con tu contraseña
            String toEmail = usuario.correoElectronico; // Correo del destinatario
            String subject = "Confirmacion de Transacción de Mas Horas";
            
            
            String messageBody = "Usuario "+ usuario.nombre
                               +"\nSe ha hecho processado exitosamente la transacción de mas horas en el parqueo"
                               +"\nHoras Anteriormente: "+ horasAntes
                               +"\nHoras Nuevas: "+usuario.horasEstacionado;
            

            sendEmail(fromEmail, password, toEmail, subject, messageBody);

        } catch (IllegalArgumentException e) {
            System.out.println("Error en los parámetros: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }        
    
    
    }

    /**
     *
     * @param usuario Datos del usuario
     * @param park Datos ajuste acutales del parqueo
     */
    public void EnviarConfDesaparcar(Usuario usuario, ConfigParqueo park){
       // Toma datos del usuario y ajustes actuales del parqueo
       
       // Cada vez que el usuario use la funcion de desaparcar del parqueo
       // se genera una funcion para notificarle sobre el evento.
       
       try {
            String fromEmail = "parksysp11@gmail.com"; // Reemplaza con tu correo
            String password = "nvei wqaw cugk qtvf"; // Reemplaza con tu contraseña
            String toEmail = usuario.correoElectronico; // Correo del destinatario
            String subject = "Confirmacion al Desparcar";
            
            
            String messageBody =" Usuario "+ usuario.nombre
                               +"\nHa desparqueado su vehiculo del parqueo."
                               +"\nPlaca: "+ usuario.placa
                               +"\nHoras Estacionado: "+usuario.horasEstacionado
                               +"\nTotal a pagar: "+usuario.montoAPagar
                               +"\nPrecio de Multa: " +park.CostoMulta
                               +"\nMulta: "+(usuario.multa ? "Sí" : "No");
                               
            sendEmail(fromEmail, password, toEmail, subject, messageBody);

        } catch (IllegalArgumentException e) {
            System.out.println("Error en los parámetros: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }        
    
    
    }
    
    /**
     *
     * @param usuario Datos de usuario
     * @param Detalles String Detalles de multa
     * @param NomInspector String Nombre de inspector
     */
    public void EnviarCorreoMulta(Usuario usuario, String Detalles, String NomInspector){
        
        //Toma los datos del usuario, string de detalles y el nombre de inspector
        
        // Es utilizado cuando es multa automaticamente o manualmente por el inspector
        // Se notifica al usuario afectado y se le da a conocer el monto de la multa
        // y la actualizacion de sus datos
    
       try {
            String fromEmail = "parksysp11@gmail.com"; // Reemplaza con tu correo
            String password = "nvei wqaw cugk qtvf"; // Reemplaza con tu contraseña
            String toEmail = usuario.correoElectronico; // Correo del destinatario
            String subject = "Ha recibido una multa";
            
            
            String messageBody =" Usuario "+ usuario.nombre
                               +"\n"
                               +"\nPlaca: "+ usuario.placa
                               +"\nHoras Estacionado: "+usuario.horasEstacionado
                               +"\nTotal a pagar: "+usuario.montoAPagar
                               +"\nNombre de Inspector: "+ NomInspector
                               +"\nDetalles: "+ Detalles
                               +"\nMulta: "+(usuario.multa ? "Sí" : "No");
                               
            sendEmail(fromEmail, password, toEmail, subject, messageBody);

        } catch (IllegalArgumentException e) {
            System.out.println("Error en los parámetros: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }   
    
    }
    
    /**
     *
     * @param usuario Datos del usuario
     */
    public void CorreoModificaciones(Usuario usuario){
        
        // Toma los datos de usuario
        
        // Cada vez que se haga una modificacion dentro de la cuenta
        // de algun usuario se le notifica del cambio.
    
       try {
            String fromEmail = "parksysp11@gmail.com"; // Reemplaza con tu correo
            String password = "nvei wqaw cugk qtvf"; // Reemplaza con tu contraseña
            String toEmail = usuario.correoElectronico; // Correo del destinatario
            String subject = "Cambios en su cuenta";
            
            
            String messageBody ="\n Se han realizado cambios en su cuenta.";
                               
            sendEmail(fromEmail, password, toEmail, subject, messageBody);

        } catch (IllegalArgumentException e) {
            System.out.println("Error en los parámetros: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }   
    
    }    
    
         
}
