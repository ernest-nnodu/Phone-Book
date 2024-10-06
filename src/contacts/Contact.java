package contacts;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Contact {

    protected String phoneNumber;
    protected LocalDateTime timeCreated;
    protected LocalDateTime timeLastEdited;

    public Contact() {
        phoneNumber = "";
        timeCreated = LocalDateTime.now();
        timeLastEdited = LocalDateTime.now();
    }

    public Contact(String phoneNumber) {
        this.phoneNumber = "";
        this.setPhoneNumber(phoneNumber);
        timeCreated = LocalDateTime.now();
        timeLastEdited = LocalDateTime.now();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        if (numberValid(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "[no number]";
        }
    }

    private boolean numberValid(String phoneNumber) {

        String pattern = "\\+?(\\([a-zA-Z0-9]+\\)([\\s-][a-zA-Z0-9]{2,})?|" +
                "[a-zA-Z0-9]+([\\s-]\\(?[a-zA-Z0-9]{2,}\\)?)?)" + "([\\s-][a-zA-Z0-9]{2,})*";

        return phoneNumber.matches(pattern);
    }

    public boolean hasNumber() {
        return phoneNumber.isEmpty() || phoneNumber.equals("[no number]");
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public LocalDateTime getTimeLastEdited() {
        return timeLastEdited;
    }

    public void setTimeLastEdited(LocalDateTime timeLastEdited) {
        this.timeLastEdited = timeLastEdited;
    }

    public List<String> getFields() {
        List<String> fields = new ArrayList<>();
        fields.add("number");
        return fields;
    }

    public String getFieldValue(String field) {
        if (field.equals("number")) {
            return this.phoneNumber;
        }
        return "";
    }

    public void setField(String field, String value) {
        if (field.equals("number")) {
            setPhoneNumber(value);
        }
    }
}