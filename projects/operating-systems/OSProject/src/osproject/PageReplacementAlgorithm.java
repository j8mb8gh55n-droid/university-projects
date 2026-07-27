package osproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PageReplacementAlgorithm {

    Scanner pagescanner = new Scanner(System.in);

    public void PageChoices() {
        int choice;

        while (true) {
            pagemenu();

            try {
                choice = Integer.parseInt(pagescanner.nextLine());

                switch (choice) {
                    case 1:
                        pagesandframes(1); // FIFO
                        break;
                    case 2:
                        pagesandframes(2); // OPTIMAL
                        break;
                    case 3:
                        pagesandframes(3); // LRU
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Please choose a number from the menu!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    public void pagemenu() {
        System.out.println("--- PageReplacementAlgorithm ---");
        System.out.println("\t1.FIFO\n\t2.OPTIMAL\n\t3.LRU\n\t4.back to main menu\n>");
    }

    public void fifo(int[] pages, int frames) {
        List<Integer> framelist = new ArrayList<>();
        int pointer = 0;
        int pageFaults = 0;

        for (int page : pages) {
            if (!framelist.contains(page)) {
                if (framelist.size() < frames) {
                    framelist.add(page);
                } else {
                    framelist.set(pointer, page);
                    pointer = (pointer + 1) % frames;
                }
                pageFaults++;
                System.out.println("this page caused a fault " + page + " Memory: " + framelist);
            } else {
                System.out.println("already in memory " + page + " Memory: " + framelist);
            }
        }

        int withReplacement = Math.max(0, pageFaults - frames);
        int withoutReplacement = Math.min(pageFaults, frames);
        System.out.println("Page Faults without Replacement: " + withoutReplacement);
        System.out.println("Page Faults with Replacement: " + withReplacement);
        System.out.println("Total Page Faults: " + pageFaults);
    }

    public void optimal(int[] pages, int frames) {
        List<Integer> pageFrames = new ArrayList<>();
        int pageFaults = 0;

        for (int i = 0; i < pages.length; i++) {
            int currentPage = pages[i];

            if (!pageFrames.contains(currentPage)) {
                pageFaults++;

                if (pageFrames.size() < frames) {
                    pageFrames.add(currentPage);
                } else {
                    int indexToReplace = -1;
                    int farthestUse = -1;

                    for (int j = 0; j < pageFrames.size(); j++) {
                        int page = pageFrames.get(j);
                        int nextUse = Integer.MAX_VALUE;

                        for (int k = i + 1; k < pages.length; k++) {
                            if (pages[k] == page) {
                                nextUse = k;
                                break;
                            }
                        }

                        if (nextUse > farthestUse) {
                            farthestUse = nextUse;
                            indexToReplace = j;
                        }
                    }

                    pageFrames.set(indexToReplace, currentPage);
                }

                System.out.println("this page caused a fault " + currentPage + " Memory: " + pageFrames);
            } else {
                System.out.println("Page already in memory " + currentPage + " Memory: " + pageFrames);
            }
        }

        int withReplacement = Math.max(0, pageFaults - frames);
        int withoutReplacement = Math.min(pageFaults, frames);
        System.out.println("Page Faults without Replacement: " + withoutReplacement);
        System.out.println("Page Faults with Replacement: " + withReplacement);
        System.out.println("Total Page Faults: " + pageFaults);
    }

    public void lru(int[] pages, int frames) {
        List<Integer> pageFrames = new ArrayList<>();
        int pageFaults = 0;

        for (int currentPage : pages) {
            if (!pageFrames.contains(currentPage)) {
                pageFaults++;

                if (pageFrames.size() < frames) {
                    pageFrames.add(currentPage);
                } else {
                    pageFrames.remove(0);
                    pageFrames.add(currentPage);
                }

                System.out.println("this page caused a fault " + currentPage + " Memory: " + pageFrames);
            } else {
                pageFrames.remove((Integer) currentPage);
                pageFrames.add(currentPage);
                System.out.println("Page already in memory " + currentPage + " Memory: " + pageFrames);
            }
        }

        int withReplacement = Math.max(0, pageFaults - frames);
        int withoutReplacement = Math.min(pageFaults, frames);
        System.out.println("Page Faults without Replacement: " + withoutReplacement);
        System.out.println("Page Faults with Replacement: " + withReplacement);
        System.out.println("Total Page Faults: " + pageFaults);
    }

    public void pagesandframes(int algoChoice) {
        int[] pages = new int[20];
        int frames = 0;

        //frames
        while (true) {
            try {
                System.out.print("Enter number of frames: ");
                frames = Integer.parseInt(pagescanner.nextLine());
                if (frames > 0) {
                    break;
                }
                System.out.println("Frames must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }

        //page
        System.out.println("Enter 20 page numbers separated by space:");
        while (true) {
            try {
                String[] input = pagescanner.nextLine().trim().split("\\s+");
                if (input.length != 20) {
                    System.out.println("You must enter exactly 20 numbers.");
                    continue;
                }
                for (int i = 0; i < 20; i++) {
                    pages[i] = Integer.parseInt(input[i]);
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Only integers are allowed. Try again.");
            }
        }

        switch (algoChoice) {
            case 1:
                fifo(pages, frames);
                break;
            case 2:
                optimal(pages, frames);
                break;
            case 3:
                lru(pages, frames);
                break;
            default:
                System.out.println("Invalid algorithm choice.");
        }
    }
}
