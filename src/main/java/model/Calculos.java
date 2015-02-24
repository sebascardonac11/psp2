/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sebascardonac11
 */
public class Calculos {

    private double x;
    private double dof;
    private static double E = 0.00001;
    private double num_seg = 10;
    private double w;

    private int r;
    private double f1;
    private double p;

    public Calculos(double x, double dof) {
        this.x = x;
        this.dof = dof;
        this.w = this.x / this.num_seg;
        this.calF1();
        double sumatorias = 0.0;
        for (int i = 0; i <= this.num_seg; i++) {
            sumatorias += this.getMultiplicador(getF(this.w * i), i);
        }
        this.p = (this.w/3)*sumatorias;
    

    }

    public double getP(){
        return this.p;
    }
    private void calF1() {
        double r1 = calR((this.dof + 1) / 2);
        double r2 = calR(this.dof / 2);
        this.f1 = r1 / ((Math.sqrt(this.dof * 3.1416)) * (r2));
    }

    private double getMultiplicador(double f, int i) {
        int ispar = i / 2;
        ispar = ispar * 2;
        if (i == 0 || i == this.num_seg) {
            return f;
        } else {
            if (ispar == i) {
                /*impar*/
                return f * 2;
            } else {
                return f * 4;
            }
        }
    }

    private double getF(double x) {
        if (x == 0) {
            return this.f1;
        } else {
            double exp = -1 * ((this.dof + 1) / (2));
            double base = (1 + ((x * x) / this.dof));
            double f2;
            if (exp < 0) {
                f2 = Math.exp(exp * Math.log(base));
            } else {
                f2 = Math.pow(exp, base);
            }

            return f1 * f2;
        }
    }

    private double calR(double x) {
        return this.factorial(x - 1);
    }

    private double factorial(double n) {
        if (n == 0) {
            return 1;
        } else {
            if (n == 0.5) {
                return (0.5 * Math.sqrt(3.1416));
            } else {
                return n * factorial(n - 1);
            }
        }
    }
    
}
