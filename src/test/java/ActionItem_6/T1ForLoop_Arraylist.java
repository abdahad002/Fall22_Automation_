package ActionItem_6;

import com.google.common.collect.ArrayListMultimap;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class T1ForLoop_Arraylist {

    public static void main(String[] args) {

        //Declare and define the arraylist for countries
        ArrayList<String> Country = new ArrayList<>();
        Country.add("Bangladesh");
        Country.add("Japan");
        Country.add("Pakistan");
        Country.add("Nepal");

        //Declare and define countryCode using integer
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(+880);
        countryCode.add(+81);
        countryCode.add(+92);
        countryCode.add(+91);

        for (int i = 0; i < Country.size(); i++) {
            System.out.println("My country is " + Country.get(i) + " and my country code is " + countryCode.get(i));
        }//end of forLoop

    }//end of main

}//End of java class
