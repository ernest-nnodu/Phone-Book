package contacts;

class PersonContact extends Contact {

    private String name;
    private String surname;
    private String birthDate;
    private String gender;

    public PersonContact(String phoneNumber, boolean isPerson, String name, String surname, String birthDate, String gender) {
        super(phoneNumber, isPerson);
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
}