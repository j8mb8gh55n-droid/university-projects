
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gp_phonedirectory;

/**
 *
 * @author mac
 */
import java.util.Scanner;
// the helper class //
public class PhDirectory implements Lookable {
    
    private ContactsSinglyLinkedList<Contacts> ListOfContacts;
    private ContactsLLStack<Contacts> history;
    Scanner input = new Scanner(System.in);
    Contacts cc;

    public PhDirectory() {
        // creation
        ListOfContacts = new ContactsSinglyLinkedList<>();
        history = new ContactsLLStack<>();
    }
    //----------------------------------------------------------------------------
    // methods add,delete,show,search, stats

    public void insertContact() {
        int option = 0;
        boolean flag = true;
        int pnum;
        int bnum;
        do {
            System.out.println("Choose the contact type: \n1.Personal contact\n2.Business contact.");
            System.out.println("enter 3 to go back to main menu.");
            System.out.print(">>");

            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter a name: ");
                    String name = input.next();
                    do {

                        System.out.println("Enter the Number(9 digits): ");
                         pnum = input.nextInt();

                        flag = checkNumber(pnum);
                        if (flag == true) {
                            break;
                        } else {
                            System.out.println("Invalid number\n");
                        }

                    } while (true);
                    System.out.println("Enter the place of birth: ");
                    String birth = input.next();
                    cc = new CPersonal(name, pnum, birth);
                    ListOfContacts.sortingElm(cc);
                    System.out.println("Your personal contact information has been added!");
                    break;
                case 2:
                    System.out.println("Enter the Trade name: ");
                    String trade = input.next();

                    do {
                        System.out.println("Enter the Business number(9 digits): ");
                         bnum = input.nextInt();
                        flag = checkNumber(bnum);
                        if (flag == true) {
                            break;
                        } else {
                            System.out.println("Invalid number\n");

                        }

                    } while (true);

                    System.out.println("Enter the email: ");
                    String email = input.next();
                    System.out.println("Enter the location of the business's operations 'company address'\nEnter  city: ");
                    String city = input.next();
                    System.out.println("Enter street name: ");
                    String street = input.next();
                    System.out.println("Enter the zipcode: ");
                    int zipcode = input.nextInt();
                    Address adr = new Address(city, street, zipcode);
                    System.out.println("Enter lisence register year: ");
                    int year = input.nextInt();
                    cc = new CBusiness(trade, bnum, email, adr, year);
                    ListOfContacts.sortingElm(cc);
                    System.out.println("Your business information has been added!");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Please choose a proper option! ");

            }

        } while (option != 3);
        
    }

    public void deleteContact() {
        System.out.println("Enter the number you want to delete: ");
        int num = input.nextInt();
        boolean flag = true;
        while (flag) {
            try {
                checkNumber(num);
                flag = false;
            } catch (Exception e) {
                System.out.println("Invalid number " + e + "\n");
                input.nextLine();
            }
        }
        cc = ListOfContacts.lookupContact(num);
        if (cc == null) {
            System.out.println("Number is not found!");
        } else {
            System.out.println("confirm if this is the phone number you want to remove: " + cc + "\nEnter 1\nEnter 2 to cancel");
            int confirm = input.nextInt();
            switch (confirm) {
                case 1:
                    ListOfContacts.removeE(cc);
                    System.out.println("Contact information has been removed!");
                    break;
                case 2:
                    System.out.println("Removal process cancelled!");
                    break;
                default:
                    System.out.println("please Enter 1 to confirm or 2 to cancel");
            }

        }
    }

    public void showAll() {
        if (ListOfContacts.isEmpty()) {
            System.out.println("THE DIRECTORY IS CURRENTLY EMPTY!");
        } else {
            ListOfContacts.displayList();
        }
    }
    
    public void searchStats(){
        
        if (history.isEmpty()) {
            System.out.println("Nothing to display yet!");
            printLine();
            System.out.println("\n*try out our program and start looking*");
            printLine();
        } else {
            
            printLine();
            System.out.println("Directory statistics");
            printLine();
            System.out.print("MOST SEARCHED CONTACT: ");
            history.mostSearchedContact();
            printLine();
            System.out.println("SEARCHED PERSONAL CONTACTS: ");
            ContactsSinglyLinkedList<CPersonal> personal = history.searchedPersonalContacts();
            System.out.println("count: "+ personal.size());
            personal.displayList();
            printLine();
            System.out.println("SEARCHED BUSINESS CONTACTS: ");
            ContactsSinglyLinkedList<CBusiness> business = history.searchedBusinessContacts();
            System.out.println("count: "+ business.size());
            business.displayList();
            printLine();
            System.out.println("SEARCH OCCURANCE: ");

        }
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    // over ridden methods
    @Override
    public void lookbynumber() {
        System.out.println("Enter the number you want to look for: ");
        int num = input.nextInt();

        if (checkNumber(num)) {
            Contacts c = ListOfContacts.lookupContact(num);
            if (c == null) {
                System.out.println("Number Not Found!");
            } else {
                // if found print information
                System.out.println("Number Found: ");
                System.out.println(c);
                history.searchOccurance(num);
                // the number we are looking for will be added to a stack
                history.push(c);
            }
        } else {
            System.out.println("Invalid number ");
        }

    }

    @Override
    public void lookbyname() {
        boolean flag = false;
        int size = ListOfContacts.size();
        System.out.println("Enter the contact name: ");
        String name = input.next();
     
      
        
        
        for (int i = 0; i < size; i++) {
            Contacts nm = ListOfContacts.removeFirst();
          
            
            
            if (nm.getName().equals(name)) {
               
                System.out.println("Name Found: ");
                System.out.println(nm);
                
                history.push(nm);
                flag = true;
            }
            
            
            
            ListOfContacts.addLast(nm);
        }
        
        
        if (!flag) {
            System.out.println("Name Not Found!");
        }

    }

    @Override
    public void lookbyregion() {

        System.out.println("Enter City");
        String city = input.next();

        ContactsSinglyLinkedList<CBusiness> list = ListOfContacts.lookbyregion(city);

        if (!list.isEmpty()) {
            list.displayList();
        } else {
            System.out.println("No Information Found!");
        }
    }

    @Override
    public void lookAlphabet() {

        System.out.println("Enter the (first) letter: ");
        // input will be the first index "0" = first letter of string
        char first = input.next().charAt(0);

        ContactsSinglyLinkedList<Contacts> cList = ListOfContacts.contactsStartWith(first);
        if (!cList.isEmpty()) {
            System.out.println("The Contacts that start with " + first + "are: ");
            int size = cList.size();
            // traverse the list
            for (int i = 0; i < size; i++) {
                Contacts c = cList.removeFirst();
                System.out.println(c);
                // added to a stack
                history.push(c);

                cList.addLast(c);
            }
        } else {
            System.out.println("No Information With the letter" + first + " is Found!");
        }
    }
    //--------------------------------------------------------------------------

    public void removeDuplicates() {

        ListOfContacts.removeDuplicate();
    }

    //--------------------------------------------------------------------------
    //history method:display,recent,occourance,clear
    public void displaySearchHistory() {
        if (history.isEmpty()) {
            System.out.println("Nothing to display yet!");
            printLine();
            System.out.println("\n*try out our program and start looking*");
            printLine();
        } else {
            history.displayStack();
        }
    }

    public void recentSearchHistory() {
        if (!history.isEmpty()) {
            System.out.println("Latest Search: ");
            printLine();
            System.out.println("\n");
            // by using the top method we can check the last searched
            System.out.println(history.top());
            printLine();
            System.out.println("");

        } else {
            System.out.println("Nothing to display yet!");
            printLine();
            System.out.println("\n*try out our program and start searching*");
            printLine();
            System.out.println("");
        }
    }

    public void clearSearchHistory() {
        if (history.isEmpty()) {
            System.out.println("empty: nothing to remove yet!");
        } else {
            while (!history.isEmpty()) {
                history.pop();
            }
            System.out.println("Data has been cleared!");
        }
    }

    //-------------------------------------------------------------------------- 
    //--------------------------------------------------------------------------
    // validate method
    public boolean checkNumber(int number) {
        String num = number + "";
        if (num.length() != 9) {
            return false;
        }
        return true;

    }
    // sample
     public void directorySample() {
        //personal sample
        Contacts p1 = new CPersonal("Layan",505119707,"Riyadh");
        Contacts p2 = new CPersonal("Reema",588279279,"London");
        Contacts p3 = new CPersonal("Jouri",574933433,"Amsterdam");
        //business sample
        Contacts b1 = new CBusiness("Alibaba",888999337,"alibabaco@yahoo.com",new Address("Riyadh","Tahlia st",12271),2003);
        Contacts b2 = new CBusiness("Google",77755444,"googleco@yahoo.com",new Address("Riyadh","Olaya st",12271),2009);
        Contacts b3 = new CBusiness("Microsoft",333555000,"microsoftco@yahoo.com",new Address("Jeddah","Prince sultan st",23625),2008);
        
        ListOfContacts.sortingElm(p1);
        ListOfContacts.sortingElm(p2);
        ListOfContacts.sortingElm(p3);
        
        ListOfContacts.sortingElm(b1);
        ListOfContacts.sortingElm(b2);
        ListOfContacts.sortingElm(b3);

                 
        
        

    }

    private void printLine() {
        for (int i = 0; i < 90; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
