package org.example.User;

import lombok.*;
import org.example.Item.Item;

import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@ToString
public class Student extends User {

    public Student(String id, String name, List<Item> borrowedItems, Gender gender) {
        super(id, name, borrowedItems, gender);
    }

    public static class StudentComparator implements Comparator<Student> {
       private String field;

        public StudentComparator(String field) {
            this.field = field;
        }

        @Override
        public int compare(Student o1, Student o2) {
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
