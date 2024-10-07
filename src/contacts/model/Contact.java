package contacts.model;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Contact {
    protected String phoneNumber;
    protected LocalDateTime timeCreated;
    protected LocalDateTime timeLastEdited;

    public Contact(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        this.timeCreated = LocalDateTime.now();
        this.timeLastEdited = LocalDateTime.now();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isNumberValid(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "[no number]";
        }
        this.timeLastEdited = LocalDateTime.now();
    }

    private boolean isNumberValid(String phoneNumber) {
        String pattern = "\\+?(\\([a-zA-Z0-9]+\\)([\\s-][a-zA-Z0-9]{2,})?|" +
                "[a-zA-Z0-9]+([\\s-]\\(?[a-zA-Z0-9]{2,}\\)?)?)" + "([\\s-][a-zA-Z0-9]{2,})*";
        return phoneNumber.matches(pattern);
    }

    public boolean hasValidNumber() {
        return !this.phoneNumber.equals("[no number]");
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public LocalDateTime getTimeLastEdited() {
        return timeLastEdited;
    }

    public abstract List<String> getEditableFields();

    public abstract String getFieldValue(String field);

    public abstract boolean updateField(String field, String value);

    @Override
    public abstract String toString();
}
