package Inlämning2.Model.Models;

public class Beställningar {
    Kund kund;
    String datum;

    public Beställningar(Kund kund, String datum) {
        this.kund = kund;
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Beställningar{" +
                "kund=" + kund +
                ", datum='" + datum + '\'' +
                '}';
    }
}
