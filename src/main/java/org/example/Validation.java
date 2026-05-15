package org.example;

public class Validation {

    /**
     * Checks if ID is valid.
     * @param id the id
     * @return true if the id is valid; false if it's not.
     */
    public static boolean isIDValid(String id) {
        return id != null && id.trim().matches("\\d{7}");
    }

    /**
     * Checks if ISBN is valid.
     * @param isbn the isbn.
     * @return true if the isbn is valid; false if it's not.
     */
    public static boolean isISBNValid(String isbn) {
        return isbn.matches("\\d{13}");
    }

    /**
     * Checks if issue number is valid.
     * @param issueNumber the issue number.
     * @return true if the issue number is valid ; false if not.
     */
    public static boolean isIssueNumberValid(int issueNumber) {
        return issueNumber > 0;
    }

    /**
     * Checks if name is valid.
     * @param name the name
     * @return true if the name is valid ; false if not.
     */
    public static boolean isNameValid(String name) {
        if (name == null) {
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            if (Character.isLetter(name.charAt(i))) {
                return true;
            }
        }

        return false;
    }
}
