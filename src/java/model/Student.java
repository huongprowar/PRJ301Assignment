/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

public class Student {

    private String studentID;
    private String studentName;
    private ArrayList<Student_group> student_group;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public ArrayList<Student_group> getStudent_group() {
        return student_group;
    }

    public void setStudent_group(ArrayList<Student_group> student_group) {
        this.student_group = student_group;
    }

}
