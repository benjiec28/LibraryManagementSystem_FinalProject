package org.example.User;

import lombok.*;
import org.example.Item.Item;

import java.util.List;

@Getter
@Setter
@ToString
public class Teacher extends User {
    private List<Item> borrowedItems;

    @Override
    public boolean borrowItem() {
        return false;
    }

    @Override
    public boolean returnItem() {
        return false;
    }
}
