package org.example.Item;

import lombok.*;

import java.util.Comparator;

@Getter
@Setter
@ToString
public class Book extends Item implements Comparator<Book> {
    private String ISBN;
    private String author;
    private Genre genre;

    public Book(String id, Status status, String ISBN, String title, String author, Genre genre) {
        super(id, title, status);
        this.ISBN = ISBN;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public int compare(Book o1, Book o2) {
        String field = "";

        switch (field.toLowerCase()) {
            case "id" -> {
                return o1.id.compareTo(o2.id);
            }

            case "isbn" -> {
                return o1.ISBN.compareTo(o2.ISBN);
            }

            case "title" -> {
                return o1.title.compareTo(o2.title);
            }

            case "author" -> {
                return o1.author.compareTo(o2.author);
            }

        }

        return 0;
    }

    public enum Genre {
        SCIENCE_FICTION,
        ACTION,
        ADVENTURE,
        FANTASY,
        ROMANCE,
        MYSTERY,
        THRILLER,
        HORROR,
        BIOGRAPHY,
        CRIME,
        HISTORY,
        YOUNG_ADULT
    }
}
