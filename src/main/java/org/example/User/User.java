package org.example.User;

import lombok.*;
import org.example.Item.Item;
import org.example.Sortable;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public abstract class User implements Sortable {
    protected String id;
    protected String name;
    protected List<Item> borrowedItems;

    public static int nextId = 1;

    public User(String name, List<Item> borrowedItems) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        this.borrowedItems = borrowedItems;
    }

    @Override
    public int compareTo(Object object) {
        return 0;
    }

    public static int nextID = 0;

    public abstract boolean borrowItem(Item borrowedItem);

    public abstract boolean returnItem(Item returnedItem);
}
