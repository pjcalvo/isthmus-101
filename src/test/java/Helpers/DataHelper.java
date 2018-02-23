package Helpers;

import Model.User;

public class DataHelper {
    public DataHelper(){}

    public User existingUser(){
        return new User("pablo@pablillo.com","123456");
    }
}
