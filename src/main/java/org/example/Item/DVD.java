package org.example.Item;

import lombok.*;

@Getter
@Setter
@ToString
public class DVD extends Item {
    private String title;
    private String director;
    private int duration;

    @Override
    public void borrowItem() {

    }

    @Override
    public void returnItem() {

    }
}
