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
    ArrayList<Book> bookList = new ArrayList<>();

    public Book(String title, String author, double rating) {
        this.title = title;
        this.author = author;
        this.rating = rating;

    }

    public Book() {
        bookList = new ArrayList<>();

    }

    public void sort(Comparator x) {
        bookList.sort(x);

        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void populate(String name) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(name));
        while (sc.hasNext()) {

            try {
                String x = sc.nextLine();
                String[] split = x.split(",");

                String names[] = split[1].split(" ");

                if (split.length != 3 || names.length != 2) {

                    throw new Exception();
                } else {

                    bookList.add(new Book(split[0], split[1], Double.parseDouble(split[2])));

                }

            } catch (Exception e) {

            }
        }

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

        return String.format("%-33s%-33s%-33s", title, author, rating);

    }

}
