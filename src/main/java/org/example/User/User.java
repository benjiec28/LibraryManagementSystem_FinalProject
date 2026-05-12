package org.example.User;

import lombok.*;
import org.example.Item.Item;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public abstract class User {
    protected String id;
    protected String name;
    protected List<Item> borrowedItems;

    public static int nextId = 0;

    public User(String name, List<Item> borrowedItems) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        this.borrowedItems = borrowedItems;
    }

    public static int nextID = 0;

    public abstract boolean borrowItem();

    public abstract boolean returnItem();
}
