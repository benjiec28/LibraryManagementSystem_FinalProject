package org.example.User;

import lombok.*;
import org.example.Item.Book;
import org.example.Item.Item;

import java.util.ArrayList;
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
    protected Gender gender;

    public enum Gender {
        MALE,
        FEMALE
    }

    public static int nextId = 1;

    public User(String name, List<Item> borrowedItems) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
    }

    public static int nextID = 0;

    /**
     * borrows an item, adds it to the students list of borrowed books and changes status to BORROWED.
     * @param borrowedItem the borrowed item.
     */
    public void borrowItem(Item borrowedItem) {
        if (this instanceof Student && !(borrowedItem instanceof Book)) {
            int maxBooks = 5;

            if(borrowedItem.getStatus() == Item.Status.BORROWED) {
                System.out.print("This item is already borrowed.");
            }

            if(borrowedItem.getStatus() == Item.Status.LOST) {
                System.out.print("This item is unavailable.");
            }

            if (borrowedItem.getStatus() == Item.Status.IN_STORE) {
                if (borrowedItems.size() < maxBooks) {
                    borrowedItems.add(borrowedItem);
                    borrowedItem.setStatus(Item.Status.BORROWED);
                    System.out.print("Successfully borrowed.");
                }

                System.out.print("Maximum limit reached.");
            }

        } else if (this instanceof Teacher) {
            int maxItems = 10;

            if(borrowedItem.getStatus() == Item.Status.BORROWED) {
                System.out.print("This item is already borrowed.");
            }

            if(borrowedItem.getStatus() == Item.Status.LOST) {
                System.out.print("This item is unavailable.");
            }

            if (borrowedItem.getStatus() == Item.Status.IN_STORE) {
                if (borrowedItems.size() < maxItems) {
                    borrowedItems.add(borrowedItem);
                    borrowedItem.setStatus(Item.Status.BORROWED);
                    System.out.print("Successfully borrowed.");
                }

                System.out.print("Maximum limit reached.");
            }
        }
    }

    /**
     * returns an item, removes it to the students list of borrowed books and changes status to IN_STORE.
     * @param returnedItem the returned item.
     */
    public void returnItem(Item returnedItem) {
        if (this instanceof Student || this instanceof Teacher) {
            if (borrowedItems.isEmpty()) {
                System.out.println("You do not have any items.");
            }

            if (returnedItem.getStatus() == Item.Status.BORROWED) {
                borrowedItems.remove(returnedItem);
                returnedItem.setStatus(Item.Status.IN_STORE);
                System.out.print("Successfully returned.");
            }

            if (returnedItem.getStatus() == Item.Status.LOST) {
                System.out.print("This item is unavailable.");
            }

            if (returnedItem.getStatus() == Item.Status.IN_STORE) {
                System.out.println("You do not possess this item.");
            }
        }


    }
}
