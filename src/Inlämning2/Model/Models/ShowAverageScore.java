package Inlämning2.Model.Models;

public class ShowAverageScore {
    String Product;
    String rating;
    String rate_text;

    public ShowAverageScore(String Product, String rating, String rate_text) {
        this.Product = Product;
        this.rating = rating;
        this.rate_text = rate_text;
    }

    public String getProduct() {
        return Product;
    }

    public String getRating() {
        return rating;
    }

    public String getRate_text() {
        return rate_text;
    }

    @Override
    public String toString() {
        return "ShowAverageScore{" +
                "proudct=" + Product +
                ", rating=" + rating +
                ", rate_text=" + rate_text +
                '}';
    }
}
