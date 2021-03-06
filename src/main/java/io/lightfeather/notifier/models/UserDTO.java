package io.lightfeather.notifier.models;

import javax.validation.constraints.NotNull;

public class UserDTO {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;
    private String email;
    private String phoneNumber;

    @NotNull
    private ManagerDTO supervisor;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ManagerDTO getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(ManagerDTO supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", supervisor=" + supervisor +
                '}';
    }
}
