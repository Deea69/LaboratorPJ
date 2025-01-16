package Pb1;

import java.util.Vector;

public class PerecheNumere {
    private int nr1;
    private int nr2;
    private Vector<Integer> Fibo =  new Vector<>();
    private void generateFibo(Vector<Integer> Fibo){
        int a = 0;
        int b = 1;
        int c=a+b;
        Fibo.addElement(a);
        Fibo.addElement(b);
        while(c<=nr2)
        {
            c = a+b;
            a = b;
            b = c;
            Fibo.addElement(c);
        }
    }
    PerecheNumere(int nr1, int nr2) {
        this.nr1 = nr1;
        this.nr2 = nr2;
        generateFibo(Fibo);
    }
    PerecheNumere(){}

    public int getNr1() {
        return nr1;
    }

    public void setNr1(int nr1) {
        this.nr1 = nr1;
    }

    public int getNr2() {
        return nr2;
    }

    public void setNr2(int nr2) {
        this.nr2 = nr2;
    }

    @Override
    public String toString() {
        return "nr1= " + nr1 +
                ", nr2= " + nr2;
    }

    public boolean isItFibo(){
        for(int i=0;i<Fibo.size()-1;i++){
            if(Fibo.get(i)==this.nr1 && Fibo.get(i+1)==this.nr2)
                return true;
        }
        return false;
    }

    public int CMMMC(){
        int CMMDC, aux1, aux2, rasp;
        aux1 = this.nr1;
        aux2 = this.nr2;
        while(aux1!=aux2){
            if(aux1>aux2)
                aux1-=aux2;
            else aux2-=aux1;
        }
        CMMDC = aux1;
        rasp=(this.nr1*this.nr2)/CMMDC;
        return rasp;
    }

    public boolean sumaCifr(){
        int aux1, aux2, S1=0, S2=0;
        aux1 = this.nr1;
        aux2 = this.nr2;
        while(aux1!=0){

            S1+=aux1%10;
            aux1 /= 10;
        }
        while(aux2!=0){
            S2+=aux2%10;
            aux2 /= 10;
        }
        if(S1==S2) return true;
        return false;
    }

    public boolean nrCifPare(){
        int k1=0, k2=0, aux1, aux2;
        aux1 = this.nr1;
        aux2 = this.nr2;
        while(aux1!=0){

            if((aux1%10)%2==0) k1++;
            aux1 /= 10;
        }
        while(aux2!=0){
            if((aux2%10)%2==0) k2++;
            aux2 /= 10;
        }
        if(k1==k2) return true;
        return false;
    }
}
