package com.mycompany.sortingbooks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

public class SortingBooks {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sr = new Scanner(System.in);

        String name = checkExists(sr);
        Book x = new Book();

        x.populate(name);
        choices(x, sr);
    }

// This method checks to see if the name of a file exists
    public static String checkExists(Scanner sr) {

        System.out.print("Books file: ");
        String check = sr.next();
        File r = new File(check);

        while (!r.exists()) {
            System.out.println("File does not exist; try again");
            System.out.print("Books file: ");
            check = sr.next();
            r = new File(check);

        }

        return check;

    }

//This method lists the user choices on how they want to sort the object
    public static void choices(Book books, Scanner sr) {
        boolean flag = true;
        while (flag == true) {

            System.out.println("\nEnter a sorting choice (or q to quit): \n"
                    + "t - by title, n - by last name, r - by rating");

            char c = sr.next().charAt(0);

            switch (c) {
                case 't':

                    books.sort(Comparator.comparing(Book::getTitle));
                    break;

                case 'n':

                    books.sort(Comparator.comparing(Book::getAuthor));
                    break;
                case 'r':

                    books.sort(Comparator.comparing(Book::getRating));
                    break;

                case 'q':

                    System.exit(0);
                default:
                    System.out.println("Invalid choice\n");

            }
        }
    }
}
