package Helpers;

import Model.User;
import org.testng.annotations.DataProvider;

public class DataHelper {

    public DataHelper(ExcelHelper excelHelper){
    }

    public User existingUser(){
        return new User("emma@pablillo.com","123456");
    }

    @DataProvider(name="AuthenticationUsers")
    public static Object[][] credentials() throws Exception {

        return ExcelHelper.getTableArray("Users.xlsx","Sheet1", 2);

    }
}
