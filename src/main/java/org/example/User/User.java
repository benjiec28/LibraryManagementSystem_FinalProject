package org.example.User;

import lombok.*;
import org.example.Item.Item;

import java.util.Comparator;
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

    public static int nextId = 1;

    public User(String name, List<Item> borrowedItems) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        this.borrowedItems = borrowedItems;
    }

    public static int nextID = 0;

    /**
     * borrows an item, adds it to the students list of borrowed books and changes status to BORROWED.
     * @param borrowedItem the borrowed item.
     * @return true if the item was successfully borrowed; false if it was not.
     */
    public boolean borrowItem(Item borrowedItem) {

    }

    /**
     * returns an item, removes it to the students list of borrowed books and changes status to IN_STORE.
     * @param returnedItem the returned item.
     * @return true if the item was successfully returned; false if it was not.
     */
    public boolean returnItem(Item returnedItem) {

    }
}
