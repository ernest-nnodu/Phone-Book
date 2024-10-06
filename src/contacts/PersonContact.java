package contacts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PersonContact extends Contact {

    private String name;
    private String surname;
    private String birthDate;
    private String gender;

    public PersonContact(String phoneNumber, String name, String surname, String birthDate, String gender) {
        super(phoneNumber);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public List<String> getFields() {
        List<String> fields = new ArrayList<>();
        fields.add("name");
        fields.add("surname");
        fields.add("birth");
        fields.add("gender");
        fields.add(super.getFields().get(0));
        return fields;
    }

    @Override
    public String getFieldValue(String field) {
        String value = "";

        return switch (field) {
            case "name" -> this.name;
            case "surname" -> this.surname;
            case "birth" -> this.birthDate;
            case "gender" -> this.gender;
            case "number" -> super.getFieldValue(field);
            default -> value;
        };
    }

    public void setField(String field, String value) {

        switch (field) {
            case "name":
                setName(value);
            case "surname":
                setSurname(value);
            case "birth":
                setBirthDate(value);
            case "gender":
                setGender(value);
            case "number":
                super.setField(field, value);
        }
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n" +
                "Surname: " + this.surname + "\n" +
                "Birth date: " + this.birthDate + "\n" +
                "Gender: " + this.gender + "\n" +
                "Number: " + this.phoneNumber + "\n" +
                "Time created: " + this.timeCreated + "\n" +
                "Time last edit: " + this.timeLastEdited;
    }
}