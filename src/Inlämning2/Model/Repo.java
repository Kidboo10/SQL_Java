package Inlämning2.Model;

import Inlämning2.Model.Models.Shoe_Properties.*;
import Inlämning2.Model.Models.*;

import java.io.FileInputStream;
import java.sql.*;
import java.util.*;

public class Repo {

    private Properties p = new Properties();

    public Repo() {
        try {
            p.load(new FileInputStream("C:\\Users\\atefs\\OneDrive\\Skrivbord\\Java lektioner\\SQL_Java\\src\\Inlämning2\\Settings.properties"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, Ort> mapOrtToHashmap() {
        Map<Integer, Ort> ortMap = new HashMap<>();
        String query = "Select * from ort";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ortMap.put(rs.getInt("id"), new Ort(rs.getString("namn")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ortMap;
    }

    public Map<Integer, Brand> mapBrandToHashmap() {
        HashMap<Integer, Brand> brandMap = new HashMap<>();
        String query = "Select * from märke";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                brandMap.put(rs.getInt("id"), new Brand(rs.getString("namn")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brandMap;
    }

    public Map<Integer, Size> mapStorlekToHashmap() {
        Map<Integer, Size> storlekMap = new HashMap<>();
        String query = "Select * from Storlek";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                storlekMap.put(rs.getInt("id"), new Size(rs.getString("storlek")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storlekMap;
    }

    public Map<Integer, Color> mapFärgToHashmap() {
        Map<Integer, Color> coloerMap = new HashMap<>();
        String query = "Select * from färg";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                coloerMap.put(rs.getInt("id"), new Color(rs.getString("namn")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coloerMap;
    }

    public Map<Integer, Price> mapPrisToHashmap() {
        Map<Integer, Price> priceMap = new HashMap<>();
        String query = "Select * from pris";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                priceMap.put(rs.getInt("id"), new Price(rs.getString("värd")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return priceMap;
    }

    public Map<Integer, Category> mapKategoriToHashmap() {
        Map<Integer, Category> categoryMap = new HashMap<>();
        String query = "Select * from kategori";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                categoryMap.put(rs.getInt("id"), new Category(rs.getString("namn")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryMap;
    }

    public Map<Integer, Shoe> mapSkorToHashmap() {
        Map<Integer, Shoe> shoeMap = new HashMap<>();
        Map<Integer, Color> coloerMap = mapFärgToHashmap();
        Map<Integer, Brand> brandMap = mapBrandToHashmap();
        Map<Integer, Price> priceMap = mapPrisToHashmap();
        Map<Integer, Size> sizeMap = mapStorlekToHashmap();
        String query = "Select * from skor";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                shoeMap.put(rs.getInt("id"),
                        new Shoe(coloerMap.get(rs.getInt("färgID")),
                                brandMap.get(rs.getInt("märkeID")),
                                priceMap.get(rs.getInt("prisID")),
                                sizeMap.get(rs.getInt("storleksID")),
                                rs.getInt("sko_saldo")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shoeMap;
    }

    public Map<Integer, Shoe_category> mapSkoKategoriToHashmap() {
        Map<Integer, Shoe_category> shoe_CategoryMap = new HashMap<>();
        Map<Integer, Shoe> shoeMap = mapSkorToHashmap();
        Map<Integer, Category> categoryMap = mapKategoriToHashmap();
        String query = "Select * from sko_kategori";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                shoe_CategoryMap.put(rs.getInt("id"), new Shoe_category(shoeMap.get(rs.getInt("skoID")),
                        categoryMap.get(rs.getInt("kategoriID"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shoe_CategoryMap;
    }

    public Map<Integer, Kund> mapKundToHashmap() {
        Map<Integer, Ort> ortMap = mapOrtToHashmap();
        Map<Integer, Kund> kundMap = new HashMap<>();
        String query = "Select * from kund";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                kundMap.put(rs.getInt("id"), new Kund(rs.getString("förnamn"),
                        rs.getString("efternamn"),
                        rs.getString("lösenord"),
                        ortMap.get(rs.getInt("ortID"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kundMap;
    }

    public Map<Integer, Betyg> mapBetygToHashmap() {
        Map<Integer, Betyg> betygMap = new HashMap<>();
        String query = "Select * from betyg";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                betygMap.put(rs.getInt("id"), new Betyg(rs.getString("betygs_värd")
                        , rs.getString("betygs_poäng")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return betygMap;
    }

    public Map<Integer, Kund_omdöme> mapOmdömeToHashmap() {
        Map<Integer, Kund_omdöme> omdömeMap = new HashMap<>();
        Map<Integer, Kund> kund = mapKundToHashmap();
        Map<Integer, Shoe> sko = mapSkorToHashmap();
        Map<Integer, Betyg> betyg = mapBetygToHashmap();
        String query = "Select * from kund_omdöme";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                omdömeMap.put(rs.getInt("id"), new Kund_omdöme(kund.get(rs.getInt("kundID")),
                        sko.get(rs.getInt("skoID")), rs.getString("kommentar"),
                        betyg.get(rs.getInt("betygsID")), rs.getString("omdeömes_datum")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return omdömeMap;
    }

    public Map<Integer, Beställningar> mapBeställningToHashmap() {
        Map<Integer, Beställningar> beställningsMap = new HashMap<>();
        Map<Integer, Kund> kund = mapKundToHashmap();
        String query = "Select * from beställningar";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                beställningsMap.put(rs.getInt("id"), new Beställningar(kund.get(rs.getInt("kundID")),
                        rs.getString("beställnings_datum")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beställningsMap;
    }

    public List<String> onlyOrderId() {
        List<String> OrderIDList = new ArrayList<>();
        String query = "Select * from beställningar";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                OrderIDList.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OrderIDList;
    }

    public Map<Integer, Order_sko_items> mapOrderToHashmap() {
        Map<Integer, Order_sko_items> orderMap = new HashMap<>();
        Map<Integer, Beställningar> beställning = mapBeställningToHashmap();
        Map<Integer, Shoe> sko = mapSkorToHashmap();
        String query = "Select * from order_sko_items";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                orderMap.put(rs.getInt("id"), new Order_sko_items(beställning.get(rs.getInt("beställningsID")),
                        sko.get(rs.getInt("skoID"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderMap;
    }

    public Map<Integer, Slut_i_lager> mapSlutToHashmap() {
        Map<Integer, Slut_i_lager> slut_lagerMap = new HashMap<>();
        Map<Integer, Shoe> sko = mapSkorToHashmap();
        String query = "Select * from slut_i_lager";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                slut_lagerMap.put(rs.getInt("id"), new Slut_i_lager(sko.get(rs.getInt("skoID")),
                        rs.getString("created")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slut_lagerMap;
    }

    public void AddToCart(String kundid, String beställningsid, String skoid) throws SQLException {
        ResultSet rs = null;
        String query = "call AddToCart(?,?,?)";

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             CallableStatement stm = con.prepareCall(query)) {
            stm.setString(1, kundid);
            stm.setString(2, beställningsid);
            stm.setString(3, skoid);
            stm.execute();


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void addRate(String kund, String produkt, String kommentar, String betyg, String datum) throws SQLException {
        ResultSet rs = null;
        String query = "call Rate(?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             CallableStatement stm = con.prepareCall(query)) {
            stm.setString(1, kund);
            stm.setString(2, produkt);
            stm.setString(3, kommentar);
            stm.setString(3, betyg);
            stm.setString(3, datum);
            stm.execute();


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public List<ShowAverageScore> showAverageScoreToList() {
        List<ShowAverageScore> showAverageScoreList = new ArrayList<>();
        Map<Integer, Shoe> sko = mapSkorToHashmap();
        String query = "Select * from showaveragescore";
        try (Connection con = DriverManager.getConnection
                (p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                showAverageScoreList.add(new ShowAverageScore(rs.getString("Product"),
                        rs.getString("rating"),
                        rs.getString("rate_text")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showAverageScoreList;
    }

}


