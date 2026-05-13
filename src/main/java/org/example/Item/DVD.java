package org.example.Item;

import lombok.*;

@Getter
@Setter
@ToString
public class DVD extends Item {
    private String title;
    private String director;
    private int duration;

    public DVD(String id, Status status, String title, String director, int duration) {
        super(id, status);
        this.title = title;
        this.director = director;
        this.duration = duration;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
