/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author sebascardonac11
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oscarkiyoshigegarcesaparicio
 */
public class MainView {

    public static void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h1>PSP1.1 Program 4</h1>");
        pw.println("<h2>Sebastian Cardona Correa</h2>");
        
        pw.println("<p>Test1 - LOC/Method:</p>");
        pw.println("<p>6.0000-6.0000-8.3333-10.3333-12.3333-16.4000-20.5000-21.7500-22.2500-23.0000-28.3333-29.0000-55.8000</p>");
        
        pw.println("<p>Test2 - Pgs/Chapter:</p>");
        pw.println("<p>12-10-12-10-12-12-12-12-8-8-8-20-14-18-12</p>");

        pw.write("<form action=\"calc\" method=\"post\"> \n"
                + "    <input type=\"text\" name=\"lst1\"  value=\"6.0000-6.0000-8.3333-10.3333-12.3333-16.4000-20.5000-21.7500-22.2500-23.0000-28.3333-29.0000-55.8000\">\n"
                
                + "    <input type=\"submit\" value=\"Calc\">\n"
                + "</form> ");

        pw.write("</html>");

    }

    public static void showResults(HttpServletRequest req, HttpServletResponse resp, Double VS, Double S, Double M, Double L, Double VL)
            throws ServletException, IOException {
        resp.getWriter().println("<b>VS:</b> " + VS + "<br>");
        resp.getWriter().println("<b>S :</b> " + S + "<br>");
        resp.getWriter().println("<b>M : </b> " + M + "<br>");
        resp.getWriter().println("<b>L :</b> " + L + "<br>");
        resp.getWriter().println("<b>VL: </b> " + VL + "<br>");
    }

    public static void error(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("Error!!!");
    }

}
