package org.example;

import lombok.*;
import org.example.Item.Item;
import org.example.User.User;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Library {
    private List<Item> items;
    private List<User> users;

    /**
     * Finds items by author through recursive search.
     * @param author the author.
     * @return the items with the author.
     */
    public List<Item> recursiveSearchByAuthor(String author) {
        return ;

    }

    /**
     * Finds items by title through recursive search.
     * @param title the title.
     * @return the items with the title.
     */
    public List<Item> recursiveSearchByTitle(String title) {
        return ;
    }

    /**
     * Finds items by author through stream search.
     * @param author the author.
     * @return the items with the author.
     */
    public List<Item> streamSearchByAuthor(String author) {
        return items.stream()
                .filter(item -> );
    }

    /**
     * Finds items by title through stream search.
     * @param title the title.
     * @return the items with the title.
     */
    public List<Item> streamSearchByTitle(String title) {
        return items.stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(title))
                .distinct()
                .toList();
    }

    /**
     * Adds an item to the library.
     * @param item the item.
     * @return returns true if the item was successfully added ; false if not.
     */
    public boolean addItem(Item item) {
        if (items.contains(item)) {
            System.out.println("Item is already added.");
            return false;
        }

        items.add(item);

        return true;
    }

    /**
     * Removes an item to the library.
     * @param item the item.
     * @return returns true if the item was successfully removed ; false if not.
     */
    public boolean removeItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            return true;
        }

        System.out.println("Item is not in the library.");

        return false;
    }

    /**
     * Loads the file data.
     */
    public void loadFileData() {
        return;
    }

    /**
     * Backs up the file data.
     */
    public void backupFileData() {
        return;
    }
}
