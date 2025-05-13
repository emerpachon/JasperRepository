package org.example;

public class Subject {

    private String subjectName;
    private Long markObtained;

    public Subject(String subjectName, Long markObtained) {
        this.subjectName = subjectName;
        this.markObtained = markObtained;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Long getMarkObtained() {
        return markObtained;
    }

    public void setMarkObtained(Long markObtained) {
        this.markObtained = markObtained;
    }
}
