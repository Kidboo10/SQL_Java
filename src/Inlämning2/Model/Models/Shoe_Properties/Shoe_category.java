package Inlämning2.Model.Models.Shoe_Properties;

import Inlämning2.Model.Models.Shoe;

public class Shoe_category {
    Shoe skor;
    Category kategori;

    public Shoe_category(Shoe skor, Category kategori) {
        this.skor = skor;
        this.kategori = kategori;
    }

    @Override
    public String toString() {
        return "Märke: " + skor +" " +  "Kategori " + kategori;
    }
}
