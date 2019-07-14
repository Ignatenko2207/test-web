package info.sjd.service;

import info.sjd.model.User;

public class UserService {

    public static User findUserByLogin(String login) {
        return new User("test-login", "test-pass");
    }
}
