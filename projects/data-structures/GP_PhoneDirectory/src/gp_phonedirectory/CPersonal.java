/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gp_phonedirectory;

/**
 *
 * @author mac
 */
public class CPersonal extends Contacts{
 private String placeOfBirth;
    //-----------------------------constructor----------------------------------
    public CPersonal(String name, int phoneNum,String placeOfBirth) {
        super(name, phoneNum);
        this.placeOfBirth = placeOfBirth;
    }
    //-----------------------------End constructor------------------------------
    
    //------------------------------setters-------------------------------------
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }
    //------------------------------End setters---------------------------------
    
    //------------------------------getters-------------------------------------
      public String getPlaceOfBirth() {
        return placeOfBirth;
    }
    //------------------------------End getters---------------------------------
 
    //------------------------------toString------------------------------------
        @Override
    public String toString() {
        
        return "CPersonal{"+ super.toString() + " placeOfBirth=" + placeOfBirth + '}';
    }
    //------------------------------End toString--------------------------------

  
 
 
}
