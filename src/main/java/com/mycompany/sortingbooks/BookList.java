/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sortingbooks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BookList extends ArrayList<Book> {

    public BookList() {
        super();

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

                    super.add(new Book(split[0], split[1], Double.parseDouble(split[2])));

                }

            } catch (Exception e) {

            }
        }

    }

    public void sort(Comparator x) {
        super.sort(x);

        for (Book book : this) {
            System.out.println(book);
        }
    }

}
