/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author sebascardonac11
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;


import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Calculos;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import vista.MainView;

/**
 * Main Application
 */
public class App extends HttpServlet {

    public static void main(String[] args) {
        try {

            Server server = new Server(Integer.valueOf(System.getenv("PORT")));
            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            server.setHandler(context);
            context.addServlet(new ServletHolder(new App()), "/*");

            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        MainView.showHome(req, resp);
        //MainView.showResults(req,resp,0.0," ",0.0);       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            MainView.showHome(req, resp);
            consoleInput(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method to set the console input for the numbers
     */
    public void consoleInput(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //System.out.println("Por favor, ingrese la cantidad de numeros que desea ingresar:");
        // X= 130.0-650.0-99.0-150.0-128.0-302.0-95.0-945.0-368.0-961.0
        // Y= 186.0-699.0-132.0-272.0-291.0-331.0-199.0-1890.0-788.0-1601.0
        //Scanner input = new Scanner(System.in);
        String lst1 = req.getParameter("lst1");
        Double nextElement = 0D;
        LinkedList<Double> x = new LinkedList<Double>();
        // StatisticCalculator calculator = new StatisticCalculator();
        String[] strElements1 = lst1.split("-");
     
        for (int i = 0; i < strElements1.length; i++) {
            try {
                nextElement = Double.valueOf(strElements1[i]);
                x.add(nextElement);

            } catch (NumberFormatException ex) {
                MainView.error(req, resp);
            }
        }
    
      //  Calculos cal = new Calculos(x);
      //  MainView.showResults(req, resp, cal.getVS(),cal.getS(),cal.getM(),cal.getL(),cal.getVL());
    }

    /**
     * Method to set the file input for the numbers
     */
    public void fileInput() {
        /*      ClassLoader classLoader = this.getClass().getClassLoader();
         FileInput inputReader = new FileInput();
         inputReader.getFile(classLoader.getResource("inputs.txt").getFile());
         inputReader.readNumbersFromFile();
         LinkedList<Double> values = inputReader.getValuesFromFile();

         StatisticCalculator calculator = new StatisticCalculator();
         calculator.setInputData(values);
        
         System.out.println("Leyendo desde el archivo inputs.txt");
         System.out.println("Lista: " + values.toString());
         System.out.println("Media: " + calculator.calculateMean());
         System.out.println("Desviacion Estandar: " + calculator.calculateStdDev());
         */
    }

}
