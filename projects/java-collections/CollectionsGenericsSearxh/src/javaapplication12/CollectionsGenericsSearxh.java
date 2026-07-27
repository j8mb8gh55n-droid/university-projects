/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author mac
 */
public class CollectionsGenericsSearxh {

    /**
     * @param args the command line arguments
     */
    
    public static void binraySearch(List<Student> list, Integer id){
        // sort the list
        Collections.sort(list,Comparator.comparing(Student::getId));
        
        // create an instance of student
        Student s = new Student(id,"");
        
        // create index using binray sreach list,intance,comparator
        
        int index = Collections.binarySearch(list, s, Comparator.comparing(Student::getId));
        
        // condition check and print
        if(index>=0){
        System.out.println("id: " + id + ", at index: " + index);
        } else {System.out.println("not found");}
    }
    
    public static void main(String[] args) {
       
        List<Integer> list1 = Arrays.asList(5, 8, 2, 10);
        List<Integer> list2 = Arrays.asList(7, 3, 9, 1);

       List<Student> sl = new ArrayList<>();
       sl.add(new Student(4,"sara"));
       sl.add(new Student(5,"reem"));
       sl.add(new Student(5,"sara"));
       sl.add(new Student(11,"noura"));
       binraySearch(sl, 5);
       
        System.out.println("List 1: " + list1);
        System.out.println("Min of List 1: " + min(list1));
        System.out.println("Sum of List 1: " + sum(list1));

        System.out.println("List 2: " + list2);
        System.out.println("Min of List 2: " + min(list2));
        System.out.println("Sum of List 2: " + sum(list2));
    }
    public static <E extends Comparable<E>> E min(List<E> list){
        E min = list.get(0); // start traversing from first index
        // enhanced for for traversing
        for(E m : list){
            if(m.compareTo(min)<0){
                min = m; // update the value of min to m
            }
        }
        return min;
    }
    
    
    public static <E extends Comparable<E>> E max(List<E> list){
        E max = list.get(0);
        
        for(E m : list){
            if(m.compareTo(max)>0){
                max = m;
            }
        }
        
        return max;
    }
    
    
    public static int sum(List<Integer> list){
        
        
        int total =0;
        for(int i : list){
            total +=i;
        }
        return total;
    }
}
