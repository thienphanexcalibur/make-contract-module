package model;

public class Client {

    private int ID;
    private String name;
    private String birthday;
    private String idCardNumber;
    private String email;
    private String phone;
    private String description;

    public Client(int ID, String name, String birthday, String idCardNumber, String email, String phone, String description) {
        this.ID = ID;
        this.name = name;
        this.birthday = birthday;
        this.idCardNumber = idCardNumber;
        this.email = email;
        this.phone = phone;
        this.description = description;
    }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getCardNumber() {
        return this.idCardNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getDescription() {
        return this.description;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
