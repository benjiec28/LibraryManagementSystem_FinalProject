import org.example.Item.Book;
import org.example.Item.DVD;
import org.example.Item.Item;
import org.example.Item.Magazine;
import org.example.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    @Test
    @DisplayName("Recursive Search Test.")
    void recursiveSearch() {
        List<Item> items = new ArrayList<>();

        items.add(new Book("B1", Item.Status.IN_STORE, "9780134685991", "Java", "Carl", Book.Genre.SCIENCE_FICTION));
        items.add(new Book("B2", Item.Status.IN_STORE, "9780134685991", "duplicate", "Rawr", Book.Genre.SCIENCE_FICTION));
        items.add(new DVD("D1", Item.Status.IN_STORE, "Invincible", "Nolan", 148));
        items.add(new Magazine("M1", Item.Status.IN_STORE, "Robotics", 202, "John"));

        Library library = new Library(items, new HashMap<>());

        List<Item> results1 = library.recursiveSearch("Java");
        assertEquals(1, results1.size(), "Recursive search should deduplicate books by ISBN.");

        List<Item> results2 = library.recursiveSearch("nOlAn");
        assertEquals(1, results2.size());
        assertEquals("Invincible", results2.get(0).getTitle());

        List<Item> results3 = library.recursiveSearch("John");
        assertEquals(1, results3.size());
    }

    @Test
    @DisplayName("Stream Search Test.")
    void streamSearch() {
        List<Item> items = new ArrayList<>();

        items.add(new Book("B1", Item.Status.IN_STORE, "9780596009205", "Java", "Michael", Book.Genre.SCIENCE_FICTION));
        items.add(new DVD("D1", Item.Status.IN_STORE, "Interstellar", "Nolan", 169));
        items.add(new DVD("D2", Item.Status.IN_STORE, "Interstellar", "Mark", 169));
        items.add(new Magazine("M1", Item.Status.IN_STORE, "Tech News", 50, "Publisher X"));

        Library library = new Library(items, new HashMap<>());

        List<Item> results1 = library.streamSearch("Interstellar");
        assertEquals(1, results1.size(), "Stream search should deduplicate DVDs by Title.");

        List<Item> results2 = library.streamSearch("Michael");
        assertEquals(1, results2.size());
        assertTrue(results2.get(0) instanceof Book);

        List<Item> results3 = library.streamSearch("...");
        assertTrue(results3.isEmpty(), "Should return an empty list if no matches found.");
    }

    @Test
    @DisplayName("Add Item Test.")
    void addItem() {
        Library library = new Library(new ArrayList<>(), new HashMap<>());

        Book validBook = new Book("0000001", Item.Status.IN_STORE, "9780134685991", "Java is cool.", "MJ", Book.Genre.SCIENCE_FICTION);

        Book invalidIdBook = new Book("abcde", Item.Status.IN_STORE, "9780134685991", "How to larp.", "Harel", Book.Genre.SCIENCE_FICTION);

        Book invalidIsbnBook = new Book("0000002", Item.Status.IN_STORE, "123", "Volleyball pro.", "Piraven", Book.Genre.SCIENCE_FICTION);

        assertTrue(library.addItem(validBook), "Should successfully add a valid book");
        assertEquals(1, library.getItems().size());

        assertFalse(library.addItem(validBook), "Should return false when adding the exact same object again");

        assertFalse(library.addItem(invalidIdBook), "Should return false for an invalid ID format");
        assertFalse(library.addItem(invalidIsbnBook), "Should return false for an invalid ISBN-13 format");
    }

    @Test
    @DisplayName("Remove Item Test.")
    void removeItem() {
        Item dvd = new DVD("0000001", Item.Status.IN_STORE, "Invincible", "Nolan", 148);
        List<Item> items = new ArrayList<>(List.of(dvd));
        Library library = new Library(items, new HashMap<>());

        assertTrue(library.removeItem(dvd), "Return true when removing an item that already exists in the library");
        assertFalse(library.getItems().contains(dvd), "Library list should no longer contain the item");

        assertFalse(library.removeItem(dvd), "Return false when trying to remove an item that is already removed");

        Item nonExistentItem = new Magazine("0000999", Item.Status.IN_STORE, "Donda", 1, "Kanye West");
        assertFalse(library.removeItem(nonExistentItem), "Should return false for items that were never added to the library");
    }
}
