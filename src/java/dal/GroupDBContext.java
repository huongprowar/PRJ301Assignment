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
import model.Group;

/**
 *
 * @author Nam
 */
public class GroupDBContext extends DBContext<Group> {

    public ArrayList<Group> getGroupListByiID(String gID) {
        ArrayList<Group> groupList = new ArrayList<>();
        try {
            String sql = "select groupID,courseID from Groups\n"
                    + "where groupID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, gID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setgID(rs.getString("groupID"));
                group.setcID(rs.getString("courseID"));
                groupList.add(group);
            }
            return groupList;
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Group> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Group get(String gID) {        
        try {
            String sql = "select groupID,courseID from Groups\n"
                    + "where groupID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, gID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Group group = new Group();
                group.setgID(rs.getString("groupID"));
                group.setcID(rs.getString("courseID"));
                return group;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
