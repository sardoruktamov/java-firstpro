package uz.mohirdev.lesson.web.rest.vm;

import javax.validation.constraints.NotNull;

// JWT token 8-qadam
public class LoginVM {

    @NotNull
    private String login;
    @NotNull
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
