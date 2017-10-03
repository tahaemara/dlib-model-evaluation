package com.emaraic.util;

/**
 *
 * @author Taha Emara
 * Website: http://www.emaraic.com
 * Email  : taha@emaraic.com
 * Created on: Sep 4, 2017 
 */
public class Vector { 

    private int d;               // dimension of the vector
    private double[] data;       // array of vector's components


   
    public Vector(int d) {
        this.d = d;
        data = new double[d];
    }

   
    public Vector(double... a) {
        d = a.length;

        data = new double[d];
        for (int i = 0; i < d; i++)
            data[i] = a[i];
    }

   
    @Deprecated
    public int length() {
        return d;
    }

   
    public int dimension() {
        return d;
    }

  
    public double dot(Vector that) {
        if (this.d != that.d) throw new IllegalArgumentException("Dimensions don't agree");
        double sum = 0.0;
        for (int i = 0; i < d; i++)
            sum = sum + (this.data[i] * that.data[i]);
        return sum;
    }

    
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    
    public double distanceTo(Vector that) {
        if (this.d != that.d) throw new IllegalArgumentException("Dimensions don't agree");
        return this.minus(that).magnitude();
    }

    
    public Vector plus(Vector that) {
        if (this.d != that.d) throw new IllegalArgumentException("Dimensions don't agree");
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++)
            c.data[i] = this.data[i] + that.data[i];
        return c;
    }

    
    public Vector minus(Vector that) {
        if (this.d != that.d) throw new IllegalArgumentException("Dimensions don't agree");
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++)
            c.data[i] = this.data[i] - that.data[i];
        return c;
    }

   
    public double cartesian(int i) {
        return data[i];
    }

    
    @Deprecated
    public Vector times(double alpha) {
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++)
            c.data[i] = alpha * data[i];
        return c;
    }

    
    public Vector scale(double alpha) {
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++)
            c.data[i] = alpha * data[i];
        return c;
    }

   
    public Vector direction() {
        if (this.magnitude() == 0.0) throw new ArithmeticException("Zero-vector has no direction");
        return this.times(1.0 / this.magnitude());
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < d; i++)
            s.append(data[i] + " ");
        return s.toString();
    }

    
    
}
