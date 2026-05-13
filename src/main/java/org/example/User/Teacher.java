package org.example.User;

import lombok.*;
import org.example.Item.Item;

import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@ToString
public class Teacher extends User {
    private List<Item> borrowedItems;

    public Teacher(String id, String name, List<Item> borrowedItems, Gender gender, List<Item> borrowedItems1) {
        super(id, name, borrowedItems, gender);
        this.borrowedItems = borrowedItems1;
    }

    public static class TeacherComparator implements Comparator<Teacher> {
        private String field;

        public TeacherComparator(String field) {
            this.field = field;
        }

        @Override
        public int compare(Teacher o1, Teacher o2) {
            switch (field.toLowerCase()) {
                case "id" -> {
                    return o1.id.compareTo(o2.id);
                }

                case "name" -> {
                    return o1.name.compareTo(o2.name);
                }
            }

            return 0;
        }
    }
}
