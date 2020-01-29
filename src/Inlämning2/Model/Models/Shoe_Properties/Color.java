package Inlämning2.Model.Models.Shoe_Properties;

public class Color {
    String färgNamn;

    public Color(String färgNamn) {
        this.färgNamn = färgNamn;
    }

    public String getFärgNamn() {
        return färgNamn;
    }

    @Override
    public String toString() {
        return färgNamn;
    }
}
