package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class CustomReport {
    public static void main(String[] args) {

        try {

            String filePath = "C:\\Users\\emersonpachon\\IdeaProjects\\FirstReport\\src\\main\\resources\\report.jrxml";
            String reportPath = "C:\\Users\\emersonpachon\\IdeaProjects\\Informes Jaspert\\CustomReport.pdf";


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

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);

            JRBeanCollectionDataSource chartDataSource = new JRBeanCollectionDataSource(list);

            Map<String, Object> parameters= new HashMap<>();
            parameters.put("studentName", "Emerson");
            parameters.put("tableData",dataSource);


            JasperReport report = JasperCompileManager.compileReport(filePath);

            JasperPrint print = JasperFillManager.fillReport(report,parameters,chartDataSource);

            JasperExportManager.exportReportToPdfFile(print, reportPath);
            System.out.println("Report generated successfully!");


        } catch (Exception e) {

            e.printStackTrace();
        }


    }
}