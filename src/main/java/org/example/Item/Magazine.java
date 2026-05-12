package org.example.Item;

import lombok.*;

@Getter
@Setter
@ToString
public class Magazine extends Item {
    private String Title;
    private String issueNumber;
    private String publisher;

    @Override
    public void borrowItem() {

    }

    @Override
    public void returnItem() {

    }
}
