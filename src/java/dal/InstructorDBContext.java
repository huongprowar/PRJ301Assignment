/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Instructor;

/**
 *
 * @author Nam
 */
public class InstructorDBContext extends DBContext<Object> {

    public Instructor getInstructorByiID(String iID) {
        try {
            String sql = "select instructorID,instructorName from Instructor\n"
                    + "where instructorID= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, iID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Instructor instructor = new Instructor();
                instructor.setId(rs.getString("instructorID"));
                instructor.setName(rs.getString("instructorName"));
                return instructor;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Object> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Instructor get(String iID) {
        try {
            String sql = "select ID,Name,userName from Instructor\n"
                    + "where ID= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, iID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Instructor instructor = new Instructor();
                instructor.setId(rs.getString("ID"));
                instructor.setName(rs.getString("Name"));
                instructor.setUsername(rs.getString("userName"));
                return instructor;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
