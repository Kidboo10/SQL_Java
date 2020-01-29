package Inlämning2.Model.Models;

public class Kund {
    String förNamn;
    String efterNamn;
    String lösenord;
    Ort ort;

    public Kund(String förNamn, String efterNamn, String lösenord, Ort ort) {
        this.förNamn = förNamn;
        this.efterNamn = efterNamn;
        this.lösenord = lösenord;
        this.ort = ort;
    }

    public String getFörNamn() {
        return förNamn;
    }

    public String getEfterNamn() {
        return efterNamn;
    }

    public String getLösenord() {
        return lösenord;
    }

    public Ort getOrt() {
        return ort;
    }

    @Override
    public String toString() {
        return "Kund{" +
                "förNamn='" + förNamn + '\'' +
                ", efterNamn='" + efterNamn + '\'' +
                ", lösenord='" + lösenord + '\'' +
                ", ort=" + ort +
                '}';
    }
}
