package org.example.User;

import lombok.*;
import org.example.Item.Book;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Student {
    private List<Book> borrowedBooks;

}
