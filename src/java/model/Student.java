/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

public class Student extends Person {

    private ArrayList<Group> student_group;
    private ArrayList<Lession> student_lession;

    public ArrayList<Group> getStudent_group() {
        return student_group;
    }

    public void setStudent_group(ArrayList<Group> student_group) {
        this.student_group = student_group;
    }

    public ArrayList<Lession> getStudent_lession() {
        return student_lession;
    }

    public void setStudent_lession(ArrayList<Lession> student_lession) {
        this.student_lession = student_lession;
    }
}
