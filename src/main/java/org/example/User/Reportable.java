package org.example.User;

import org.example.Item.Item;

import java.util.List;

public interface Reportable {

    /**
     * Generates a report for all items.
     */
    abstract void generateReport(List<Item> items);
}
