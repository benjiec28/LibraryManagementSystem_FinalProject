package org.example;

public class Validation {

    /**
     * Checks if ID is valid.
     * @param id the id
     * @return true if the id is valid; false if it's not.
     */
    public boolean isIDValid(String id) {
        return id.matches("\\d{7}");
    }

    /**
     * Checks if ISBN is valid.
     * @param isbn the isbn.
     * @return true if the isbn is valid; false if it's not.
     */
    public boolean isISBNValid(String isbn) {
        return isbn.matches("\\d{13}");
    }
}
