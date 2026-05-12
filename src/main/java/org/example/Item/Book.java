package org.example.Item;

import lombok.*;

@Getter
@Setter
@ToString
public class Book extends Item {
    private String ISBN;
    private String title;
    private String author;
    private Genre genre;

    public Book(String id, Status status, String ISBN, String title, String author, Genre genre) {
        super(id, status);
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;
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
