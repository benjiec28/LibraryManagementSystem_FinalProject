package org.example.Item;

import lombok.*;

import java.util.Comparator;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public abstract class Item {
    protected String id;
    protected String title;
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

    public static class ItemComparator implements Comparator<Item> {
        private String field;

        public ItemComparator(String field) {
            this.field = field;
        }

        @Override
        public int compare(Item o1, Item o2) {
            switch (field.toLowerCase()) {
                case "id" -> {
                    return o1.id.compareTo(o2.id);
                }

                case "title" -> {
                    return o1.title.compareTo(o2.title);
                }

            }

            return 0;
        }
    }
}
