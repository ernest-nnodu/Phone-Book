package contacts.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersonContact extends Contact {
    private String name;
    private String surname;
    private String birthDate;
    private String gender;

    public PersonContact(String phoneNumber, String name, String surname, String birthDate, String gender) {
        super(phoneNumber);
        this.name = name;
        this.surname = surname;
        setBirthDate(birthDate);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.timeLastEdited = LocalDateTime.now();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        this.timeLastEdited = LocalDateTime.now();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        if (birthDate == null || birthDate.isEmpty()) {
            System.out.println("Bad birth date!");
            this.birthDate = "[no data]";
        } else {
            this.birthDate = birthDate;
        }
        this.timeLastEdited = LocalDateTime.now();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null || (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F"))) {
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        } else {
            this.gender = gender.toUpperCase();
        }
        this.timeLastEdited = LocalDateTime.now();
    }

    @Override
    public List<String> getEditableFields() {
        List<String> fields = new ArrayList<>();
        fields.add("name");
        fields.add("surname");
        fields.add("birth");
        fields.add("gender");
        fields.add("number");
        return fields;
    }

    @Override
    public String getFieldValue(String field) {
        return switch (field.toLowerCase()) {
            case "name" -> name;
            case "surname" -> surname;
            case "birth" -> birthDate;
            case "gender" -> gender;
            case "number" -> phoneNumber;
            default -> "";
        };
    }

    @Override
    public boolean updateField(String field, String value) {
        switch (field.toLowerCase()) {
            case "name":
                setName(value);
                return true;
            case "surname":
                setSurname(value);
                return true;
            case "birth":
                setBirthDate(value);
                return true;
            case "gender":
                setGender(value);
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
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Birth date: " + birthDate + "\n" +
                "Gender: " + gender + "\n" +
                "Number: " + phoneNumber + "\n" +
                "Time created: " + timeCreated + "\n" +
                "Time last edit: " + timeLastEdited;
    }
}
