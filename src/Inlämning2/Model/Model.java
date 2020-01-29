package Inlämning2.Model;


import Inlämning2.Model.Models.Kund;
import Inlämning2.Model.Models.Shoe;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Model {
    Repo re = new Repo();

    public boolean isKundVerifierad(String förnamn, String efternamn, String password){
        Map<Integer, Kund> kundList = re.mapKundToHashmap();
        förnamn.trim().toLowerCase();
        efternamn.trim().toLowerCase();
        password.trim().toLowerCase();
        return kundList.entrySet().stream()
                .filter(x -> förnamn.equals(x.getValue().getFörNamn().trim().toLowerCase()))
                .filter(x -> efternamn.equals(x.getValue().getEfterNamn().trim().toLowerCase()))
                .anyMatch(x->password.equals(x.getValue().getLösenord()));
    }

    public String getProductIdByModelString(String model, String size, String coloer) {
        Map<Integer, Shoe> fullShoeList = re.mapSkorToHashmap();
        model.trim().toLowerCase();
        size.trim().toLowerCase();
        coloer.trim().toLowerCase();

        String result = fullShoeList.entrySet().stream()
                .filter(x -> model.equals(x.getValue().getBrand().getBrandName().trim().toLowerCase()))
                .filter(x -> size.equals(x.getValue().getSize().toString().trim().toLowerCase()))
                .filter(x -> coloer.equals(x.getValue().getColor().toString().trim().toLowerCase()))
                .map(x->x.getKey().toString())
                .collect(Collectors.joining());

            return result;
    }

    public String getShoeByModelString(String model, String size, String color) {
        Map<Integer, Shoe> fullShoeList = re.mapSkorToHashmap();
        model.trim().toLowerCase();
        size.trim().toLowerCase();
        color.trim().toLowerCase();

        String result = fullShoeList.values().stream()
                .filter(shoe -> model.equals(shoe.getBrand().getBrandName().trim().toLowerCase()))
                .filter(shoe -> size.equals(shoe.getSize().toString().trim().toLowerCase()))
                .filter(shoe -> color.equals(shoe.getColor().toString().trim().toLowerCase()))
                .map(Object::toString)
                .collect(Collectors.joining());
            return result;
    }

    public String getOrderIdFromDB() {
      return re.onlyOrderId().get(re.onlyOrderId().size()-1);
    }

    public void addToCart(String kundid, String beställningsid, String skoid) throws SQLException {
            re.AddToCart(kundid, beställningsid, skoid);
        }

    public Map<Integer, Shoe> showAllShoes(){
        Map<Integer, Shoe> List8;
        List8 = re.mapSkorToHashmap();
        List8.entrySet().forEach(entry -> {
            System.out.println(entry.getValue().toString());
        });
        return List8;
    }

    public String getKundIdByString(String förnamn, String efternamn) {
        Map<Integer, Kund> kundList = re.mapKundToHashmap();
        förnamn.trim().toLowerCase();
        efternamn.trim().toLowerCase();

        String result = kundList.entrySet().stream()
                .filter(x -> förnamn.equals(x.getValue().getFörNamn().trim().toLowerCase()))
                .filter(x -> efternamn.equals(x.getValue().getEfterNamn().trim().toLowerCase()))
                .map(x->x.getKey().toString())
                .collect(Collectors.joining());

        return result;
    }

    public void AddRate(String kund, String produkt, String kommentar, String betyg, String datum) throws SQLException {
        re.addRate(kund,produkt,kommentar,betyg,datum);
    }
}
