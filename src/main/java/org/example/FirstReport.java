package org.example;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.base.JRBaseTextField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FirstReport {
    public static void main(String[] args) {

        try {

            String filePath = "C:\\Users\\emersonpachon\\IdeaProjects\\FirstReport\\src\\main\\resources\\report.jrxml";
            String reportPath = "C:\\Users\\emersonpachon\\IdeaProjects\\Informes Jaspert\\FirstReport.pdf";


            /***
             * Student student1 = new Student(1L, "Juan", "Pachon", "Calle 1", "Medellin");
             *             Student student2 = new Student(2L, "Erika", "Pachon", "Calle 2", "Bogota");
             *
             *             File file = new File(filePath);
             *             if (!file.exists()) {
             *                 System.out.println("El archivo no existe: " + filePath);
             *                 return;
             *             }
             *
             *             List<Student> list = new ArrayList<>();
             *             list.add(student1);
             *             list.add(student2);***/

            Subject subject1 = new Subject("Matematicas", 90L);
            Subject subject2 = new Subject("Español", 80L);
            Subject subject3 = new Subject("Ingles", 70L);
            Subject subject4 = new Subject("Ciencias", 60L);
            Subject subject5 = new Subject("Historia", 50L);

            List<Subject> list = new ArrayList<>();

            list.add(subject1);
            list.add(subject2);
            list.add(subject3);
            list.add(subject4);
            list.add(subject5);



            // Crea un datasource de estudiantes
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
            JRBeanCollectionDataSource chartDataSource = new JRBeanCollectionDataSource(list);
            Map<String, Object> parameters= new HashMap<>();
            parameters.put("studentName", "Emerson");
            parameters.put("tableData",dataSource);
            // Carga el archivo JRXML y compílalo
            JasperReport report = JasperCompileManager.compileReport(filePath);
            /**
             * // Establece el color del texto del campo "name" a rojo
             *             JRBaseTextField textField = (JRBaseTextField) report.getTitle().getElementByKey("name");
             *             textField.setForecolor(Color.RED);
             *             //gguarda en la varialble el reporte, parametros y el dataSource**/
            JasperPrint print = JasperFillManager.fillReport(report,parameters,chartDataSource);

            // Exporta el reporte a PDF
            JasperExportManager.exportReportToPdfFile(print, reportPath);
            System.out.println("Report generated successfully!");


        } catch (Exception e) {
            //TIP To <b>Debug</b> code, press <shortcut actionId="Debug"/> or
            // click the <icon src="AllIcons.Actions.StartDebugger"/> icon in the gutter.
            e.printStackTrace();
        }
    }
}