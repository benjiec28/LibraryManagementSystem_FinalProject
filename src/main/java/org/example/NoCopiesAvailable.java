package org.example;

public class NoCopiesAvailable extends RuntimeException {
    public NoCopiesAvailable(String message) {
        super(message);
    }
}
