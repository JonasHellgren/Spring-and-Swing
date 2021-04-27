package org.example.swingdemos.lineplot;

public class ScaleLinear {
//This function uses linear scaling out=m*in+b to relate output to input

    private double b;
    private double m;

    private double d0,d1;    //domain, inputs
    private double r0,r1;    //range, outputs

    public ScaleLinear(double d0, double d1, double r0, double r1) {
        this.d0 = d0;
        this.d1 = d1;
        this.r0 = r0;
        this.r1 = r1;
        setScaleParameters(d0, d1, r0, r1);
    }

    public double calcOut(double in) {
        return m*in+b;
    }

    public int[] calcOut(double[] inVec) {

        int[] outVec=new int[inVec.length];
        for (int i = 0; i < inVec.length; i++) {
            outVec[i]= (int) (m*inVec[i]+b);
        }
        return outVec;
    }

    private void setScaleParameters(double d0, double d1, double r0, double r1) {
        //solution to  r0=m*d0+b;  r1=m*d1+b assuming d0, d1, r0 and r1 as known
        m=(r1-r0)/(d1-d0);
        b=r0-m*d0;
    }

}
