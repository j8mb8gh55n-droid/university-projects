/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gp_phonedirectory;

/**
 *
 * @author mac
 */
public class ContactsSinglyLinkedList<E> {
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
    // head,tail,size
    private Node head = null;
    private Node tail = null;
    private int size;

    // constructor : DEFAULT
    public ContactsSinglyLinkedList() {
    }

    // methods (size, isEmpty, first : element, last : element)
    //1
    public int size() {
        return size;
    }

    //2
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    //3
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return (E) head.getElement();
    }

    //4
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return (E) tail.getElement();
    }

    //-------------------------------- END QUIERY METHODS -----------------------------------
    //-------------------------------- UPDATE METHODS ---------------------------------------
    public void addFirst(E e) {
        head = new Node<E>(e, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> n = new Node<>(e, null);
        if (isEmpty()) {
            head = n;
        } else {
            tail.setNext(n);
        }
        tail = n;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E elm = (E) head.getElement();
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return elm;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            E elm = (E) tail.getElement();
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                Node<E> c = head;
                Node<E> t = null;
                while (c.getNext() != null) {
                    t = c;
                    c = c.getNext();
                }
                t.setNext(null);
                tail = t;
            }
            size--;
            return elm;
        }
    }
    //-------------------------------- END UPDATE METHODS -----------------------------------

    //-------------------------------- MEMBER METHODS ---------------------------------------
    //displayC,sortC,removeC,removeduplicateC
    //-------------------------------------sorting------------------------------------------
    public void sortingElm(E elm) {
       
        Node<E> nn = new Node<>(elm, null);
        
        Node<E> c = head;
       
        Node<E> p = null;

        
        while (c != null && ((Contacts) elm).getName().compareTo(((Contacts) c.getElement()).getName()) > 0) {
           
            p = c;
         
            c = c.getNext();
        }// end loop

            if (p == null) {
            
            nn.setNext(head);
           
            head = nn;
        } 
        else {

            
            p.setNext(nn);
            
            nn.setNext(c);
        }
        
        if (nn.getNext() == null) {
            
            tail = nn;
        }

        
        size++;
    }
    //-------------------------------------End sort------------------------------------------

    //-------------------------------------removeDuplicate-----------------------------------
    public E removeDuplicate() {
        
        if (isEmpty()) {
            return null;
        } else {
            Node<E> current = head;
            Node<E> temp = current;
           
            while (current != null) {
                temp = current;
               
                while (temp.getNext() != null) {
                   
                    if (temp.getNext().getElement().equals(current.getElement())) {
                       
                        temp.setNext(temp.getNext().getNext());
                    } else {
                        temp = temp.getNext();
                    }
                }
               
                current = current.getNext();
            }

            
            E dup = temp.getNext().getElement();

            
            size--;
            
            return dup;
        }
    }
    //-------------------------------------End removeDuplicate-------------------------------

    //-------------------------------------remove element------------------------------------
    public E removeE(E elm) {
       
        if (isEmpty()) {
            return null;
        }
        
        if (head.getElement() == elm) {

            E data = (E) head.element;

            head = head.next;
            
            if (head == null) {
                tail = null;
            }
           
            size--;
            
            return data;
        }
       
        Node<E> c = head;
        while (c.getNext() != null && c.getNext().getElement() != elm) {
           
            c = c.getNext();
        }
        
        if (c.getNext() == null) {
            return null;
        }

        E data = c.getNext().getElement();
        
        c.next = c.next.next;
         
        if (c.next == null) {
            
            tail = c;
        }
        
        size--;
        
        return data;

    }
    //-------------------------------------End remove element--------------------------------

    //-------------------------------------display-------------------------------------------
    public void displayList() {
        
        if (isEmpty()) {
            System.out.println("List is currently empty!");
        } else {
            
            Node<E> c = head;
            
            System.out.println("------------------------------------------------------------");
            System.out.println("\t\t\t||LIST INFORMATION:||");
            System.out.println("------------------------------------------------------------");
            while (c != null) {
                
                System.out.println("------------------------------------------------------------");
                System.out.println(c.getElement());
                System.out.println("------------------------------------------------------------");

                
                c = c.getNext();
            }

        }

    }
    //-------------------------------------End display---------------------------------------

    public ContactsSinglyLinkedList<CBusiness> lookbyregion(String region) {

        ContactsSinglyLinkedList<CBusiness> list = new ContactsSinglyLinkedList<>();
        Node<E> current = head;
        while (current != null) {

            if (current.getElement() instanceof CBusiness) {
                CBusiness c = (CBusiness) current.getElement();
                if (c.getAddress().getCity().equals(region)) {
                    list.addLast(c);
                }

            }
            current = current.getNext();
        }

        return list;
    }

    public int countCPersonalContacts() {
        int count = 0;
        Node<E> current = head;
        while (current != null) {

            if (current.getElement() instanceof CPersonal) {
                count++;

            }
            current = current.getNext();
        }
        return count;
    }

    public Contacts lookupContact(int phoneNum) {

        Node<E> current = head;
        while (current != null) {

            Contacts c = (Contacts) current.getElement();
            if (c.getPhoneNum() == phoneNum) {
                return c;
            }

            current = current.getNext();
        }

        return null;//not found
    }

    public ContactsSinglyLinkedList<Contacts> contactsStartWith(char letter) {

        ContactsSinglyLinkedList<Contacts> list = new ContactsSinglyLinkedList<>();
        Node<E> current = head;
        while (current != null) {
            Contacts contact = (Contacts) current.getElement();
            if (contact.getName().charAt(0) == letter) {
                list.addLast(contact);
            }

            current = current.getNext();
        }

        return list;
    }

    //-------------------------------- END MEMBER METHODS -----------------------------------
}//end class

