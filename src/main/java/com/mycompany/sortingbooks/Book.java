package com.mycompany.sortingbooks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Book {

    String title;
    String author;
    double rating;

    public Book(String title, String author, double rating) {
        this.title = title;
        this.author = author;
        this.rating = rating;

    }

    public String getTitle() {

        return title;
    }

    public String getAuthor() {

        return author.substring(author.indexOf(" "));
    }

    public double getRating() {

        return rating;
    }
//A string format that evens the spaces between the arraylist information after the sort

    @Override
    public String toString() {
        System.out.println(this);
        return String.format("%-33s%-33s%-33s", title, author, rating);

    }

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

}
