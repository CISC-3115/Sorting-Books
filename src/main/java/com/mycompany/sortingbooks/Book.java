package com.mycompany.sortingbooks;

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
//This method returns the last index after " " hence the last name

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
