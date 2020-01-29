package Inlämning2.Model.Models;


public class Kund_omdöme {
    Kund kund;
    Shoe skor;
    String kommentar;
    Betyg betyg;
    String omdömes_datum;

    public Kund_omdöme(Kund kund, Shoe skor, String kommentar, Betyg betyg, String omdömes_datum) {
        this.kund = kund;
        this.skor = skor;
        this.kommentar = kommentar;
        this.betyg = betyg;
        this.omdömes_datum = omdömes_datum;
    }

    @Override
    public String toString() {
        return "Kund_omdöme{" +
                "kund=" + kund +
                ", skor=" + skor +
                ", kommentar='" + kommentar + '\'' +
                ", betyg=" + betyg +
                ", omdömes_datum='" + omdömes_datum + '\'' +
                '}';
    }
}
