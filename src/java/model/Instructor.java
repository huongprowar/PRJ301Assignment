/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Nam
 */
public class Instructor extends Person {

    private ArrayList<Lession> lessionList;

    public ArrayList<Lession> getLessionList() {
        return lessionList;
    }

    public void setLessionList(ArrayList<Lession> lessionList) {
        this.lessionList = lessionList;
    }

}
