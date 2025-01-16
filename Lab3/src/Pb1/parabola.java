package Pb1;

//TODO
//De modificat mai jos varf sa nu aibe parametrii si cand fol 2 parab sa fie ca tip PARAB

public class parabola {
    private int a;
    private int b;
    private int c;
    private float vfA_p;
    private float vfB_p;
    public float varfA(int a,int b,int c){
        float vfA = (float)-b/(2*a);
        return vfA;
    }

    public float varfB(int a,int b,int c){
        float vfB = (float)(-b^2+4*a*c)/(4*a);
        return vfB;
    }
    parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        vfA_p = varfA(a,b,c);
        vfB_p = varfB(a,b,c);
    }
    public String varfulParabolei(){
        return "("+vfA_p+","+vfB_p+")";
    }
    @Override
    public String toString() {
        return "f(x) = " + a + " x^2 + " +b+ " + "+c;
    }
    public String mijloculSegm(int aN, int bN, int cN){
        float vfAN = varfA(aN, bN, cN); //Parab data
        float vfBN = varfB(aN, bN, cN);
        float mijA = (vfA_p+vfAN)/2;
        float mijB = (vfB_p+vfBN)/2;
        return "("+mijA+","+mijB+")";
    }

    public String mijloc2Parab(int a1, int b1, int c1, int a2, int b2, int c2){
        float vfA_1 = varfA(a1,b1,c1);
        float vfB_1 = varfB(a1,b1,c1);
        float vfA_2 = varfA(a2,b2,c2);
        float vfB_2 = varfB(a2,b2,c2);

        float mijA = (vfA_1+vfA_2)/2;
        float mijB = (vfB_1+vfB_2)/2;
        return "("+mijA+","+mijB+")";
    }

    public float lungimeaSegmn(int aN, int bN , int cN){
        float vfAN = varfA(aN, bN,cN); //Parab noua
        float vfBN = varfB(aN, bN,cN);
        float A_diff = (vfAN-vfA_p);
        float B_diff = (vfBN-vfB_p);
        float lungime = (float) Math.hypot(A_diff, B_diff);
        return lungime;
    }

    public float lungime2Parab(int a1, int b1, int c1, int a2, int b2, int c2){
        float vfA_1 = varfA(a1,b1,c1);
        float vfB_1 = varfB(a1,b1,c1);
        float vfA_2 = varfA(a2,b2,c2);
        float vfB_2 = varfB(a2,b2,c2);

        float A_diff = (vfA_2-vfA_1);
        float B_diff = (vfB_2-vfB_1);
        float lungime = (float) Math.hypot(A_diff, B_diff);
        return lungime;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}
