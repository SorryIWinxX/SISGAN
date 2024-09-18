package com.uis.sisgan.DTO;

import com.uis.sisgan.persistence.entity.Role;
import java.time.LocalDate;

public class UserRegistrationRequest {
    private String idCard;
    private String idDrivingLicense;
    private Integer idCardIca;
    private String mark;
    private String farmName;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDate birthDate;
    private String email;
    private Role role;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdDrivingLicense() {
        return idDrivingLicense;
    }

    public void setIdDrivingLicense(String idDrivingLicense) {
        this.idDrivingLicense = idDrivingLicense;
    }

    public Integer getIdCardIca() {
        return idCardIca;
    }

    public void setIdCardIca(Integer idCardIca) {
        this.idCardIca = idCardIca;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
