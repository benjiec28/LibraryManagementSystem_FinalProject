package org.example.User;

import lombok.*;
import org.example.Item.Item;

import java.util.List;

@Getter
@Setter
@ToString
public class Admin extends User implements Reportable{

    public Admin(String id, String name, List<Item> borrowedItems) {
        super(id, name, borrowedItems);
    }

    @Override
    public void generateReport() {

    }

    @Override
    public boolean borrowItem(Item borrowedItem) {
        return false;
    }

    @Override
    public boolean returnItem(Item returnedItem) {
        return false;
    }
}
