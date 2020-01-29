package Inlämning2.Model.Models;

public class Order_sko_items {
    Beställningar beställning;
    Shoe sko;

    public Order_sko_items(Beställningar beställning, Shoe sko) {
        this.beställning = beställning;
        this.sko = sko;
    }

    @Override
    public String toString() {
        return "Order_sko_items{" +
                "beställning=" + beställning +
                ", sko=" + sko +
                '}';
    }
}
