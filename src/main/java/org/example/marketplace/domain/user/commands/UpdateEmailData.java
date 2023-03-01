package org.example.marketplace.domain.user.commands;

import org.example.marketplace.generic.Command;

public class UpdateEmailData extends Command {

    private String userId;
    private String email;

    public UpdateEmailData(String userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
