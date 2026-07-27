/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithemsproject;

/**
 *
 * @author mac
 */
public class CocktailSort {
    
    // in this class the are two methods 
    //1. for the algorithmic formula 2.print the array
    
    public void cocktailSort(int a[])
	{
		boolean flag = true;
		int start = 0;
		int end = a.length;

		while (flag == true) 
		{
                    // Reset the flag when entering the loop in case it was set to true before.
			flag = false;

			// loop starts from the bottom to the top
			for (int i = start; i < end - 1; ++i) 
			{
				if (a[i] > a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					flag = true;
				}
			}
                        
			// if no change = array is already sorted.
			if (flag == false)
				break;
                        //If not, reset the swapped flag for the next stage.
			flag = false;

			
			// Move the end back by one (end-1) because the last item is in the right positions.
			end = end - 1;

			
			// repeate steps from top to bottom
			for (int i = end - 1; i >= start; i--) 
			{
				if (a[i] > a[i + 1]) 
				{
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					flag = true;
				}
			}

                        //Increase the starting point because the next smallest number is already in place.
			start = start + 1;
		}
	}
        
        //print the array
	public void printArray(int a[])
	{
		int n = a.length;
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

}
