package org.example.marketplace.domain.user.commands;

import org.example.marketplace.generic.Command;

import java.util.Date;

public class CreatePersonalDataCommand extends Command {

    private String personalDataId;
    private String name;
    private String lastname;
    private String email;
    private String birthDay;
    private String userId;

    //private String Address; //Question: What type should I use here?


    public CreatePersonalDataCommand(String personalDataId, String name, String lastname, String email, String birthDay,String userId) {
        this.personalDataId = personalDataId;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthDay = birthDay;
        this.userId = userId;
    }

    private CreatePersonalDataCommand() {
    }

    public String getPersonalDataId() {
        return personalDataId;
    }

    public void setPersonalDataId(String personalDataId) {
        this.personalDataId = personalDataId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
