package A1020I1_DangVanThuan_CaseStudy.Models;

import java.util.List;

public class Customer implements Comparable<Customer> {

    private String nameCustomer;
    private String dayOfBirth;
    private String gender;
    private String cardNumber;
    private String phoneNumber;
    private String email;
    private String typeCustomer;
    private String address;
    private Services services;

    public Customer() {
    }

    public Customer(String nameCustomer, String dayOfBirth, String gender, String cardNumber, String phoneNumber, String email, String typeCustomer, String address) {
        this.nameCustomer = nameCustomer;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.cardNumber = cardNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public void showInfor() {
        System.out.println(
                "Full Name: " + this.nameCustomer + "\n"
                + "Day of Birth: " + this.dayOfBirth + "\n"
                + "Gender: " + this.gender + "\n"
                + "Card Number: " + this.cardNumber + "\n"
                + "Phone Number: " + this.phoneNumber + "\n"
                + "Email: " + this.email + "\n"
                + "Type Customer: " + this.typeCustomer + "\n"
                + "Address: " + this.address + "\n"
                + "Services: " + services + "\n"
                + "--------------------------------------------"
        );
    }

    @Override
    public int compareTo(Customer o) {
        if(this.nameCustomer.equals(o.nameCustomer)){
            return this.dayOfBirth.compareTo(o.dayOfBirth);
        }
        return this.getNameCustomer().compareTo(o.getNameCustomer());
    }
}
