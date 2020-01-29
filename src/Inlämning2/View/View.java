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
                printMessage("VÄLKOMMEN TILL SKO-SHOPEN!!\n" +
                        "\nLOGGA IN\nSKRIV DITT FÖRNAMN EFTERNAMN");
                customer = sc.nextLine();
                printMessage("\nSKRIV DITT LÖSENORD");
                password = sc.nextLine();
                printMessage("\n---LOGGAR IN---");
                Thread.sleep(1000);
                boolean x = true;
                if (cont.isCustomerVerified(customer, password)) {

                    while (x) {

                        printMessage("\nLägg i varukorg (1) | Se varukorg (2) | bekräfta varukorg (3) |"
                                +"\nlogga ut (4) | Exit (5) |");
                        input = sc.nextLine();

                        switch (input) {

                            case "1":
                                cont.ShowAllShoes();
                                printMessage("\nAnge Märke, Storlek, Färg ");
                                shoes = sc.nextLine();
                                cont.getShoeFromInput(shoes);
                                break;

                            case "2":
                                cont.showBasket();
                                break;

                            case "3":
                                cont.confirmOrder(customer);
                                break;

                            case "4":
                                printMessage("\n" + customer + " UTLOGGAD!");
                                x = false;
                                break;

                            case "5":
                                printMessage("\nTACK FÖR DU HANDLAR PÅ SKO-SHOPEN!!\nBYE!");
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
