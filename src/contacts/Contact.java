package contacts;

import java.time.LocalDateTime;

public class Contact {

    private String phoneNumber;
    private boolean isPerson;
    private LocalDateTime timeCreated;
    private LocalDateTime timeLastEdited;

    public Contact() {
        phoneNumber = "";
        timeCreated = LocalDateTime.now();
        timeLastEdited = LocalDateTime.now();
    }

    public Contact(String phoneNumber, boolean isPerson) {
        this.phoneNumber = "";
        this.setPhoneNumber(phoneNumber);
        this.isPerson = isPerson;
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

    public boolean isPerson() {
        return isPerson;
    }

    public void setPerson(boolean person) {
        isPerson = person;
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
}