package org.example.marketplace.domain.user.commands;

import org.example.marketplace.generic.Command;

public class UpdatePersonalData extends Command {

    private String userId;
    private String personalDataId;
    private String password;
    private String nickname;

    public UpdatePersonalData (String userId, String personalDataId, String password, String nickname) {
        this.userId = userId;
        this.personalDataId = personalDataId;
        this.password = password;
        this.nickname = nickname;
    }

    public UpdatePersonalData () {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPersonalDataId() {
        return personalDataId;
    }

    public void setPersonalDataId(String personalDataId) {
        this.personalDataId = personalDataId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
