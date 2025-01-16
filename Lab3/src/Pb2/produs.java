package Pb2;

import java.time.LocalDate;

public class produs {
    private String nume;
    private float pret;
    private int cantitate;
    private LocalDate dataExp;

    produs(String nume, float pret, int cantitate, LocalDate dataExp) {
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExp = dataExp;
    }

    @Override
    public String toString() {
        return "Nume: "+nume + " Pret: " + pret + " Cantitate: " + cantitate + " DataExpirarii: " + dataExp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public LocalDate getDataExp() {
        return dataExp;
    }

    public void setDataExp(LocalDate dataExp) {
        this.dataExp = dataExp;
    }

}
