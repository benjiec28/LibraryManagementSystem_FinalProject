package org.example.User;

import lombok.*;
import org.example.Item.Item;

import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@ToString
public class Admin extends User implements Reportable {

    public Admin(String id, String name, List<Item> borrowedItems, Gender gender) {
        super(id, name, borrowedItems, gender);
    }

    @Override
    public void generateReport(List<Item> items) {
        System.out.println("List of Items :");
        for (Item item : items) {
            System.out.printf(item);
        }
    }

}
