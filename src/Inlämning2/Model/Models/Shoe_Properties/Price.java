package Inlämning2.Model.Models.Shoe_Properties;

public class Price {
    String pris;

    public Price(String pris) {
        this.pris = pris;
    }

    public String getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return pris;
    }
}
