package org.example;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.base.JRBaseTextField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstReport {

    public static void main(String[] args) {

        try {
            System.out.println("entro al metodo");
            String filePath = "C:\\Users\\emersonpachon\\IdeaProjects\\FirstReport\\src\\main\\resources\\FirstReport.jrxml";
            System.out.println("guardo la patch");
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("studentName", "John");
            System.out.println("creo parametros");

            Student student1 = new Student(1L, "Raj", "Joshi", "Happy Street",
                    "Delhi");

            Student student2 = new Student(2L, "Peter", "Smith", "Any Street",
                    "Mumbai");

            List<Student> list = new ArrayList<Student>();
            list.add(student1);
            list.add(student2);

            JRBeanCollectionDataSource dataSource =
                    new JRBeanCollectionDataSource(list);
            System.out.println("creo datasource");
            JasperReport report = JasperCompileManager.compileReport(filePath);
            System.out.println("compilo el reporte");

            JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
            System.out.println("lleno el reporte");

            JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\emersonpachon\\IdeaProjects\\Informes Jaspert\\FirstReport.pdf");
            System.out.println("exporto el reporte");
            System.out.println("Report Created...");

        } catch(Exception e) {
            System.out.println("Exception while creating report");

            e.printStackTrace();
        }
    }
}
