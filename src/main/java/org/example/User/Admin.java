package org.example.User;

import lombok.*;

@Getter
@Setter
@ToString
public class Admin extends User implements Reportable{

    @Override
    public void generateReport() {

    }

    @Override
    public boolean borrowItem() {
        return false;
    }

    @Override
    public boolean returnItem() {
        return false;
    }
}
