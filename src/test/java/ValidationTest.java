import org.example.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationTest {
    @Test
    @DisplayName("{0000001} -> true")
    void isIDValid1() {
        String id = "0000001";
        boolean actual = Validation.isIDValid(id);
        boolean expected = true;

        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("{null} -> false")
    void isIDValid2() {
        String id = null;
        boolean actual = Validation.isIDValid(id);
        boolean expected = false;

        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("{978030640615-7} -> true")
    void isISBNValid1() {
        String ISBN = "9780306406157";
        boolean actual = Validation.isISBNValid(ISBN);
        boolean expected = true;

        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("{12345} -> false")
    void isISBNValid2() {
        String ISBN = "12345";
        boolean actual = Validation.isISBNValid(ISBN);
        boolean expected = false;

        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("{5} -> true")
    void isIssueNumberValid1() {
        int issueNumber = 5;
        boolean actual = Validation.isIssueNumberValid(issueNumber);
        boolean expected = true;

        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("{-1} -> false")
    void  isIssueNumberValid2() {
        int issueNumber = -1;
        boolean actual = Validation.isIssueNumberValid(issueNumber);
        boolean expected = false;

        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("{Carl} -> true")
    void  isNameValid1() {
        String name = "Carl";
        boolean actual = Validation.isNameValid(name);
        boolean expected = true;

        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("null -> true")
    void  isNameValid2() {
        String name = null;
        boolean actual = Validation.isNameValid(name);
        boolean expected = false;

        assertEquals(expected,actual);
    }
}
