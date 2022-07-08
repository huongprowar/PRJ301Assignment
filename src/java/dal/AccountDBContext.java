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
import model.Account;
import model.Feature;
import model.Instructor;
import model.Role;
import model.Student;

/**
 *
 * @author Nam
 */
public class AccountDBContext extends DBContext<Account> {

    public Account getAccByUserAndPass(String user, String pass, String role) {
        try {
            String sql = "";
            if (role.equals("Instructor")) {
                sql = "select a.username,a.role, i.ID \n"
                        + "from Account a\n"
                        + "inner join Instructor i on i.userName = a.userName\n"
                        + "where a.username = ? and password = ? and role = ?";
            } else {
                sql = "select a.username,a.role, s.ID \n"
                        + "from Account a\n"
                        + "inner join Student s on s.userName = a.userName\n"
                        + "where a.username = ? and password = ? and role = ?";
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            stm.setString(3, role);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Account acc = new Account();
                if (role.equals("Instructor")) {
                    InstructorDBContext insDB = new InstructorDBContext();
                    Instructor obj = insDB.get(rs.getString("ID"));
                    acc.setPerson(obj);
                } else {
                    StudentDBContext stuDB = new StudentDBContext();
                    Student obj = stuDB.get(rs.getString("ID"));
                    acc.setPerson(obj);
                }
                RoleFeatureDBContext roleDB = new RoleFeatureDBContext();
                acc.setRole(roleDB.get(role));
                acc.setUsername(rs.getString("username"));
                return acc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Account> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
