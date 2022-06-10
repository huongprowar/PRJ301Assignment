/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Instructor;

/**
 *
 * @author Nam
 */
public class Account {

    private String username;
    private String password;
    private Instructor employee;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instructor getEmployee() {
        return employee;
    }

    public void setEmployee(Instructor employee) {
        this.employee = employee;
    }

}
