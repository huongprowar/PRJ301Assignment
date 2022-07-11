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
import model.Lession;

/**
 *
 * @author Nam
 */
public class LessionDBContext extends DBContext<Lession> {

    public ArrayList<Lession> getGroupByiID(String iID) {
        ArrayList<Lession> lessionList = new ArrayList<>();
        try {
            String sql = "select g.groupID,g.courseID,l.lessionID,l.instructorID,l.lecture,l.slot,l.roomID\n"
                    + "from Groups g\n"
                    + "inner join Lession l\n"
                    + "on g.groupID = l.groupID\n"
                    + "where instructorID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, iID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lession lession = new Lession();
                lession.setCourse(rs.getString("courseID"));
                lession.setLecture(rs.getString("lecture"));
                lession.setLessionID(rs.getString("lessionID"));
                lession.setSlot(rs.getInt("slot"));
                lession.setRoomID(rs.getString("roomID"));
                GroupDBContext groupDB = new GroupDBContext();
                lession.setGroup(groupDB.get(rs.getString("groupID")));
                InstructorDBContext instructorDB = new InstructorDBContext();
                lession.setInstructor(instructorDB.get(rs.getString("instructorID")));
                lessionList.add(lession);
            }
            return lessionList;
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Lession getLessionByiID(String iID) {
        try {
            String sql = "select g.groupID,g.courseID,l.lessionID,l.instructorID,l.lecture,l.slot,l.roomID\n"
                    + "from Groups g\n"
                    + "inner join Lession l\n"
                    + "on g.groupID = l.groupID\n"
                    + "where instructorID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, iID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Lession lession = new Lession();
                lession.setCourse(rs.getString("courseID"));
                lession.setLecture(rs.getString("lecture"));;
                lession.setLessionID(rs.getString("lessionID"));
                lession.setSlot(rs.getInt("slot"));
                lession.setRoomID(rs.getString("roomID"));
                GroupDBContext groupDB = new GroupDBContext();
                lession.setGroup(groupDB.get(rs.getString("groupID")));
                InstructorDBContext instructorDB = new InstructorDBContext();
                lession.setInstructor(instructorDB.get(rs.getString("instructorID")));
                return lession;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Lession> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lession get(String lID) {
        try {
            String sql = "select lessionID,l.groupID,g.courseID,instructorID,lecture,slot,roomID,recordTime from Lession l\n"
                    + "inner join Groups g on g.groupID = l.groupID\n"
                    + "where lessionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, lID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Lession lession = new Lession();
                lession.setLessionID(lID);
                lession.setCourse(rs.getString("courseID"));
                lession.setLecture(rs.getString("lecture"));
                lession.setLessionID(rs.getString("lessionID"));
                lession.setSlot(rs.getInt("slot"));
                lession.setRoomID(rs.getString("roomID"));
                GroupDBContext groupDB = new GroupDBContext();
                lession.setGroup(groupDB.get(rs.getString("groupID")));
                InstructorDBContext instructorDB = new InstructorDBContext();
                lession.setInstructor(instructorDB.get(rs.getString("instructorID")));
                return lession;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateStatus(String studentID, String lessionID, int status) {
        try {
            String sql = "UPDATE [Student_lession]\n"
                    + "   SET [status] = ?\n"
                    + "WHERE studentID = ? and lessionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, status);
            stm.setString(2, studentID);
            stm.setString(3, lessionID);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Lession model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Lession model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Lession model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
