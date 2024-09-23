package contacts;

public class Contact {

    private String name;
    private String surname;
    private String phoneNumber;

    public Contact() {
        name = "";
        surname = "";
        phoneNumber = "";
    }

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = "";
        this.setPhoneNumber(phoneNumber);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}