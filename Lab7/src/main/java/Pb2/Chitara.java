package Pb2;

enum TipChitara { ELECTRCICA, ACUSTICA, CLASICA};

public class Chitara extends InstrumentMuzical{
    private int nr_corzi;
    private TipChitara tipChitara;

    public Chitara(String producator, int pret, int nr_corzi, TipChitara tipChitara) {
        super(producator, pret);
        this.nr_corzi = nr_corzi;
        this.tipChitara = tipChitara;
    }

    public Chitara(){}

    public int getNr_corzi() {
        return nr_corzi;
    }

    public void setNr_corzi(int nr_corzi) {
        this.nr_corzi = nr_corzi;
    }

    public TipChitara getTipChitara() {
        return tipChitara;
    }

    public void setTipChitara(TipChitara tipChitara) {
        this.tipChitara = tipChitara;
    }

    @Override
    public String toString() {
        return "Chitara{ " +
                "nr_corzi= " + nr_corzi +
                ", tipChitara= " + tipChitara +
                ", producator= '" + producator + '\'' +
                ", pret= " + pret +
                '}';
    }
}
