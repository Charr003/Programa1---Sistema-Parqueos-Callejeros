/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyeesq;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.proyeesq.SistemaParqueo.RegistroParqueo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

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
    Clase que es utilizada para generar reportes en formato PDF
    al usuario y administradores

    El reporte en general se genera en la clase de SistemaParqueo
    pero aqui se convierte en el formato deseado.

*/




public class SistemaPDF {
    
    /**
     *
     * @param usuario Datos de usuario
     */
    public void ReporteDataUsuarios(Usuario usuario){
        
        // Toma los datos del usuario
        // Reporte que regresa toda la informacion del usuario actual.
        
        
        String pdfFileName = "Reporte "+usuario.nombreUsuario+".pdf";
        //String pdfFileName = "Reporte.pdf";
        Document document = new Document();
        
         try {
            
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));

            // Abrir el documento para escribir
            document.open();

            // Agregar el texto como un párrafo
            document.add(new Paragraph("Nombre: " + usuario.nombre + " " + usuario.apellido
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
            +"\nNumero de PIN: " + usuario.pin    
            ));

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }
    }
    
    /**
     *
     * @param EspacioDisponible Integer Tamaño de array de parqueo
     */
    public void ReporteEspaciosDisponibles(int EspacioDisponible){
        
        // Reporte que toma el espacio del array de parqueos y devuelve 
        // cuantos espacios hay disponibles al usuario.
        
        
        String pdfFileName = "ReporteEspacioDisponible.pdf";
        Document document = new Document();
        
         try {
            
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));

            // Abrir el documento para escribir
            document.open();

            // Agregar el texto como un párrafo
            
            document.add(new Paragraph("Reporte de Espacios Disponible en el Parqueo"));
            
            for(int i= 0; i<EspacioDisponible; i++){
            
                document.add(new Paragraph("\n=========================== "
                                          +"\nDisponible: Parqueo Nº 0000"+i
                                          +"\nPlaca: "
                                          +"\nVehiculo: "
                                          +"\n=========================== "));
           
            }

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }
    }
    
    /**
     *
     * @param history String Reporte de Historial de usuario unico
     * @param usuario Datos de usuario
     */
    public void ReporteHistorialUsuario(String history, Usuario usuario){
        
        // Toma array de historial y datos de usuario
        // Reporte para regresar el historial de parqueo al usuario
        
        
        String pdfFileName = "ReporteHistorialUsuario.pdf";
        Document document = new Document();
        
         try {
            
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));

            // Abrir el documento para escribir
            document.open();

            // Agregar el texto como un párrafo
            
            document.add(new Paragraph("Reporte de Historial en el Parqueo"+
                                       "\nUsuario: "+ usuario.nombreUsuario+"\n"));
            
            document.add(new Paragraph(history));

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
             
            // Cerrar el documento
            document.close();
        }        
    
    }
    
    /**
     *
     * @param multas String Reporte de multas General
     */
    public void ReporteMultaGeneral(String multas){
        
        // Toma el array de multas
        // Reporte que regresa todas las multas del parqueo
        
        
        String pdfFileName = "ReporteMultaGeneral.pdf";
        Document document = new Document();
        
         try {
            
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));

            // Abrir el documento para escribir
            document.open();

            // Agregar el texto como un párrafo
            
            document.add(new Paragraph("Reporte de Multas General\n"));
            
            document.add(new Paragraph(multas));

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
             
            // Cerrar el documento
            document.close();
        }        
    
    }
    
    /**
     *
     * @param park Datos de ajustes de parqueo actual
     */
    public void ReporteAjustesActualesParqueo(ConfigParqueo park){
        
        // Toma la configuracion actual del parqueo
        // Retorna un reporte de los ajustes 
        
        String pdfFileName = "ReporteAjustesActuales.pdf";
        Document document = new Document();
        
         try {
            
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));

            // Abrir el documento para escribir
            document.open();

            // Agregar el texto como un párrafo
            
            document.add(new Paragraph("Reporte de Ajustes Actuales:"+
                                       "\n\nPrimer Hora No Pagada: "+ park.PrimerHoraNoPagda
                                     + "\n Segunda Hora No Pagada: "+park.SegundaHoraNoPagda
                                     + "\n Precio por Hora: " + park.PrecioHora
                                     + "\n Timepo Minimo de Compra: " + park.TiempoMinimo
                                     + "\n Costo de la Multa: " + park.CostoMulta
                                     + "\n Iniciado: " + park.iniciado ));
            
            

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }         
    
    }
    
    /**
     *
     * @param reporte1 String Reporte de ingresos por espacio de parqueo
     */
    public void Reporte1(String reporte1){
        
        // Retorna el reporte de Ingresos por estacionamiento
        
        
        String pdfFileName = "Reporte1.pdf";
        Document document = new Document();
        
         try {
            
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));

            // Abrir el documento para escribir
            document.open();

            // Agregar el texto como un párrafo
            
            document.add(new Paragraph(reporte1));

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }  
    
    }

    /**
     *
     * @param reporte2 String Reporte de Ingresos por multas
     */
    public void Reporte2(String reporte2){
        
        // Retorna el reporte de Ingresos por multas
    
        String pdfFileName = "Reporte2.pdf";
        Document document = new Document();
        
         try {
            
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));

            // Abrir el documento para escribir
            document.open();

            // Agregar el texto como un párrafo
            
            document.add(new Paragraph(reporte2));

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }  
    }
    
    /**
     *
     * @param Todos String Reporte todos los espacios en el parqueo
     */
    public void ReporteTodosParqueo(String Todos){
        
        // Retorna reporte de todos los espacios disponibles en el parqueo
    
        String pdfFileName = "MostrarTodosLosEspacios.pdf";
        Document document = new Document();
        
         try {
            
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));

            // Abrir el documento para escribir
            document.open();

            // Agregar el texto como un párrafo
            
            document.add(new Paragraph(Todos));

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }  
    
    
    }

    /**
     *
     * @param Ocupados String Reporte de espacios ocupados 
     */
    public void ReporteSoloOcupados(String Ocupados){
        
        // Retorna solo los espacios ocupados en el parqueo
    
        String pdfFileName = "MostrarSoloLosOcupados.pdf";
        Document document = new Document();
        
         try {
            
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));

            // Abrir el documento para escribir
            document.open();

            // Agregar el texto como un párrafo
            
            document.add(new Paragraph(Ocupados));

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }  
    
    
    }

    /**
     *
     * @param vacios Reporte de espacios vacios
     */
    public void ReporteSoloVacios(String vacios){
        
        // Retorna solo los espacios vacios en el parqueo
    
        String pdfFileName = "MostrarSoloLosVacios.pdf";
        Document document = new Document();
        
         try {
            
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));

            // Abrir el documento para escribir
            document.open();

            // Agregar el texto como un párrafo
            
            document.add(new Paragraph(vacios));

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }  
    
    
    }
    
    /**
     *
     * @param TotalHistorial String Reporte historial completo de parqueo
     */
    public void ReporteTotalHistorial(String TotalHistorial){
        
        // Retorna un reporte del historial completo del parqueo
    
        String pdfFileName = "MostrarHistorial.pdf";
        Document document = new Document();
        
         try {
            
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));

            // Abrir el documento para escribir
            document.open();

            // Agregar el texto como un párrafo
            
            document.add(new Paragraph(TotalHistorial));

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }  
    
    }
    
    /**
     *
     * @param TotalMultas String Reporte completo de multas
     */
    public void ReporteHistorialMultas(String TotalMultas){
        
        // Retorna un reporte del historial completo de multas del parqueo
    
        String pdfFileName = "MostrarHistorialMultas.pdf";
        Document document = new Document();
        
         try {
            
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));

            // Abrir el documento para escribir
            document.open();

            // Agregar el texto como un párrafo
            
            document.add(new Paragraph(TotalMultas));

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }  
    
    }

    /**
     *
     * @param Uso String Porcentaje de Uso y no uso del parqueo
     */
    public void Reporte3(String Uso){
        
        
        // Retorna un reporte del porcentaje de uso y no de los espacios del parqueo
        
        String pdfFileName = "Reporte3.pdf";
        Document document = new Document();
        
         try {
            
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));

            // Abrir el documento para escribir
            document.open();

            // Agregar el texto como un párrafo
            
            document.add(new Paragraph(Uso));

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }  
    
    } 
    
    /**
     *
     * @param multa String Multas usuario
     */
    public void MultasUsuario(String multa){
    
        // Retorna un reporte de las multa a nombre del usuario
        
        String pdfFileName = "MultasUsuario.pdf";
        Document document = new Document();
        
         try {
            
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));

            // Abrir el documento para escribir
            document.open();

            // Agregar el texto como un párrafo
            
            document.add(new Paragraph(multa));

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }  
    
    }
    
}
