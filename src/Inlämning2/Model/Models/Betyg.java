package Inlämning2.Model.Models;

public class Betyg {
    String betygsVärde;
    String betygsPoäng;

    public Betyg(String betygsVärde, String betygsPoäng) {
        this.betygsVärde = betygsVärde;
        this.betygsPoäng = betygsPoäng;
    }

    @Override
    public String toString() {
        return "Betyg{" +
                "betygsVärde='" + betygsVärde + '\'' +
                ", betygsPoäng='" + betygsPoäng + '\'' +
                '}';
    }
}
