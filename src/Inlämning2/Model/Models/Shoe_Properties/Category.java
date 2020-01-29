package Inlämning2.Model.Models.Shoe_Properties;

public class Category {
    String kategoriNamn;

    public Category(String kategoriNamn) {
        this.kategoriNamn = kategoriNamn;
    }

    @Override
    public String toString() {
        return "Kategori " + kategoriNamn;
    }
}
