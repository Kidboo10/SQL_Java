package Inlämning2.Model.Models;

public class Slut_i_lager {
    Shoe sko;
    String date;

    public Slut_i_lager(Shoe sko, String date) {
        this.sko = sko;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Slut_i_lager{" +
                "sko=" + sko +
                ", date='" + date + '\'' +
                '}';
    }
}
