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


    public List<Item> recursiveSearchByAuthor(String author) {
        return ;
    }


    public List<Item> recursiveSearchByTitle(String title) {
        return ;
    }


    public List<Item> streamSearchByAuthor(String author) {
        return items.stream()
                .filter();
    }


    public List<Item> streamSearchByTitle(String title) {
        return items.stream()
                .filter();
    }


    public boolean addItem(Item item) {
        return;
    }


    public boolean removeItem(Item item) {
        return ;
    }


    public void loadFileData() {
        return;
    }


    public void backupFileData() {
        return;
    }
}
