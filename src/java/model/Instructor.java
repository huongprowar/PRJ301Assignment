/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Nam
 */
public class Instructor {

    private int iID;
    private String iName;
    private int campus;
//    private Date date;
//    private boolean gender;

    public int getiID() {
        return iID;
    }

    public void setiID(int iID) {
        this.iID = iID;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public int getCampus() {
        return campus;
    }

    public void setCampus(int campus) {
        this.campus = campus;
    }

}
