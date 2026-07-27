/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package osproject;

import java.util.Scanner;

/**
 *
 * @author mac
 */
public class OSProject {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n--- ALGORITHM CHOICES MENU ---");
            System.out.println("\t1. Page Replacement");
            System.out.println("\t2. Disk Scheduling");
            System.out.println("\t0. Exit Program");
            System.out.print("> ");

            try {
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {
                    case 1:

                        PageReplacementAlgorithm p = new PageReplacementAlgorithm();
                        p.PageChoices();
                        break;

                    case 2:
                        DiskSchedulingAlgorithm d = new DiskSchedulingAlgorithm();
                        d.diskChoices();
                        break;

                    case 0:
                        System.out.println("Thank you for using the program. Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid choice. Please select 0, 1, or 2.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
}
