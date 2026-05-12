package org.example.User;

import lombok.*;
import org.example.Item.Item;

import java.util.List;

@Getter
@Setter
@ToString
public class Teacher extends User {
    private List<Item> borrowedItems;

    public Teacher(String id, String name, List<Item> borrowedItems, List<Item> borrowedItems1) {
        super(id, name, borrowedItems);
        this.borrowedItems = borrowedItems1;
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
