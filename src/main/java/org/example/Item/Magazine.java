package org.example.Item;

import lombok.*;

@Getter
@Setter
@ToString
public class Magazine extends Item {
    private String Title;
    private String issueNumber;
    private String publisher;


    public Magazine(String id, Status status, String title, String issueNumber, String publisher) {
        super(id, status);
        this.Title = title;
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }

}
