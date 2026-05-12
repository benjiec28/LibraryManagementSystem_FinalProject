package org.example.User;

import lombok.*;
import org.example.Item.Item;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Teacher {
    private List<Item> borrowedItems;
}
