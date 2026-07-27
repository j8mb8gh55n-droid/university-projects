/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algorithemsproject;

/**
 *
 * @author mac
 */
public class AlgorithemsProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CocktailSort Cs = new CocktailSort();
		int c[] = { 8, 1, 4, 2, 9, 0, 3 };
		Cs.cocktailSort(c);
		System.out.println("Result of The Sorted array:");
		Cs.printArray(c);
	
    }
    
}



	


	

