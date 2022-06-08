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
import model.Campus;

/**
 *
 * @author Nam
 */
public class CampusDBContext extends DBContext<Campus>{

    @Override
    public ArrayList<Campus> list() {
        ArrayList<Campus> campusList = new ArrayList<>();
        try {
            String sql = "select cID, cName from Campus";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Campus cam = new Campus();
                cam.setCid(rs.getInt("cID"));
                cam.setCname(rs.getString("cName"));
                campusList.add(cam);
            }
            return campusList;
        } catch (SQLException ex) {
            Logger.getLogger(CampusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Campus get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Campus model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Campus model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Campus model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
