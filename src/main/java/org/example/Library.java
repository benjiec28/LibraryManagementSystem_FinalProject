package org.example;

import lombok.*;
import org.example.Item.Book;
import org.example.Item.DVD;
import org.example.Item.Item;
import org.example.Item.Magazine;
import org.example.User.Admin;
import org.example.User.Student;
import org.example.User.Teacher;
import org.example.User.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Library {
    private List<Item> items;
    private Map<String, User> users;

    /**
     * Finds items by title or author through recursive search.
     *
     * @param query the query (title or author).
     * @return the items with the query.
     */
    public List<Item> recursiveSearch(String query) {
        return recursiveHelper(query.toLowerCase(), 0, new ArrayList<>(), new HashSet<>());
    }

    /**
     * A recursive helper method that goes through the items.
     *
     * @param query   the query (title or author).
     * @param index   the index.
     * @param results the results.
     * @param seen    a set of items with unique isbn.
     * @return a list of unique items with the query.
     */
    private List<Item> recursiveHelper(String query, int index, List<Item> results, Set<String> seen) {
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
     *
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
     *
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
     *
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
        items = new ArrayList<>();
        users = new HashMap<>();

        try {
            Scanner itemScanner = new Scanner(new File(Constants.CSV_FILE_ITEMS));
            itemScanner.nextLine();

            while (itemScanner.hasNext()) {
                String line = itemScanner.nextLine();
                String[] data = line.split((","));

                String id = data[0];
                String title = data[1];
                String type = data[2];
                Item.Status status = Item.Status.valueOf(data[3]);

                Item item = null;

                switch (type.toLowerCase()) {
                    case "book" -> {
                        String isbn = data[4];
                        String author = data[5];
                        Book.Genre genre = Book.Genre.valueOf(data[6]);

                        item = new Book(id, status, isbn, title, author, genre);
                    }

                    case "dvd" -> {
                        String director = data[4];
                        int duration = Integer.parseInt(data[5]);

                        item = new DVD(id, status, title, director, duration);
                    }

                    case "magazine" -> {
                        int issueNumber = Integer.parseInt(data[4]);
                        String publisher = data[5];

                        item = new Magazine(id, status, title, issueNumber, publisher);
                    }

                    default -> System.out.println("Invalid type.");
                }

                if (item != null) {
                    item.setId(id);
                    items.add(item);
                }
            }

            itemScanner.close();

            Scanner userScanner = new Scanner(new File(Constants.CSV_FILE_USERS));
            userScanner.nextLine();

            while (userScanner.hasNext()) {
                String line = userScanner.nextLine();
                String[] element = line.split(",");

                String id = element[0];
                String name = element[1];
                String rank = element[2];

                List<Item> borrowedItem = new ArrayList<>();

                if (!element[3].isBlank()) {
                    String[] borrowedIDs = element[3].split(",");

                    for (String borrowedID : borrowedIDs) {
                        for (Item item : items) {
                            if (item.getId().equals(borrowedID)) {
                                borrowedItem.add(item);
                            }
                        }
                    }
                }

                User.Gender gender = User.Gender.valueOf(element[4]);
                User user = null;

                switch (rank.toLowerCase()) {
                    case "student" -> {
                        user = new Student(id, name, borrowedItem, gender);
                    }

                    case "teacher" -> {
                        user = new Teacher(id, name, borrowedItem, gender);
                    }

                    case "admin" -> {
                        user = new Admin(id, name, borrowedItem, gender);
                    }

                    default -> {
                        System.out.println("Invalid rank.");
                    }
                }

                if (user != null) {
                    user.setId(id);
                    users.put(id, user);
                }
            }

            userScanner.close();

            System.out.println("File data successfully loaded.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loading data error: " + e.getMessage());
        }
    }

    /**
     * Backs up the file data.
     */
    public void backupFileData() {
        try {
            FileWriter itemWriter = new FileWriter(Constants.CSV_FILE_ITEMS);
            itemWriter.write("ID | TYPE | TITLE | STATUS\n");

            for (Item item : items) {
                String type = item.getClass().getSimpleName();
                itemWriter.write(item.getId() + " | " + type + " | " + item.getTitle() + " | " + item.getStatus() + "\n");
            }
            itemWriter.close();

            FileWriter userWriter = new FileWriter(Constants.CSV_FILE_USERS);
            userWriter.write("ID | NAME | RANK | BORROWED ITEMS | GENDER\n");

            for (User user : users.values()) {
                String rank = user.getClass().getSimpleName();
                StringBuilder borrowed = new StringBuilder();

                for (Item item : user.getBorrowedItems()) {
                    borrowed.append(item.getId()).append(";");
                }

                if (!borrowed.isEmpty()) {
                    borrowed.setLength(borrowed.length() - 1);
                }

                userWriter.write(user.getId() + " | " + user.getName() + " | " + borrowed + " | " + user.getGender() + "\n");
            }

            userWriter.close();

            System.out.println("File data successfully backed up.");

        } catch (IOException e) {
            System.out.println("Backup data error: " + e.getMessage());
        }
    }
}
