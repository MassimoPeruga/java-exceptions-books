package org.learning.exceptions;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static final String filePath = "./resources/books.txt";
    public static void main(String[] args) {
        // Open Scanner
        Scanner scanner = new Scanner(System.in);

        // Generate empty array
        int booksArraySize;
        System.out.print("Quanti libri vuoi aggiungere? ");
        booksArraySize = Integer.parseInt(scanner.nextLine());
        Book[] bookArray = new Book[booksArraySize];

        // Add books
        int i = 0;
        while (i < booksArraySize) {
            System.out.println("*******************************");
            System.out.println("Inserisci i dettagli del libro:");

            String title, author, publisher;
            int pages;

            try {
                System.out.print("Titolo: ");
                title = scanner.nextLine();
                System.out.print("Pagine: ");
                pages = Integer.parseInt(scanner.nextLine());
                System.out.print("Autore: ");
                author = scanner.nextLine();
                System.out.print("Editore: ");
                publisher = scanner.nextLine();

                bookArray[i] = new Book(title, pages, author, publisher);
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Numero non valido.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("*******************************");
        writer(bookArray, filePath);
        reader(filePath);

        // Close Scanner
        scanner.close();
    }

    // Writer method
    public static void writer(Book[] books, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Book book : books) {
                writer.write(book.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Reader method
    public static void reader(String filePath) {
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}