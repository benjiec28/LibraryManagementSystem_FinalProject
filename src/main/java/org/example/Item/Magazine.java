package org.example.Item;

import lombok.*;

import java.util.Comparator;

@Getter
@Setter
@ToString
public class Magazine extends Item {
    private String issueNumber;
    private String publisher;


    public Magazine(String id, Status status, String title, String issueNumber, String publisher) {
        super(id, title, status);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }

    public static class MagazineComparator implements Comparator<Magazine> {
        private String field;

        public MagazineComparator(String field) {
            this.field = field;
        }

        @Override
        public int compare(Magazine o1, Magazine o2) {
            switch (field.toLowerCase()) {
                case "id" -> {
                    return o1.id.compareTo(o2.id);
                }

                case "title" -> {
                    return o1.title.compareTo(o2.title);
                }

                case "issue_number" -> {
                    return o1.issueNumber.compareTo(o2.issueNumber);
                }

                case "publisher" -> {
                    return o1.publisher.compareTo(o2.publisher);
                }
            }

            return 0;
        }
    }
}
