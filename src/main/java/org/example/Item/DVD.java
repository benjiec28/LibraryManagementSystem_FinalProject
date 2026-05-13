package org.example.Item;

import lombok.*;

import java.util.Comparator;

@Getter
@Setter
@ToString
public class DVD extends Item {
    private String director;
    private int duration;

    public DVD(String id, Status status, String title, String director, int duration) {
        super(id, title, status);
        this.title = title;
        this.director = director;
        this.duration = duration;
    }

    public static class DVDComparator implements Comparator<DVD> {
        private String field;

        public DVDComparator(String field) {
            this.field = field;
        }

        @Override
        public int compare(DVD o1, DVD o2) {
            switch (field.toLowerCase()) {
                case "id" -> {
                    return o1.id.compareTo(o2.id);
                }

                case "title" -> {
                    return o1.title.compareTo(o2.title);
                }

                case "director" -> {
                    return o1.director.compareTo(o2.director);
                }

                case "duration" -> {
                    return Integer.compare(o1.duration, o2.duration);
                }
            }

            return 0;
        }
    }
}
