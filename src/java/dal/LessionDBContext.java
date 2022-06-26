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
import model.Lession;

/**
 *
 * @author Nam
 */
public class LessionDBContext extends DBContext<Object> {

        public ArrayList<Lession> getGroupByiID(String iID) {
        ArrayList<Lession> lessionList = new ArrayList<>();
        try {
            String sql = "select g.groupID,g.courseID,l.lessionID,l.instructorID,l.lecture,l.slot,l.roomID\n"
                    + "from Groups g\n"
                    + "inner join Lession l\n"
                    + "on g.groupID = l.groupID\n"
                    + "where instructorID = ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, iID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lession lession = new Lession();
                lession.setLessionID(rs.getString("lesisonID"));
                lession.setSlot(rs.getInt("slot"));
                lession.setRoomID(rs.getString("lesisonID"));
                GroupDBContext groupDB = new GroupDBContext();
                lession.setGroupList(groupDB.getGroupByiID(rs.getString("groupID")));
                In
                groupList.add(lession);
            }
            return groupList;
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
    public Object get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
