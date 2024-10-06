package contacts;


import java.util.ArrayList;
import java.util.List;

class OrganizationContact extends Contact {

    private String name;
    private String address;


    public OrganizationContact(String phoneNumber, String name, String address) {
        super(phoneNumber);
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public List<String> getFields() {
        List<String> fields = new ArrayList<>();
        fields.add("name");
        fields.add("address");
        fields.add(super.getFields().get(0));
        return fields;
    }

    @Override
    public String getFieldValue(String field) {

        return switch (field) {
            case "name" -> this.name;
            case "address" -> this.address;
            case "number" -> super.getFieldValue(field);
            default -> "";
        };
    }

    public void setField(String field, String value) {
        switch (field) {
            case "name":
                setName(value);
            case "address":
                setAddress(value);
            case "number":
                super.setField(field, value);
        }
    }

    @Override
    public String toString() {
        return "Organization name: " + this.name + "\n" +
                "Address: " + this.address + "\n" +
                "Number: " + this.phoneNumber + "\n" +
                "Time created: " + this.timeCreated + "\n" +
                "Time last edit: " + this.timeLastEdited;
    }
}