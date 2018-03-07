package Helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsvHelper {

    public static Object[][] getCSVArray(String file) throws InterruptedException, FileNotFoundException {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<String[]> readedData = new ArrayList<String[]>();

        String[][] tabArray = null;

        try {

            String filePath = new java.io.File("").getAbsolutePath();

            br = new BufferedReader(new FileReader(filePath + "/src/test/java/resources/Data/" + file));

            line = br.readLine();

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] dataRow = line.split(cvsSplitBy);
                readedData.add(dataRow);

            }

            tabArray=new String[readedData.size()][readedData.get(0).length];


            for (int i = 0; i<readedData.size(); i++){
                tabArray[i] = readedData.get(i);
            }


            return  tabArray;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
