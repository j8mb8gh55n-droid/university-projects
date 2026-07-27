/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gp_phonedirectory;

/**
 *
 * @author mac
 */
public abstract class Contacts {
    private String name;
    private int phoneNum;
    
    //-----------------------------constructor----------------------------------
    public Contacts(String name, int phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
        
    }
    //-----------------------------End constructor------------------------------
    
    //------------------------------setters-------------------------------------
     public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    //------------------------------End setters---------------------------------
    
    //------------------------------getters-------------------------------------
    public String getName() {
        return name;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    
    //------------------------------End getters---------------------------------
    
    
    //------------------------------toString------------------------------------
    @Override
    public String toString() {
        return "Contacts{" + "name=" + name + ", phoneNum=" + phoneNum +'}';
    }
    //------------------------------End toString--------------------------------

   

    

    

    
}
