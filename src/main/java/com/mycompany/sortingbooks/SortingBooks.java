package com.mycompany.sortingbooks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SortingBooks {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sr = new Scanner(System.in);
        ArrayList<Book> main = new ArrayList<>();
        String name = checkExists(sr);
        populate(name, main);
        choices(main, sr);
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
//This method populates the arraylist

    public static void populate(String name, ArrayList<Book> books) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(name));
        while (sc.hasNext()) {

            try {
                String x = sc.nextLine();
                String[] split = x.split(",");

                String names[] = split[1].split(" ");

                if (split.length != 3 || names.length != 2) {

                    throw new Exception();
                } else {

                    books.add(new Book(split[0], split[1], Double.parseDouble(split[2])));

                }

            } catch (Exception e) {

            }
        }

    }
//This method lists the user choices on how they want to sort the arraylist

    public static void choices(ArrayList<Book> books, Scanner sr) {
        boolean flag = true;
        while (flag == true) {

            System.out.println("\nEnter a sorting choice (or q to quit): \n"
                    + "t - by title, n - by last name, r - by rating");

            char c = sr.next().charAt(0);

            switch (c) {
                case 't':

                   sort(books,Comparator.comparing(Book::getTitle));
                    break;

                case 'n':

                   sort(books,Comparator.comparing(Book::getAuthor));
                    break;
                case 'r':

                    sort(books,Comparator.comparing(Book::getRating));
                    break;

                case 'q':

                    System.exit(0);
                default:
                    System.out.println("Invalid choice\n");

            }
        }

    }
//This method sorts the arraylist based on title alphabetical order

    public static void sort(ArrayList<Book> books, Comparator x) {
        books.sort(x);

        for (Book book : books) {
            System.out.println(book);
        }
    }
//This method sorts the arraylist based on last name alphabetical order

   

}
