/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication13;

import java.util.*;

/**
 *
 * @author mac
 */
public class GenericStack<E> {
    private List<E> list = new ArrayList<>();
    
    public int getSize(){
        return list.size();
    }
    
    public void push(E o){
        list.add(o);
    }
    
    public E pop(){
        E removedItem = list.remove(getSize()-1);
        return removedItem;
    }

    @Override
    public String toString() {
        return "GenericStack{" + "list=" + list.toString()+ '}';
    }
    
    
}
