package Inlämning2.View;

import Inlämning2.Controller.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class View {
    public String printMessage(String msg) {
        System.out.println(msg);
        return msg;
    }

    public View() throws InterruptedException, SQLException {
        Controller cont = new Controller(this);
        Scanner sc = new Scanner(System.in);

        String shoes = "";
        String password;
        String customer;
        String input;


        while (true) {
            try {
                printMessage("SKO_SHOPEN!!");
                printMessage("LOGGA IN");
                printMessage("SKRIV DITT FÖRNAMN EFTERNAMN");
                customer = sc.nextLine();
                printMessage("SKRIV DITT LÖSENORD");
                password = sc.nextLine();
                printMessage("---LOGGING IN---");
                Thread.sleep(2000);
                boolean x = true;
                if(cont.isCustomerVerified(customer, password)) {

                    while (x) {

                        printMessage("Lägg i varukorg .1), Se varukorg .2), bekräfta varukorg .3) logga ut .4) Exit .5)");
                        input = sc.nextLine();

                        switch (input) {

                            case "1":
                                cont.ShowAllShoes();
                                printMessage("Ange Märke, Storlek, Färg ");
                                shoes = sc.nextLine();
                                cont.getShoeFromInput(shoes);
                                break;

                            case "2":
                                cont.showBasket();
                                break;

                            case "3":
                                cont.confirmOrder(customer,shoes);
                                cont.showBasket();
                                cont.clearCurrentOrder();
                                break;

                            case "4":
                                printMessage(customer + " utloggad");
                                    x=false;
                                break;

                            case "5":
                                printMessage("Thanks for shopping here\nBye!");
                                Thread.sleep(2000);
                                System.exit(0);
                                break;
                        }

                    }
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                printMessage("Fel format i inmatning, ex: [Förnamn] [Efternamn]");
            }
        }
    }
}
