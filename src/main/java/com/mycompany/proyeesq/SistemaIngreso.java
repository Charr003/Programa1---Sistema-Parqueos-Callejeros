/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyeesq;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
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

/*
    Frame utilizado para el inicio del programa, registro y ingreso de usuarios.
    Adicionalmente tambien se puede utilizar la funcion de Nuevo Pin para todos.

*/

public class SistemaIngreso extends javax.swing.JFrame {
    

    SistemaParqueo sistema = new SistemaParqueo(); // Clase donde se encuentran todas las funciones
    
    /**
     * Creates new form SistemaIngreso
     */

    public SistemaIngreso() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        txtContra = new javax.swing.JTextField();
        botonIngreso = new javax.swing.JButton();
        botonRegistro = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        CajaSelec = new javax.swing.JComboBox<>();
        Titulo2 = new javax.swing.JLabel();
        botonOlvidePin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombre.setText("Usuario");

        txtContra.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtContra.setText("Contraseña");

        botonIngreso.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonIngreso.setText("Ingresar");
        botonIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresoActionPerformed(evt);
            }
        });

        botonRegistro.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonRegistro.setText("Registro");
        botonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistroActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        titulo.setText("Sistema de Ingreso al Parqueo");

        CajaSelec.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        CajaSelec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Administrador", "Inspector", " " }));
        CajaSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CajaSelecActionPerformed(evt);
            }
        });

        Titulo2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        Titulo2.setText("Ingresar / Registrarse como:");

        botonOlvidePin.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonOlvidePin.setText("Olvide Mi PIN");
        botonOlvidePin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOlvidePinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(131, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Titulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CajaSelec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(95, 95, 95)
                .addComponent(botonIngreso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonRegistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonOlvidePin, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(Titulo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CajaSelec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonIngreso)
                    .addComponent(botonRegistro)
                    .addComponent(botonOlvidePin))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresoActionPerformed
        
        
        // LOGIN
        sistema.cargarDatos(); // cargar la informacion en el .dat
        
        if(CajaSelec.getSelectedItem().equals("Usuario")){

            String bnombre = txtNombre.getText();
            String bpin = txtContra.getText();
            sistema.MostrarMenuUsuario(bnombre, bpin); // Se toma las credenciales del usuario para su ingreso

        }
        else if(CajaSelec.getSelectedItem().equals("Administrador")){
            
            String bnombre = txtNombre.getText();
            String bpin = txtContra.getText();
            sistema.MostrarMenuAdmin(bnombre, bpin); // Se toma las credenciales del usuario para su ingreso        
        }
        else if(CajaSelec.getSelectedItem().equals("Inspector")){
            
            String bnombre = txtNombre.getText();
            String bpin = txtContra.getText();
            sistema.MostrarMenuInspector(bnombre, bpin); // Se toma las credenciales del usuario para su ingreso             
            
        }
        
    }//GEN-LAST:event_botonIngresoActionPerformed

    private void botonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistroActionPerformed
        
        
        // REGISTER
        sistema.cargarDatos(); // Carga de datos del .dat
        
        if(CajaSelec.getSelectedItem().equals("Usuario")){

            RegistroUsuario registroUser = new RegistroUsuario();
            
            registroUser.setVisible(true);
            registroUser.setLocationRelativeTo(null);

        }
        else if(CajaSelec.getSelectedItem().equals("Administrador")){
            
            int Modo = 1; // Integer para diferenciar entre Administrador y Inspector
            RegistroAdminInsp registroAdmin = new RegistroAdminInsp(Modo);
            
            registroAdmin.setVisible(true);
            registroAdmin.setLocationRelativeTo(null);            
            
        
        }
        else if(CajaSelec.getSelectedItem().equals("Inspector")){
            
            // Los Administradores solo pueden registrar a Inspectores desde su menu al ingresar.
            JOptionPane.showMessageDialog(null, "No se puede registrar");
        }
    }//GEN-LAST:event_botonRegistroActionPerformed

    private void CajaSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CajaSelecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CajaSelecActionPerformed

    private void botonOlvidePinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOlvidePinActionPerformed
        
        
        /*
            Funcion de nuevo PIN en caso de que se haya perdido.
            Si se encuentra el usuario se manda un corrreo con el PIN
        */
                String USnombre = JOptionPane.showInputDialog("Ingrese el Usuario");
                sistema.NuevoPIN(USnombre);              
                sistema.guardarDatos();
        
    }//GEN-LAST:event_botonOlvidePinActionPerformed

    /**
     */
 public void RegistroUser(){
       
           RegistroUsuario regis = new RegistroUsuario(); // Frame de registro de solo usuarios
           regis.setVisible(true);
           regis.setLocationRelativeTo(null);
       
       }

    /**
     *
     * @param longitud
     * @return
     */
    public static String generarStringAleatorio(int longitud) { // Funcion para generacion aletoria de Strings
                                                                   // Utilizado en la creacion de PINs
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(longitud);

        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(letras.length());
            sb.append(letras.charAt(indice));
        }
        
        return sb.toString();
    }
    
        public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SistemaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaIngreso().setVisible(true);  
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CajaSelec;
    private javax.swing.JLabel Titulo2;
    private javax.swing.JButton botonIngreso;
    private javax.swing.JButton botonOlvidePin;
    private javax.swing.JButton botonRegistro;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtContra;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
