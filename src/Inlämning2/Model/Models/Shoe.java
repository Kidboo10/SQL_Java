package Inlämning2.Model.Models;

import Inlämning2.Model.Models.Shoe_Properties.*;

public class Shoe {
    Color color;
    Brand brand;
    Price pris;
    Size size;
    int sko_saldo;

    public Shoe(Color coloer, Brand brand, Price pris, Size size, int sko_saldo) {
        this.color = coloer;
        this.brand = brand;
        this.pris = pris;
        this.size = size;
        this.sko_saldo = sko_saldo;
    }

    public Color getColor() {
        return color;
    }

    public Brand getBrand() {
        return brand;
    }

    public Price getPris() {
        return pris;
    }

    public Size getSize() {
        return size;
    }

    public int getSko_saldo() {
        return sko_saldo;
    }

    @Override
    public String toString() {
        return "Modell: "+brand +
                " Färg: " + color +
                " Pris: " + pris +
                " Storlek: " + size;
    }
}
