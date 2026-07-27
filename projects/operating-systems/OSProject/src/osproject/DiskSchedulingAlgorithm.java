/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package osproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mac
 */
public class DiskSchedulingAlgorithm {

    Scanner diskscanner = new Scanner(System.in);

    public void diskChoices() {
        int choice;

        while (true) {
            pagemenu();

            try {
                choice = Integer.parseInt(diskscanner.nextLine());

                switch (choice) {
                    case 1:
                        getDiskInputs(1); // FCFS
                        break;
                    case 2:
                        getDiskInputs(2); // SSTF
                        break;
                    case 3:
                        getDiskInputs(3); // SCAN
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("please choose a number from the menu!");
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid input! please enter a number.");
            }
        }
    }

    public void pagemenu() {
        System.out.println("--- diskAlgorithm ---");
        System.out.println("\t1.FCFS\n\t2.SSTF\n\t3.SCAN\n\t4.back to main menu");
    }

    public void getDiskInputs(int algoChoice) {
        int[] queue = new int[15];
        int totalCylinders = 0;
        int head = 0;
        String direction = "right";

        while (true) {
            try {
                System.out.print("enter total number of cylinders: ");
                totalCylinders = Integer.parseInt(diskscanner.nextLine());
                if (totalCylinders > 0) {
                    break;
                }
                System.out.println("must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("enter a valid number.");
            }
        }

        while (true) {
            try {
                System.out.print("enter current head position: ");
                head = Integer.parseInt(diskscanner.nextLine());
                if (head >= 0 && head < totalCylinders) {
                    break;
                }
                System.out.println("must be within disk range.");
            } catch (NumberFormatException e) {
                System.out.println("enter a valid number.");
            }
        }

        System.out.println("enter 15 disk requests (space-separated):");
        while (true) {
            try {
                String[] inputs = diskscanner.nextLine().trim().split("\\s+");
                if (inputs.length != 15) {
                    System.out.println("you must enter exactly 15 numbers.");
                    continue;
                }
                for (int i = 0; i < 15; i++) {
                    queue[i] = Integer.parseInt(inputs[i]);
                    if (queue[i] < 0 || queue[i] >= totalCylinders) {
                        throw new NumberFormatException();
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid input. numbers must be within disk range.");
            }
        }

        if (algoChoice == 3) {
            while (true) {
                System.out.print("enter head direction (left/right): ");
                direction = diskscanner.nextLine().trim().toLowerCase();
                if (direction.equals("left") || direction.equals("right")) {
                    break;
                }
                System.out.println("please enter 'left' or 'right'.");
            }
        }

        switch (algoChoice) {
            case 1:
                fcfs(queue, head);
                break;
            case 2:
                sstf(queue, head);
                break;
            case 3:
                scan(queue, head, totalCylinders, direction);
                break;
            default:
                System.out.println("invalid algorithm choice.");
        }
    }

    public void fcfs(int[] queue, int head) {
        int totalSeek = 0;
        System.out.print("\nFCFS sequence: " + head);
        for (int req : queue) {
            totalSeek += Math.abs(head - req);
            head = req;
            System.out.print(" -> " + req);
        }
        System.out.println("\ntotal seek distance: " + totalSeek + " cylinders");
    }

    public void sstf(int[] queue, int head) {
        List<Integer> requestList = new ArrayList<>();
        for (int req : queue) {
            requestList.add(req);
        }

        int totalSeek = 0;
        System.out.print("\nSSTF sequence: " + head);

        while (!requestList.isEmpty()) {
            int closest = requestList.get(0);
            int minDistance = Math.abs(head - closest);
            for (int req : requestList) {
                int dist = Math.abs(head - req);
                if (dist < minDistance) {
                    minDistance = dist;
                    closest = req;
                }
            }
            totalSeek += Math.abs(head - closest);
            head = closest;
            requestList.remove(Integer.valueOf(closest));
            System.out.print(" -> " + closest);
        }

        System.out.println("\ntotal seek distance: " + totalSeek + " cylinders");
    }

    public void scan(int[] queue, int head, int totalCylinders, String direction) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int totalSeek = 0;

        for (int req : queue) {
            if (req < head) {
                left.add(req);
            } else {
                right.add(req);
            }
        }

        Collections.sort(left);
        Collections.sort(right);

        System.out.print("\nSCAN sequence: " + head);

        if (direction.equals("right")) {
            for (int req : right) {
                totalSeek += Math.abs(head - req);
                head = req;
                System.out.print(" -> " + req);
            }
            if (!left.isEmpty()) {
                totalSeek += Math.abs(head - (totalCylinders - 1));
                head = totalCylinders - 1;
                System.out.print(" -> " + head);
                Collections.reverse(left);
                for (int req : left) {
                    totalSeek += Math.abs(head - req);
                    head = req;
                    System.out.print(" -> " + req);
                }
            }
        } else {
            Collections.reverse(left);
            for (int req : left) {
                totalSeek += Math.abs(head - req);
                head = req;
                System.out.print(" -> " + req);
            }
            if (!right.isEmpty()) {
                totalSeek += Math.abs(head - 0);
                head = 0;
                System.out.print(" -> " + head);
                for (int req : right) {
                    totalSeek += Math.abs(head - req);
                    head = req;
                    System.out.print(" -> " + req);
                }
            }
        }

        System.out.println("\ntotal seek distance: " + totalSeek + " cylinders");
    }
}
