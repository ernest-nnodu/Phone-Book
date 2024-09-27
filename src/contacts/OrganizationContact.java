package contacts;


class OrganizationContact extends Contact {

    private String name;
    private String address;


    public OrganizationContact(String phoneNumber, boolean isPerson, String name, String address) {
        super(phoneNumber, isPerson);
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
}