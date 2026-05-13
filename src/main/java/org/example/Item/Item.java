package org.example.Item;

import lombok.*;

import java.util.Comparator;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public abstract class Item implements Comparator {
    protected String id;
    protected Status status;

    public Item(Status status) {
        this.id = String.format("%04d", nextId++);
        this.status = status;
    }

    public static int nextId = 1;

    public enum Status {
        BORROWED,
        IN_STORE,
        LOST
    }
}
