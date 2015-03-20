/*
 * Copyright (C) 2015
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package vista;

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
        pw.println("<h1>PSP2.0 Program 5</h1>");
        pw.println("<h2>Sebastian Cardona Correa</h2>");
        pw.println("<h2>E:0.00001</h2>");
        pw.write("<form action=\"calc\" method=\"post\"> \n"
                + " <p> x </p>   <input type=\"text\" name=\"lst1\"  value=\"0.55338\">\n"
                + " <p> dof </p> <input type=\"text\" name=\"lst2\"  value=\"6\">\n"
                + " <p> Numero de Segmento </p> <input type=\"text\" name=\"lst3\"  value=\"10\">\n"
                + " <p> p </p> <input type=\"text\" name=\"lst4\"  value=\"0.20\">\n"
                + "    <input type=\"submit\" value=\"Calc\">\n"
                + "</form> ");

        pw.write("</html>");
    }

    public static void showResults(HttpServletRequest req, HttpServletResponse resp,Double x, Double dof,Double seg ,Double P)
            throws ServletException, IOException {
        resp.getWriter().println("<b>x:</b> " + x + "<br>");
        resp.getWriter().println("<b>dof:</b> " + dof + "<br>");
        resp.getWriter().println("<b>segmento:</b> " + seg + "<br>");
        resp.getWriter().println("<b>P:</b> " + P + "<br>");

    }

    public static void error(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("Error!!!");
    }

}
