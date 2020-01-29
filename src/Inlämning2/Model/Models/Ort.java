package Inlämning2.Model.Models;

public class Ort {
    String name;

    public Ort(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
