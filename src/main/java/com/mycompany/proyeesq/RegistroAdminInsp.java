/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyeesq;

import java.time.LocalDate;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author XPC
 */

/*
    Frame de interfaz grafica utilizada por el usuario al usar el programa
    
    Al presionar un boton en este frame se hace una invocacion y envia una instruccion
    a la clase de SistemaParqueo. 

    En la clase SistemaParqueo se procesa y guarda toda la informacion.

*/


public class RegistroAdminInsp extends javax.swing.JFrame {


    private final int ModoRegistro;

    /**
     *
     * @param ModoRegistro
     */
    
    public RegistroAdminInsp(int ModoRegistro) { // Modo Registro 1 = admin 2 = Inspector
        initComponents();
        this.ModoRegistro = ModoRegistro;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo1 = new javax.swing.JTextField();
        txtCorreo2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtPin = new javax.swing.JTextField();
        tituloRegistroUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botonRegistro = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        txtCorreo1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCorreo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreo1ActionPerformed(evt);
            }
        });

        txtCorreo2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCorreo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreo2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setText("@");

        txtDireccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtPin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPinActionPerformed(evt);
            }
        });

        tituloRegistroUsuario.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        tituloRegistroUsuario.setText("Registro de Administrador");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Apellido");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Telefono");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Correo Electronico");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Direccion");

        botonRegistro.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        botonRegistro.setText("Registrar");
        botonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistroActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Nombre de Usuario");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("PIN");

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(tituloRegistroUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(botonRegistro))))
                .addContainerGap(126, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(569, Short.MAX_VALUE)
                    .addComponent(botonSalir)
                    .addGap(18, 18, 18))
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(24, 24, 24)
                            .addComponent(txtNombre))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(23, 23, 23)
                            .addComponent(txtApellido))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtDireccion))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtCorreo1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtTelefono))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPin, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtUsuario))))
                            .addGap(43, 43, 43)
                            .addComponent(txtCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(10, 10, 10)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(tituloRegistroUsuario)
                .addGap(182, 182, 182)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(131, 131, 131)
                .addComponent(botonRegistro)
                .addGap(82, 82, 82))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(botonSalir)
                    .addGap(59, 59, 59)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(245, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCorreo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreo1ActionPerformed

    private void txtCorreo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreo2ActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPinActionPerformed

    private void botonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistroActionPerformed
        
        try{
            RegistrarAdmin(); // Funcion de toma de datos
        }catch(Exception e){ // Se validaron los datos pero no cumplen los requisitos.

            JOptionPane.showMessageDialog(null,"No se cumplen los requisitos para el registro.");
        }
        
    }//GEN-LAST:event_botonRegistroActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        
        
        setVisible(false); // Boton de salir
    }//GEN-LAST:event_botonSalirActionPerformed

    /**
     */

     public void RegistrarAdmin(){
     
       SistemaParqueo sistema = new SistemaParqueo(); // clase para registro de datos
        SistemaCorreos correos = new SistemaCorreos(); // clase para el envio de correos
        sistema.cargarDatos(); // cargar datos del .dat
        
        int allgood = 0; // Integer para validar todos los datos, si es igual a 13 se procede
        
        
        /*
            En el siguiente codigo se toma los datos escritos por el usuario y son validados.
            Se utiliza de "instanceof" para validar tipo de dato.
            Se utiliza .length o \\d{numero} para asegurarse del tamaño correcto.
        
        */ 
        
        String name = txtNombre.getText();
        
        
        if(name instanceof String && name.length() >= 2 && name.length() <= 20 ){ // Min 2 Max 20
            
        allgood++;
                
        } 
        
        String nombre = name;
        
        /////
        String lastname = txtApellido.getText();
        
        
        if(lastname instanceof String && lastname.length() >= 1 && lastname.length() <= 40 ){ //Min 1 Max 40
            
        allgood++;
                
        } 
        
        String apellido = lastname;  
        /////
        
        String tel = txtTelefono.getText();
        
        
        if(tel.matches("\\d{8}")){ // Integer de justamente 8 numeros.
            
        allgood++;
                
        } 
        
        int telefono = Integer.parseInt(tel);
        /////
        
        String CorreoP1, CorreoP2;
        CorreoP1 = txtCorreo1.getText();
        CorreoP2 = txtCorreo2.getText();
        
        String mail = CorreoP1+"@"+CorreoP2; // Se unen ambas partes para el correo
        
        
        if(mail instanceof String && mail.length() >= 3 && mail.length() <= 40 ){ // Min 3 Max 40
            
        allgood++;
                
        } 
        
        String correoElectronico = mail;
        /////
        
        String adr = txtDireccion.getText();
        
        
        if(adr instanceof String && adr.length() >= 5 && mail.length() <= 60 ){ // Min 5 Max 60
            
        allgood++;
                
        } 
        
        String direccion = adr;
        /////
        
        LocalDate fechaIngreso = LocalDate.now();
        allgood++;
        
        /////
        
        String username = txtUsuario.getText();
        
        
        if(username instanceof String && username.length() >= 2 && username.length() <= 50){ // Min 2 Max 50
            
        allgood++;
                
        } 
        
        String nombreUsuario = username;
        /////
        
        String p = txtPin.getText();
        
        if(p instanceof String && p.length() == 4){ // String de justo 4 caracteres
            
        allgood++;
                
        }
        String pin = p;
        
        
        /*
            Al administrador y inspector no se le piden los demas datos por lo que 
            se rellenan automaticamente para poder reutilizar el codigo para
            agregar usuarios al sistema.
        */
        
        
        String card = "1234567890123456";
        
        if(card.matches("\\d{16}")){
                            
            allgood++;
                               
        }       
        
        long NumTarjeta = Long.parseLong(card);
        /////
        
        
        String ExDate = "0000";
        
        if(ExDate instanceof String ){
            
            allgood++;
                
        }
        String ExpDate = ExDate;
        
        /////
        
        String cv = "123";
        
        if(card.matches("\\d{3}")){
                            
            allgood++;
                               
        }
        
        int cvc = Integer.parseInt(cv);
        /////
        
        String plate = "00000";
        
        if(plate instanceof String && plate.length() >= 1 && username.length() <= 6){
                            
            allgood++;
                               
        }
        
        String Placa = plate;
        
        /////
        
        String make = "0000";
        
        if(make instanceof String && make.length() >= 0 && make.length() <= 15){
                            
            allgood++;
                               
        }

        String Marca = make;
        /////
        
        String model = "0000";
        
        if(model instanceof String && model.length() >= 0 && model.length() <= 15){
                            
            allgood++;
                               
        }
        String Modelo = model;
        
        String EspacioPark = generarStringAleatorio(5);
        
        
        if(allgood==13){
                
            if(ModoRegistro == 1){ // Registro de administrador
                
                    sistema.agregarUsuario(new Usuario(nombre,apellido,telefono,correoElectronico,direccion,
                                               fechaIngreso,nombreUsuario, pin, NumTarjeta,ExpDate,cvc,Placa,Marca,Modelo, 0, false,1,EspacioPark));
        
                    sistema.guardarDatos(); // Se guardan el usuario
                    correos.EnviarConfCreacion(correoElectronico); // Email de confirmacion
                    JOptionPane.showMessageDialog(null, "Se ha registrado al Administrador "+ nombre);
                    setVisible(false);
                    
            }else if(ModoRegistro == 2){ // Registro de inspector
            
                    sistema.agregarUsuario(new Usuario(nombre,apellido,telefono,correoElectronico,direccion,
                                               fechaIngreso,nombreUsuario, pin, NumTarjeta,ExpDate,cvc,Placa,Marca,Modelo, 0, false,2,EspacioPark));
        
                    sistema.guardarDatos();// Se guardan el usuario
                    correos.EnviarConfCreacion(correoElectronico);// Email de confirmacion
                    JOptionPane.showMessageDialog(null, "Se ha registrado al Inspector "+ nombre);
                    setVisible(false); 
                    
                    
            }
        
        }else{ // Datos validados no cumplen con requisitos
        
            JOptionPane.showMessageDialog(null, "No se cumplen los requisitos de registro.");
        }     
     
     
     }
     
    /**
     *
     * @param longitud
     * @return
     */
    public static String generarStringAleatorio(int longitud) { // Funcion para generar Strings aletorios
       
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(longitud);

        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(letras.length());
            sb.append(letras.charAt(indice));
        }
        
        return sb.toString();
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistro;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel tituloRegistroUsuario;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo1;
    private javax.swing.JTextField txtCorreo2;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPin;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
