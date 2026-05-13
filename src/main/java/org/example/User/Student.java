package org.example.User;

import lombok.*;
import org.example.Item.Book;
import org.example.Item.Item;

import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@ToString
public class Student extends User implements Comparator<Student> {
    private List<Book> borrowedBooks;

    public Student(String id, String name, List<Item> borrowedItems, List<Book> borrowedBooks) {
        super(id, name, borrowedItems);
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public int compare(Student o1, Student o2) {
        String field = "";

        switch (field.toLowerCase()) {
            case "" -> {
                return o1.author.compareTo(o2.author);
            }

            case "title" -> {
                return o1.title.compareTo(o2.title);
            }
        }

        return 0;;
    }
}
