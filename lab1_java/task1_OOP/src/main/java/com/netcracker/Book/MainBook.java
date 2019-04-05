package com.netcracker.Book;

public class MainBook {
    public static void main(String[] args) {
        Author[][] authors = new Author[][]{
                new Author[]{
                        new Author("A. A. Pushkin", "", 'M')
                },
                new Author[]{
                        new Author("A. N. Strugatsky", "", 'M'),
                        new Author("B. N. Strugatsky", "", 'M')
                },
                new Author[]{
                        new Author("R. D. Bradbury", "", 'M')
                },
                new Author[]{
                        new Author("R. D. Bradbury", "", 'M')
                }
        };
        Book[] books = new Book[]{
                new Book("Eugene Onegin", authors[0], 200),
                new Book("Eugene Onegin", authors[0], 200),
                new Book("Monday starts Saturday", authors[1], 500),
                new Book("451 degrees Fahrenheit", authors[2], 1000, 10),
                new Book("Wine from dandelions", authors[2], 1000, 11)
        };

        for (int i = 0; i < books.length; ++i)
            System.out.println(books[i].toString());
        System.out.println(books[0].toString() + " and " + books[1].toString() + " is " +
                (books[0].equals(books[1]) ? " equals" : " not equals"));
        System.out.println(books[3].toString() + " and " + books[1].toString() + " is " +
                (books[4].equals(books[1]) ? " equals" : " not equals"));

        System.out.println("Reflexivity: " + books[0].equals((books[0])));
        System.out.println("Symmetry: " + books[0].equals((books[1])) + " and " + books[1].equals((books[0])));
    }
}
