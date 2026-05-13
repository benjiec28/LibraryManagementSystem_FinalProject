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
        this.id = String.format("%07d", nextId++);
        this.status = status;
    }

    public static int nextId = 1;

    public enum Status {
        BORROWED,
        IN_STORE,
        LOST
    }
}
