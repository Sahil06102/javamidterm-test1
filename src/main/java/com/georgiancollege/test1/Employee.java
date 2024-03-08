package com.georgiancollege.test1;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String province;
    private String phone;


    public Employee(int employeeId, String firstName, String lastName, String address, String city, String province, String phone) {
        if (employeeId <= 200465000) {
            throw new IllegalArgumentException("Invalid employee ID");
        }
        if (firstName.length() <= 1) {
            throw new IllegalArgumentException("First name must be more than 1 character");
        }
        if (lastName.length() <= 1) {
            throw new IllegalArgumentException("Last name must be more than 1 character");
        }
        if (address.length() <= 5) {
            throw new IllegalArgumentException("Address must be more than 5 characters");
        }
        if (!phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        if (!Arrays.asList("AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK", "YT").contains(province)) {
            throw new IllegalArgumentException("Invalid province");
        }
        if (city.length() <= 3) {
            throw new IllegalArgumentException("City must be more than 3 characters");
        }

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.province = province;
        this.phone = phone;
    }

    // Getters and Setters

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
