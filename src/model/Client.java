package model;

public class Client {

    private int ID;
    private String name;
    private String birthday;
    private String idCardNumber;
    private String email;
    private String phone;
    private String description;
    private int contractID;

    public Client(int ID, String name, String birthday, String idCardNumber, String email, String phone, int contractID) {
        this.ID = ID;
        this.name = name;
        this.birthday = birthday;
        this.idCardNumber = idCardNumber;
        this.email = email;
        this.phone = phone;
        this.contractID = contractID;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
