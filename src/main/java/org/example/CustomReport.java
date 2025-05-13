package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Clase principal para generar un informe personalizado utilizando JasperReports.
 * Este programa compila un archivo .jrxml, llena el informe con datos y lo exporta a un archivo PDF.
 */
public class CustomReport {

    /**
     * Método principal que ejecuta el proceso de generación del informe.
     *
     */
    public static void main(String[] args) {

        try {
            // Ruta del archivo .jrxml que define el diseño del informe
            String filePath = "C:\\Users\\emersonpachon\\IdeaProjects\\FirstReport\\src\\main\\resources\\CustomReport.jrxml";
            // Ruta donde se exportará el informe generado en formato PDF
            String reportPath = "C:\\Users\\emersonpachon\\IdeaProjects\\Informes Jaspert\\CustomReport.pdf";

            // Creación de objetos Subject con datos de ejemplo
            Subject subject1 = new Subject("Matematicas", 90L);
            Subject subject2 = new Subject("Español", 80L);
            Subject subject3 = new Subject("Ingles", 70L);
            Subject subject4 = new Subject("Ciencias", 60L);
            Subject subject5 = new Subject("Historia", 50L);

            // Lista de materias que se utilizará como fuente de datos
            List<Subject> list = new ArrayList<>();
            list.add(subject1);
            list.add(subject2);
            list.add(subject3);
            list.add(subject4);
            list.add(subject5);

            // Fuente de datos basada en la lista de materias
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);

            // Fuente de datos para gráficos basada en la misma lista
            JRBeanCollectionDataSource chartDataSource = new JRBeanCollectionDataSource(list);

            // Parámetros que se pasarán al informe
            Map<String, Object> parameters= new HashMap<>();
            parameters.put("studentName", "Emerson");
            parameters.put("tableData",dataSource);
            parameters.put("subReport", getSubReport());
            parameters.put("subDataSource", getSubDataSource());
            parameters.put("subParameters", getSubParameters());

            // Compilación del archivo .jrxml en un objeto JasperReport
            JasperReport report = JasperCompileManager.compileReport(filePath);


            JasperPrint print = JasperFillManager.fillReport(report,parameters,chartDataSource);

            // Exportación del informe lleno a un archivo PDF
            JasperExportManager.exportReportToPdfFile(print, reportPath);
            System.out.println("Reporte creado y exportado");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Método para obtener un subreporte compilado.
     *
     * @return JasperReport El subreporte compilado.
     */
    public static JasperReport getSubReport(){
        // Ruta del archivo .jrxml que define el diseño del subreporte
        String filePath = "C:\\Users\\emersonpachon\\IdeaProjects\\FirstReport\\src\\main\\resources\\FirstReport.jrxml";

        JasperReport report;
        try {
            // Compilación del archivo .jrxml en un objeto JasperReport
            return report = JasperCompileManager.compileReport(filePath);

        } catch (JRException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Método para obtener la fuente de datos del subreporte.
     *
     * @return JRBeanCollectionDataSource Fuente de datos basada en una lista de estudiantes.
     */
    public static JRBeanCollectionDataSource getSubDataSource(){
        // Creación de objetos Student con datos de ejemplo
        Student student1 = new Student(1L, "Raj", "Joshi", "Happy Street", "Delhi");
        Student student2 = new Student(2L, "Peter", "Smith", "Any Street", "Mumbai");

        // Lista de estudiantes que se utilizará como fuente de datos
        List<Student> list = new ArrayList<Student>();
        list.add(student1);
        list.add(student2);

        // Fuente de datos basada en la lista de estudiantes
        JRBeanCollectionDataSource dataSource =
                new JRBeanCollectionDataSource(list);

        return dataSource;
    }

    /**
     * Método para obtener los parámetros del subreporte.
     *
     * @return Map<String, Object> Mapa de parámetros para el subreporte.
     */
    public static Map<String, Object> getSubParameters() {
        // Parámetros que se pasarán al subreporte
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("studentName", "Emerson");
        return parameters;
    }
}