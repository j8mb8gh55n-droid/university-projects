/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gp_phonedirectory;

/**
 *
 * @author mac
 */
public class Address {
    private String city;
    private String street;
    private int zipCode;
    //-----------------------------constructor----------------------------------
    public Address(String city, String street, int postCode) {
        this.city = city;
        this.street = street;
        this.zipCode = postCode;
    }
    //-----------------------------End constructor------------------------------
    
    
    //------------------------------setters-------------------------------------
    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostCode(int postCode) {
        this.zipCode = postCode;
    }
    //------------------------------End setters---------------------------------
    
    
    //------------------------------getters-------------------------------------
    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getPostCode() {
        return zipCode;
    }

    //------------------------------End getters---------------------------------
    
    
    
    //------------------------------toString------------------------------------
    @Override
    public String toString() {
        return "Address{" + "city=" + city + ", street=" + street + ", postCode=" + zipCode + '}';
    }
    //------------------------------End toString--------------------------------

    

    
    
    

    
}
