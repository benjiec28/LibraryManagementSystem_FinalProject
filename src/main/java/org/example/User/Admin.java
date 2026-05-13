package org.example.User;

import lombok.*;
import org.example.Item.Item;

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
        System.out.println("----- List of Items -----\n");
        System.out.println("== Borrowed Items ==\n");
        items.stream()
                .filter(item -> item.getStatus() == Item.Status.BORROWED)
                .forEach(item -> System.out.println(item.getTitle() + " | " + item.getId()));

        System.out.println("== Lost Items ==\n");
        items.stream()
                .filter(item -> item.getStatus() == Item.Status.LOST)
                .forEach(item -> System.out.println(item.getTitle() + " | " + item.getId()));

        System.out.println("== In Store Items ==\n");
        items.stream()
                .filter(item -> item.getStatus() == Item.Status.IN_STORE)
                .forEach(item -> System.out.println(item.getTitle() + " | " + item.getId()));

    }

}
