package org.example.User;

import lombok.*;
import org.example.Item.Item;

import java.util.Comparator;
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
    public int compare(Admin o1, Admin o2) {
        return 0;
    }
}
