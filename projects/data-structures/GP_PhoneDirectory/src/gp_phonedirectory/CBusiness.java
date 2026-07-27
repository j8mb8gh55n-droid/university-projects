/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gp_phonedirectory;

/**
 *
 * @author mac
 */
public class CBusiness extends Contacts{
    private String email;
    private int regYear;
    private Address address; 
    //-----------------------------constructor----------------------------------
    public CBusiness(String name, int phoneNum,String email,Address address, int regYear) {
        super(name, phoneNum);
        this.email = email; 
        this.regYear = regYear;
        this.address = address;
    }
    //-----------------------------End constructor------------------------------
    
    
    //------------------------------setters-------------------------------------
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAdress(Address address){
        this.address = address;
    }
    public void setRegYear(int regYear){
        this.regYear = regYear;
    }
    //------------------------------End setters---------------------------------
    
    //------------------------------getters-------------------------------------
     public String getEmail() {
        return email;
    }
     public Address getAddress(){
         return address;
     }
     public int getRegYear(){
         return regYear;
     }
    //------------------------------End getters---------------------------------
   
    //------------------------------toString------------------------------------
     @Override
    public String toString() {
        return "CBusiness{"+ super.toString() + " email=" + email + " address="+ address + " regYear="+ regYear +'}';
    }
    //------------------------------End toString--------------------------------

    

   

    

    
}
