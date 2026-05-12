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

    @Override
    public void borrowItem() {

    }

    @Override
    public void returnItem() {

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
