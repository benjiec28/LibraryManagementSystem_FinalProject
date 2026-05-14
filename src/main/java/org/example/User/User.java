package org.example.User;

import lombok.*;
import org.example.Constants;
import org.example.Item.Book;
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
            int maxBooks = Constants.MAX_BOOKS_STUDENT;

            if (borrowedItem.getStatus() == Item.Status.BORROWED) {
                System.out.print("This item is already borrowed.");
            }

            if (borrowedItem.getStatus() == Item.Status.LOST) {
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
            int maxItems = Constants.MAX_ITEMS_TEACHER;

            if (borrowedItem.getStatus() == Item.Status.BORROWED) {
                System.out.print("This item is already borrowed.");
            }

            if (borrowedItem.getStatus() == Item.Status.LOST) {
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

    public static class UserComparator implements Comparator<User> {
        private String field;

        public UserComparator(String field) {
            this.field = field;
        }

        @Override
        public int compare(User o1, User o2) {
            switch (field.toLowerCase()) {
                case "id" -> {
                    return o1.id.compareTo(o2.id);
                }

                case "title" -> {
                    return o1.name.compareTo(o2.name);
                }
            }

            return 0;
        }
    }
}
