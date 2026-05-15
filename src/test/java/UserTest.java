import org.example.Item.DVD;
import org.example.Item.Item;
import org.example.User.Student;
import org.example.User.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    @DisplayName("Borrow Item Test.")
    void borrowItem() {
        List<Item> mutableList = new ArrayList<>();
        Student student = new Student("0000001", "Carl", mutableList, User.Gender.MALE);

        DVD dvd = new DVD("0000002", Item.Status.IN_STORE, "Inception", "Nolan", 148);

        student.borrowItem(dvd);

        assertEquals(Item.Status.BORROWED, dvd.getStatus(), "Status should change to BORROWED");
        assertTrue(student.getBorrowedItems().contains(dvd), "Mutable list should now contain the item");
        assertEquals(1, student.getBorrowedItems().size());
    }

    @Test
    @DisplayName("Return Item Test.")
    void returnItem() {
        DVD dvd = new DVD("0000002", Item.Status.BORROWED, "Invincible", "Nolan", 148);
        List<Item> initialBorrowed = new ArrayList<>();
        initialBorrowed.add(dvd);

        Student student = new Student("0000001", "Carl", initialBorrowed, User.Gender.MALE);

        student.returnItem(dvd);

        assertEquals(Item.Status.IN_STORE, dvd.getStatus(), "Status should revert to IN_STORE");
        assertFalse(student.getBorrowedItems().contains(dvd), "Item should be removed from the mutable list");
        assertTrue(student.getBorrowedItems().isEmpty());
    }
}
