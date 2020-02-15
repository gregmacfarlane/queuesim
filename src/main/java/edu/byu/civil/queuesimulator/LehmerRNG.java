package edu.byu.civil.queuesimulator;

public class LehmerRNG {
    private Double a;
    private Double m;

    public LehmerRNG(Double a, Double m) {
       this.a = a;
       this.m = m;
    }

    public Double nextLRNG(Double x) {
        Double remainder;
        remainder = (a * x) % m;
        return remainder;
    }

    public static void main(String[] args){
        Double a = 48271.0;
        Double m = 2e31 - 1;

        LehmerRNG myRNG = new LehmerRNG(a, m);

        Double x = 141.;
        int i = 0;
        while(i < 10) {
            x = myRNG.nextLRNG(x);
            System.out.println("x is: " + x);
            System.out.println("x on [0,1] is: " + x / m);

            i++;
        }
    }

}
