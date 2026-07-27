/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication13;

/**
 *
 * @author mac
 */
public class GenericsPracticeCar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       GenericStack<Student> st = new GenericStack<>();
       GenericStack<Car> ct = new GenericStack<>();
       
       st.push(new Student("N",1));
       st.push(new Student("M",2));
       st.push(new Student("k",6));
       
       ct.push(new Car("benz",2025));
       ct.push(new Car("benz",2024));
       ct.push(new Car("benz",2026));
       
        System.out.println(st);
        System.out.println(ct);
        
        Student[] sa = {new Student("N",1),new Student("k",6)};
        Car[] ca = {new Car("benz",2025),new Car("benz",2024)};

        printArray(sa);
        printArray(ca);
    }
    public static <E> void printArray(E[] array){
        for(int i=0; i < array.length; i++){
            System.out.println(array[i]);
        }

    }
}
