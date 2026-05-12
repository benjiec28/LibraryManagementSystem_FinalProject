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


    public List<Item> recursiveSearchByAuthor() {

    }


    public List<Item> recursiveSearchByTitle() {

    }


    public List<Item> streamSearchByAuthor() {

    }


    public List<Item> streamSearchByTitle() {

    }


    public boolean addItem() {

    }


    public boolean removeItem() {

    }


    public void loadFileData() {

    }


    public void backupFileData() {

    }
}
