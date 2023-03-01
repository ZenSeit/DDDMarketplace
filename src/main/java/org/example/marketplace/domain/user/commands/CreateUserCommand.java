package org.example.marketplace.domain.user.commands;

import org.example.marketplace.generic.Command;

public class CreateUserCommand extends Command {
    private String userId;

    private String password;
    private String nickname;

    public CreateUserCommand(String userId, String password, String nickname) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
    }

    public CreateUserCommand() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
