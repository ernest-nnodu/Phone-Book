package contacts.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrganizationContact extends Contact {
    private String name;
    private String address;

    public OrganizationContact(String phoneNumber, String name, String address) {
        super(phoneNumber);
        this.name = name;
        this.address = address;
    }

    public String getOrganizationName() {
        return name;
    }

    public void setOrganizationName(String name) {
        this.name = name;
        this.timeLastEdited = LocalDateTime.now();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.timeLastEdited = LocalDateTime.now();
    }

    @Override
    public List<String> getEditableFields() {
        List<String> fields = new ArrayList<>();
        fields.add("name");
        fields.add("address");
        fields.add("number");
        return fields;
    }

    @Override
    public String getFieldValue(String field) {
        return switch (field.toLowerCase()) {
            case "name" -> name;
            case "address" -> address;
            case "number" -> phoneNumber;
            default -> "";
        };
    }

    @Override
    public boolean updateField(String field, String value) {
        switch (field.toLowerCase()) {
            case "name":
                setOrganizationName(value);
                return true;
            case "address":
                setAddress(value);
                return true;
            case "number":
                setPhoneNumber(value);
                return true;
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return "Organization name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Number: " + phoneNumber + "\n" +
                "Time created: " + timeCreated + "\n" +
                "Time last edit: " + timeLastEdited;
    }
}
