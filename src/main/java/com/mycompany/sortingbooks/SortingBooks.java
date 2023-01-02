package com.mycompany.sortingbooks;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

public class SortingBooks {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sr = new Scanner(System.in);
        String name = Book.checkExists(sr);
        BookList x = new BookList();
        x.populate(name);
        choices(x, sr);
        
        
    }

//This method lists the user choices on how they want to sort the object
    public static void choices(BookList books, Scanner sr) {
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
