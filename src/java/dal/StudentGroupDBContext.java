package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student_group;

/**
 *
 * @author Nam
 */
public class StudentGroupDBContext extends DBContext<Student_group> {

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

    public ArrayList<Student_group> listAllStudentInLession(String groupID, String lessionID) {
        ArrayList<Student_group> student_group = new ArrayList<>();
        try {
            String sql = "SELECT sg.groupID, sg.studentID, s.studentName, sl.lessionID,sl.status FROM [Student_group] SG, [Student] S, [Student_lession] SL\n"
                    + "WHERE \n"
                    + "SG.groupID = ? AND S.studentID = SG.studentID AND\n" +
            "S.studentID = SL.studentID AND SL.lessionID = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, groupID);
            stm.setString(2, lessionID);
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

    @Override
    public ArrayList<Student_group> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student_group get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Student_group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Student_group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student_group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
