package Inlämning2.Controller;

import Inlämning2.Model.Model;
import Inlämning2.Model.Models.Shoe;
import Inlämning2.View.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    View view;
    Model model = new Model();
    List<String> shoebasketList = new ArrayList<>();
    List<String> shoeIdbasketList = new ArrayList<>();

    public Controller(View view) {
        this.view = view;
    }

    public boolean isCustomerVerified(String customer, String password) {
        String[] customerName = customer.split(" ");
        if (model.isKundVerifierad(customerName[0], customerName[1], password)) {
            view.printMessage(customerName[0] + " " + customerName[1] + " Är inloggad");
            return true;
        } else
            view.printMessage("felaktigt användare eller lösenord\nförsök igen");
        return false;

    }

    public void ShowAllShoes() {
        model.showAllShoes().entrySet().forEach((k)->view.printMessage(k.getValue().toString()));
    }


    public void getShoeFromInput(String inputShoe) {
        String[] shoeInput = inputShoe.split(",");
        if (shoeInput.length != 3)
            view.printMessage("Felaktig inmatning. [märke],[storlek],[färg]");

        else {
            if (!model.getProductIdByModelString(shoeInput[0], shoeInput[1], shoeInput[2]).isEmpty()) {
                view.printMessage("Sko " + model.getShoeByModelString(shoeInput[0], shoeInput[1], shoeInput[2])
                        + " \nÄr tillagd i varukorgen!");
                shoeIdbasketList.add(model.getProductIdByModelString(shoeInput[0], shoeInput[1], shoeInput[2]));
                shoebasketList.add(model.getShoeByModelString(shoeInput[0], shoeInput[1], shoeInput[2]));
            } else
                view.printMessage("Skon finns inte i lagret");
        }

    }

    public String getCustomerIdFromInput(String customerId) {
        String[] id = customerId.split(" ");
        return model.getKundIdByString(id[0], id[1]);
    }

    public void confirmOrder(String customerId, String skoId) throws SQLException {
        String[] id = customerId.split(" ");
        String kundId = getCustomerIdFromInput(customerId);
        String beställningsId = null;
        if(!shoeIdbasketList.isEmpty()) {
            for (String shoe : shoeIdbasketList) {
                model.addToCart(kundId, beställningsId, shoe);
                beställningsId = model.getOrderIdFromDB();
            }
            view.printMessage("Order bekräftad: ");
        } else
            view.printMessage("Varukorgen är tom!\nLägg skor i varukorgen först!");


    }

    public void showBasket() {
        shoebasketList.forEach(e->view.printMessage(e));
    }

    public void clearCurrentOrder() {
        shoeIdbasketList.clear();
        shoebasketList.clear();
    }

}
