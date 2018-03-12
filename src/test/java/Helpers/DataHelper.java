package Helpers;

import Model.User;
import org.testng.annotations.DataProvider;

public class DataHelper {

    public DataHelper(){
    }

    public User existingUser(){
        return null;
    }

    @DataProvider(name="AuthenticationUsers")
    public static Object[][] credentials() throws Exception {

       // return ExcelHelper.getTableArray("Users.xlsx","Sheet1", 2);
        return null;

    }

    @DataProvider(name="AuthenticationUsers1")
    public static Object[][] credentials1() throws Exception {

        return CsvHelper.getCSVArray("Users.csv");

    }
}
