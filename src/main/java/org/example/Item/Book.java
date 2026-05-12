package org.example.Item;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Book {
    private String ISBN;
    private String title;
    private String author;
    private Genre genre;

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
