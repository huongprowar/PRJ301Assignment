/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.LessionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lession;
import model.Week;

/**
 *
 * @author Nam
 */
public class WeeklyTimetableController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String milisecond = request.getParameter("milisecond");
        if (milisecond != null) {
            DateFormat sdf = new SimpleDateFormat("EEE dd/MM/yyyy");
            Date fromdate = new Date(Long.parseLong(milisecond));
            ArrayList<Lession> timeTableList = new LessionDBContext().getWeeklyTimetableSlot("HE163297");
            ArrayList<Date> dateOfWeek = new ArrayList<>();
            Calendar c = Calendar.getInstance();
            c.setTime(fromdate);
            for (int i = 0; i < 7; i++) {
                dateOfWeek.add(fromdate);
                c.add(Calendar.DATE, 1);
                fromdate = c.getTime();
            }
            request.setAttribute("dateOfWeek", dateOfWeek);
            request.setAttribute("timeTableList", timeTableList);
            request.setAttribute("fromdate", fromdate);
        }
        request.getRequestDispatcher("/view/attendance/weeklyTimeTable.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

//    public static Week getWeek() throws ParseException {
//        // Get calendar set to current date and time
//        Calendar c = Calendar.getInstance();
//
//        // Set the calendar to monday of the current week
//        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//
//        System.out.println();
//        // Print dates of the current week starting on Monday
//        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");        
//        Date fromDate = sdf.parse(sdf.format(c.getTime()));        
//        System.out.println(sdf.format(c.getTime()));
//        for (int i = 0; i < 6; i++) {
//            c.add(Calendar.DATE, 1);
//        }
//        Date toDate
//        System.out.println(sdf.format(c.getTime()));
//        System.out.println();
//        return sdf.format(c.getTime());
//    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
