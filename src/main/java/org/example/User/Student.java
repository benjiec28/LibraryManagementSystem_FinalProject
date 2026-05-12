package org.example.User;

import lombok.*;
import org.example.Item.Book;
import org.example.Item.Item;

import java.util.List;

@Getter
@Setter
@ToString
public class Student extends User {
    private List<Book> borrowedBooks;

    public Student(String id, String name, List<Item> borrowedItems, List<Book> borrowedBooks) {
        super(id, name, borrowedItems);
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public boolean borrowItem() {
        return false;
    }

    @Override
    public boolean returnItem() {
        return false;
    }
}
