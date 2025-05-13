package org.example;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.base.JRBaseTextField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase principal para generar un informe utilizando JasperReports.
 * Este programa compila un archivo .jrxml, llena el informe con datos y lo exporta a un archivo PDF.
 */
public class FirstReport {

    /**
     * Método principal que ejecuta el proceso de generación del informe.
     *
     */
    public static void main(String[] args) {

        try {
            // Ruta del archivo .jrxml que define el diseño del informe
            String filePath = "C:\\Users\\emersonpachon\\IdeaProjects\\FirstReport\\src\\main\\resources\\FirstReport.jrxml";

            // Parámetros que se pasarán al informe
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("studentName", "John");

            // Creación de objetos Student con datos de ejemplo
            Student student1 = new Student(1L, "Raj", "Joshi", "Happy Street", "Delhi");
            Student student2 = new Student(2L, "Peter", "Smith", "Any Street", "Mumbai");

            // Lista de estudiantes que se utilizará como fuente de datos
            List<Student> list = new ArrayList<Student>();
            list.add(student1);
            list.add(student2);

            // Fuente de datos basada en la lista de estudiantes
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);

            // Compilación del archivo .jrxml en un objeto JasperReport
            JasperReport report = JasperCompileManager.compileReport(filePath);

            // Llenado del informe con los parámetros y la fuente de datos
            JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
            System.out.println("Llenó el reporte");

            // Exportación del informe lleno a un archivo PDF
            JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\emersonpachon\\IdeaProjects\\Informes Jaspert\\FirstReport.pdf");

            System.out.println("Reporte creado y exportado");

        } catch (Exception e) {
            // Manejo de excepciones: imprime la traza de la excepción en caso de error
            e.printStackTrace();
        }
    }
}