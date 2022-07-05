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
            String sql = "select studentID,studentName from Student\n"
                    + "where studentID= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, sid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getString("studentID"));
                student.setStudentName(rs.getString("studentName"));
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
            String sql = "select s.studentID,s.studentName,sg.groupID from Student s\n"
                    + "inner join Student_group sg on s.studentID = sg.studentID\n"
                    + "where sg.groupID = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, groupID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student_group studentgroup = new Student_group();
                StudentDBContext sdb = new StudentDBContext();
                GroupDBContext gdb = new GroupDBContext();
                studentgroup.setStudent(sdb.get(rs.getString("studentID")));
                studentgroup.setGroup(gdb.get(rs.getString("groupID")));

                student_group.add(studentgroup);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentGroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student_group;
    }

    public ArrayList<Student_lession> listAllStudentInLession(String groupID, String lessionID) {
        ArrayList<Student_lession> student_lession = new ArrayList<>();
        try {
            String sql = "SELECT sg.groupID, sg.studentID, s.studentName, sl.lessionID,sl.status FROM [Student_group] SG, [Student] S, [Student_lession] SL\n"
                    + "WHERE \n"
                    + "SG.groupID = ? AND S.studentID = SG.studentID AND\n"
                    + "S.studentID = SL.studentID AND SL.lessionID = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, groupID);
            stm.setString(2, lessionID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student_lession studentlession = new Student_lession();
                StudentDBContext sdb = new StudentDBContext();
                LessionDBContext ldb = new LessionDBContext();
                studentlession.setStudent(sdb.get(rs.getString("studentID")));
                studentlession.setLession(ldb.get(rs.getString("lessionID")));

                student_lession.add(studentlession);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentGroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
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
