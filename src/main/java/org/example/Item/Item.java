package org.example.Item;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public abstract class Item {
    protected String id;
    protected Status status;

    public Item(Status status) {
        this.id = String.format("%04d", nextId++);
        this.status = status;
    }

    public static int nextId = 0;

    public abstract void borrowItem();

    public abstract void returnItem();

    public enum Status {
        BORROWED,
        IN_STORE,
        LOST
    }
}
