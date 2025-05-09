package com.smu.fullapplication;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private double gpa;
    private String personalInfo;

    public Student(String name, double gpa, String personalInfo) {
        this.name = name;
        this.gpa = gpa;
        this.personalInfo = personalInfo;
    }

    // Getters
    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public String getPersonalInfo() { return personalInfo; }
}