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
import model.Student;
import model.Student_group;
import model.Student_lession;

/**
 *
 * @author Nam
 */
public class StudentDBContext extends DBContext<Student> {

    @Override
    public ArrayList<Student> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student get(String sid) {
        try {
            String sql = "select ID, Name, userName from Student\n"
                    + "where ID= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, sid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("ID"));
                student.setName(rs.getString("Name"));
                student.setUsername(rs.getString("userName"));
                return student;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Student_group> listAllStudentInGroup(String groupID) {
        ArrayList<Student_group> student_group = new ArrayList<>();
        try {
            String sql = "select s.ID,sg.groupID from Student s\n"
                    + "inner join Student_group sg on s.ID = sg.studentID\n"
                    + "where sg.groupID = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, groupID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student_group studentgroup = new Student_group();
                StudentDBContext sdb = new StudentDBContext();
                GroupDBContext gdb = new GroupDBContext();
                studentgroup.setStudent(sdb.get(rs.getString("ID")));
                studentgroup.setGroup(gdb.get(rs.getString("groupID")));
                student_group.add(studentgroup);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student_group;
    }

    public ArrayList<Student_lession> listAllStudentInLession(String groupID, String lessionID) {
        ArrayList<Student_lession> student_lession = new ArrayList<>();
        try {
            String sql = "select s.ID, s.Name, s.userName, sg.groupID, sl.status, sl.lessionID\n"
                    + "from Student_group sg inner join Student s on sg.studentID = s.ID\n"
                    + "inner join Student_lession sl on sg.studentID = sl.studentID\n"
                    + "where sg.groupID = ? and sl.lessionID= ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, groupID);
            stm.setString(2, lessionID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student_lession studentlession = new Student_lession();
                StudentDBContext sdb = new StudentDBContext();
                LessionDBContext ldb = new LessionDBContext();
                studentlession.setStudent(sdb.get(rs.getString("ID")));
                studentlession.setLession(ldb.get(rs.getString("lessionID")));
                studentlession.setStatus(rs.getBoolean("status"));

                student_lession.add(studentlession);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student_lession;
    }

    @Override
    public void insert(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
