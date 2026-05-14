package org.example;

import lombok.*;
import org.example.Item.Book;
import org.example.Item.DVD;
import org.example.Item.Item;
import org.example.Item.Magazine;
import org.example.User.User;

import java.util.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Library {
    private List<Item> items;
    private List<User> users;

    /**
     * Finds items by title or author through recursive search.
     * @param query the query (title or author).
     * @return the items with the query.
     */
    public List<Item> recursiveSearch(String query) {
        return recursiveHelper(query.toLowerCase(), 0, new ArrayList<>(), new HashSet<>());
    }

    /**
     * A recursive helper method that goes through the items.
     * @param query the query (title or author).
     * @param index the index.
     * @param results the results.
     * @param seen a set of items with unique isbn.
     * @return a list of unique items with the query.
     */
    private List<Item> recursiveHelper (String query, int index, List<Item> results, Set<String> seen) {
        if (index >= items.size()) {
            return results;
        }

        Item current = items.get(index);
         boolean isMatch = current.getTitle().toLowerCase().contains(query);

         if (current instanceof Book) {
             isMatch = isMatch || ((Book) current).getAuthor().toLowerCase().contains(query);
         } else if (current instanceof DVD) {
             isMatch = isMatch || ((DVD) current).getDirector().toLowerCase().contains(query);
         } else if (current instanceof Magazine) {
             isMatch = isMatch || ((Magazine) current).getPublisher().toLowerCase().contains(query);
         }

         if (isMatch) {
             String key = (current instanceof Book) ? ((Book) current).getISBN() : current.getTitle();

             if (seen.add(key)) {
                 results.add(current);
             }
         }

         return recursiveHelper(query, index + 1, results, seen);

    }

    /**
     * Finds items by title or author through stream search.
     * @param query the query (title or author).
     * @return the items with the query.
     */
    public List<Item> streamSearch(String query) {
        String queryLC = query.toLowerCase();
        Set<String> uniqueItem = new HashSet<>();

        return items.stream()
                .filter(item -> {
                    boolean matches = item.getTitle().toLowerCase().contains(queryLC);

                    if (item instanceof Book) {
                        matches = matches || ((Book) item).getAuthor().toLowerCase().contains(queryLC);
                    } else if (item instanceof DVD) {
                        matches = matches || ((DVD) item).getDirector().toLowerCase().contains(queryLC);
                    } else if (item instanceof Magazine) {
                        matches = matches || ((Magazine) item).getPublisher().toLowerCase().contains(queryLC);
                    }

                    return matches;
                })
                .filter(item -> {
                    String key = (item instanceof Book) ? ((Book) item).getISBN() : item.getTitle();
                    return uniqueItem.add(key);
                })
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

        if (!Validation.isIDValid(item.getId())) {
            System.out.println("ID is not valid.");
            return false;
        }

        if (item instanceof Book) {
            if (!Validation.isISBNValid(((Book) item).getISBN())) {
                System.out.println("ISBN is not valid.");
                return false;
            }
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
