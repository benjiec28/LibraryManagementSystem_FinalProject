package org.example.User;

import lombok.*;
import org.example.Item.Book;

import java.util.List;

@Getter
@Setter
@ToString
public class Student extends User {
    private List<Book> borrowedBooks;

    @Override
    public boolean borrowItem() {
        return false;
    }

    @Override
    public boolean returnItem() {
        return false;
    }
}
