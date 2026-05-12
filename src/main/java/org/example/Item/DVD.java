package org.example.Item;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class DVD {
    private String title;
    private String director;
    private int duration;
}
