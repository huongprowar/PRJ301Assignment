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
import model.Student_group;

/**
 *
 * @author Nam
 */
public class LessionDBContext extends DBContext<Lession> {

    public ArrayList<Lession> getGroupByInstructorID(String iID) {
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

    public ArrayList<Lession> getGroupByStudentID(String sID) {
        ArrayList<Lession> lessionList = new ArrayList<>();
        try {
            String sql = "select g.groupID, g.courseID, l.instructorID, l.slot, l.roomID, l.recordTime from Student_group sg\n"
                    + "inner join Lession l on sg.groupID = l.groupID\n"
                    + "inner join Groups g on sg.groupID = g.groupID\n"
                    + "where sg.studentID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, sID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lession lession = new Lession();
                lession.setCourse(rs.getString("courseID"));
                lession.setSlot(rs.getInt("slot"));
                lession.setRoomID(rs.getString("roomID"));
                GroupDBContext groupDB = new GroupDBContext();
                lession.setGroup(groupDB.get(rs.getString("groupID")));
                InstructorDBContext instructorDB = new InstructorDBContext();
                lession.setInstructor(instructorDB.get(rs.getString("instructorID")));
                lession.setRecordTime(rs.getDate("recordTime"));
                lessionList.add(lession);
            }
            return lessionList;
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Lession> getWeeklyTimetableSlot(String studentID) {
        ArrayList<Lession> timeTableList = new ArrayList<>();
        try {
            String sql = "select l.lessionID, g.groupName, g.courseID, l.slot, l.roomID, l.recordTime, l.instructorID from Lession l\n"
                    + "inner join Student_lession sl on sl.lessionID = l.lessionID\n"
                    + "inner join Groups g on g.groupID = l.groupID\n"
                    + "where studentID= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            GroupDBContext gDB = new GroupDBContext();
            stm.setString(1, studentID);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Lession lession = new Lession();
                lession.setLessionID(rs.getString("lessionID"));
                lession.setGroup(gDB.get(rs.getString("groupName")));
                lession.setCourse(rs.getString("courseID"));
                lession.setSlot(rs.getInt("slot"));
                lession.setRoomID(rs.getString("roomID"));
                lession.setRecordTime(rs.getDate("recordTime"));
                lession.setInstructor(new InstructorDBContext().get(rs.getString("instructorID")));
                timeTableList.add(lession);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return timeTableList;
    }

    public void addStudentLession(String lessionID, String groupID) {
        StudentDBContext sDB = new StudentDBContext();
        ArrayList<Student_group> sgList = sDB.listAllStudentInGroup(groupID);
        for (int i = 0; i < sgList.size(); i++) {
            try {
                String sql = "INSERT INTO [Student_lession]\n"
                        + "           ([studentID]\n"
                        + "           ,[lessionID]\n"
                        + "           ,[status])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?\n"
                        + "           ,0)";
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setString(1, sgList.get(i).getStudent().getId());
                stm.setString(2, lessionID);
                stm.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(LessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
