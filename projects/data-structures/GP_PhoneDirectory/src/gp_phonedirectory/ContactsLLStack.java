/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gp_phonedirectory;

/**
 *
 * @author mac
 */
public class ContactsLLStack<E> {
    //-------------------------------- Node Class --------------------------------------- 

    static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public void setelement(E element) {
            this.element = element;
        }
    }
    //-------------------------------- End Node Class ---------------------------------------

    //-------------------------------- QUIERY METHODS ---------------------------------------
    private Node<E> top;
    private int size;

    public ContactsLLStack() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E top() {
        if (isEmpty()) {
            return null;
        }
        return top.getElement();
    }

    public void push(E elem) {
        Node<E> v = new Node<E>(elem, top);
        top = v;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E temp = top.getElement();
        top = top.getNext();
        size--;
        return temp;
    }
    //-------------------------------- END QUIERY METHODS -----------------------------------

    //-------------------------------- MEMBER METHODS ---------------------------------------
    //-------------------------------------display-------------------------------------------
    public void displayStack() {
        
        if (isEmpty()) {
            System.out.println("Stack is currently empty!");
        } else {
            
            ContactsLLStack<E> ts = new ContactsLLStack<>();
            
            System.out.println("----------------------------------------------");
            System.out.println("\t\t\tSTACK INFORMATION:\t\t\t");
            System.out.println("----------------------------------------------");
          
            while (!isEmpty()) {
               
                E ele = pop();

                System.out.println(ele);
                System.out.println("----------------------------------------------");

                
                ts.push(ele);

            }//end original stack loop

           
            while (!ts.isEmpty()) {
                
                E restore = ts.pop();
                
                push(restore);
            }//end temporary stack loop

        }//end else   

    }
    //-------------------------------------End display---------------------------------------
    //-------------------------------------search occurance----------------------------------
    public int searchOccurance(int onum) {
        int occured = 0;
        
        ContactsLLStack<E> temp = new ContactsLLStack<>();
        
        while (!isEmpty()) {
            
            E elm = pop();
            if (((Contacts) elm).getPhoneNum() == onum) {

               
                occured++;
                System.out.println("occurance of search: " + occured);

            }
            
            temp.push(elm);
        }
        while (!temp.isEmpty()) {
           
            push(temp.pop());
        }
        
        return occured;
    }
    //-------------------------------------End search occurance------------------------------

    public ContactsSinglyLinkedList<CPersonal> searchedPersonalContacts() {

        ContactsSinglyLinkedList<CPersonal> pList = new ContactsSinglyLinkedList<>();
        ContactsLLStack<E> ts = new ContactsLLStack<>();

        while (!isEmpty()) {
            E ele = pop();
            if (ele instanceof CPersonal) {
                pList.addLast((CPersonal) ele);
            }
            ts.push(ele);
        }

        while (!ts.isEmpty()) {
            E restore = ts.pop();
            push(restore);
        }

        return pList;

    }

    public ContactsSinglyLinkedList<CBusiness> searchedBusinessContacts() {

        ContactsSinglyLinkedList<CBusiness> bList = new ContactsSinglyLinkedList<>();
        ContactsLLStack<E> ts = new ContactsLLStack<>();

        while (!isEmpty()) {
            E ele = pop();
            if (ele instanceof CBusiness) {
                bList.addLast((CBusiness) ele);
            }
            ts.push(ele);
        }

        while (!ts.isEmpty()) {
            E restore = ts.pop();
            push(restore);
        }

        return bList;

    }

    public Contacts mostSearchedContact() {
        Contacts maxContact = (Contacts) top();
        int maxSearched = searchOccurance(maxContact.getPhoneNum());

        ContactsLLStack<E> ts = new ContactsLLStack<>();
        while (!isEmpty()) {
            E ele = pop();
            int searchedCount = searchOccurance(((Contacts) ele).getPhoneNum());
            if (searchedCount > maxSearched) {
                maxSearched = searchedCount;
                maxContact = (Contacts) ele;
            }

            ts.push(ele);
        }

        while (!ts.isEmpty()) {
            E restore = ts.pop();
            push(restore);
        }
        return maxContact;

    }

    //-------------------------------- END MEMBER METHODS -----------------------------------
}


