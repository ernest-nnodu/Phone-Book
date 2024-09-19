import contacts.Contact;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class ContactTests {

    @Test
    @DisplayName("Create contact")
    public void testCreateContact() {
        String expectedName = "John";
        String expectedSurname = "Doe";
        String expectedPhoneNumber = "1234-567-89";

        Contact contact = new Contact(expectedName, expectedSurname, expectedPhoneNumber);
        assertEquals(expectedName, contact.getName());
        assertEquals(expectedSurname, contact.getSurname());
        assertEquals(expectedPhoneNumber, contact.getPhoneNumber());
    }

    @Test
    @DisplayName("Create empty contact")
    public void testCreateEmptyContact() {
        Contact contact = new Contact();

        assertNull(contact.getName());
        assertNull(contact.getSurname());
        assertNull(contact.getPhoneNumber());
    }

    @Test
    @DisplayName("Modify empty contact")
    public void testModifyEmptyContact() {

        String expectedName = "John";
        String expectedSurname = "Doe";
        String expectedPhoneNumber = "1234-567-89";

        Contact contact = new Contact();
        contact.setName(expectedName);
        contact.setSurname(expectedSurname);
        contact.setPhoneNumber(expectedPhoneNumber);

        assertEquals(expectedName, contact.getName());
        assertEquals(expectedSurname, contact.getSurname());
        assertEquals(expectedPhoneNumber, contact.getPhoneNumber());
    }

    @Test
    @DisplayName("Modify non empty contact")
    public void testModifyNonEmptyContact() {
        String expectedName = "John";
        String expectedSurname = "Doe";
        String expectedPhoneNumber = "1234-567-89";

        Contact contact = new Contact("Mary", "Appelbaum", "000-111-222");
        contact.setName(expectedName);
        contact.setSurname(expectedSurname);
        contact.setPhoneNumber(expectedPhoneNumber);

        assertEquals(expectedName, contact.getName());
        assertEquals(expectedSurname, contact.getSurname());
        assertEquals(expectedPhoneNumber, contact.getPhoneNumber());

    }
}