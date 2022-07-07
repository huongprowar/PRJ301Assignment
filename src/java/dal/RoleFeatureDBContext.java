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
import model.Feature;
import model.Role;

/**
 *
 * @author Nam
 */
public class RoleFeatureDBContext extends DBContext<Object> {

//    public ArrayList<Feature> getAllFeatureOfRole(String role) {
//        ArrayList<Feature> featureList = new ArrayList<>();
//        try {
//            String sql = "select r.role,f.feature, f.url from Role r\n"
//                    + "inner join Role_feature rf on r.role = rf.role\n"
//                    + "inner join Feature f on f.feature = rf.feature\n"
//                    + "where r.role = ?";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setString(1, role);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                Feature feature = new Feature();
//                feature.setFeature(rs.getString("feature"));
//                feature.setUrl(rs.getString("url"));
//                featureList.add(feature);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(RoleFeatureDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return featureList;
//    }
//
//    @Override
//    public ArrayList<Object> list() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public Role get(String role) {
        ArrayList<Feature> featureList = new ArrayList<>();
        Role accRole = new Role();
        accRole.setRole(role);
        try {
            String sql = "select r.role,f.feature, f.url from Role r\n"
                    + "inner join Role_feature rf on r.role = rf.role\n"
                    + "inner join Feature f on f.feature = rf.feature\n"
                    + "where r.role = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, role);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Feature feature = new Feature();
                feature.setFeature(rs.getString("feature"));
                feature.setUrl(rs.getString("url"));
                featureList.add(feature);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleFeatureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        accRole.setFeatures(featureList);
        return accRole;
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

    @Override
    public ArrayList<Object> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
