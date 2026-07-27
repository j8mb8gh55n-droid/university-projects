/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gp_phonedirectory;

/**
 *
 * @author mac
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class GP_PhoneDirectory {

    static   PhDirectory d = new PhDirectory();
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
      
        d.directorySample();
        int option = 0;
        boolean flag = true;
        while (flag) {
            try {
                do {

                    System.out.println("\n\t----------------------Phone Directory----------------------");
                    System.out.println("\t\t\t\tMain Menu: ");
                    System.out.println("\n1. User Guide");
                    System.out.println("2. add contact information");
                    System.out.println("3. delete contact information");
                    System.out.println("4. search for contact information");
                    System.out.println("5. display all");
                    System.out.println("6. search history");
                    System.out.println("7. recent search");
                    System.out.println("8. clear history");
                    System.out.println("9. search statistics");
                    System.out.println("10. Exit Phone Directory");
                    System.out.print(">>");
                    // take user input
                    option = user.nextInt();

                    switch (option) {
                        case 1:
                            userGuide();
                            break;
                        case 2:
                            d.insertContact();
                            break;
                        case 3:
                            d.deleteContact();
                            break;
                        case 4:
                            searchType();
                            break;
                        case 5:
                            d.showAll();
                            
                            break;
                        case 6:
                            d.displaySearchHistory();
                            break;
                        case 7:
                            d.recentSearchHistory();
                            break;
                        case 8:
                            d.clearSearchHistory();
                            break;
                        case 9:
                            d.searchStats();
                            break;
                        case 10:
                            System.out.println("\t\tGOODBYE");
                            break;
                        default:
                            System.out.println("Enter a valid number option!");
                    }// end switch

                    flag = false;
                } while (option != 10); // end loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid option\n" + e);
                user.nextLine();
            }
        }// end flag loop
    }// end main

    public static void userGuide() {
        for (int i = 0; i < 90; i++) {
            System.out.print("-");
        }
        System.out.println("\nGETTING STARTED:");
        System.out.println("\nTO ADD CONTACT INFORMATION:\n*first specify the type of contact*");
        System.out.println("1.PERSONAL CONTACT:");
        // PS
        System.out.println("to add a personal contact choose option '2' from the main menu");
        System.out.println("choose option '1' from the add contact menu");
        System.out.println("insert the contact information");
        System.out.println("information required:" + "\n(full name),(phone number),(place of birth)");
        System.out.println("2.BUSINESS CONTACT:");
        // BS
        System.out.println("to add a business contact choose option '2' from the main menu");
        System.out.println("choose option '2' from the add contact menu");
        System.out.println("insert the contact information");
        System.out.println("information required:" + "\n(name of the business enterprise),(phone number),(business email),(address of corporation),(valid registration year)");

        System.out.println("\nTO REMOVE CONTACT INFORMATION:");
        //REMOVE
        System.out.println("to remove contact information choose option '3' from the main menu");
        System.out.println("insert the phone number you want to remove,");
        System.out.println("confirm the process and the number will be removed");
        System.out.println("*incase you change your mind insert '2' to cancel the removal process*");

        System.out.println("\nSEARCH BY FILTER:");
        // seearch type
        System.out.println("to search based on a specific filter choose option '4' from the main menu");
        System.out.println("choose the search filter you want from the search type menu");
        System.out.println("insert the information needed");
        for (int i = 0; i < 90; i++) {
            System.out.print("-");
        }
        System.out.println(" ");
    }

    public static void searchType() {
        Scanner user = new Scanner(System.in);
     
        boolean flag = true;
        int option = 0;
        while (flag) {
            try {
                do {
                    System.out.println("1.search By Name");
                    System.out.println("2.search by Number");
                    System.out.println("3.search by first letter");
                    System.out.println("4.search by region");
                    System.out.println("5.back to main menu");
                    System.out.print(">>");
                    // take user input
                    option = user.nextInt();
                    switch (option) {
                        case 1:
                            d.lookbyname();
                            break;
                        case 2:
                            d.lookbynumber();
                            break;
                        case 3:
                            d.lookAlphabet();
                            break;
                        case 4:
                            d.lookbyregion();
                            break;
                        case 5: //back to main
                            break;
                        default:
                            System.out.println("Enter a valid number option!");
                    }// end switch

                } while (option != 5); // end loop
                flag = false;

            } catch (InputMismatchException e) {
                System.out.println("Invalid option\n" + e);
                user.nextLine();
            }// end catch
        }//end flag loop
    }

   

}
