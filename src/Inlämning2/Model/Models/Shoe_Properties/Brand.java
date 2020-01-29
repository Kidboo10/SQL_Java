package Inlämning2.Model.Models.Shoe_Properties;

public class Brand {
    String brandName;

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    @Override
    public String toString() {
        return brandName;
    }
}
