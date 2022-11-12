package Day2_100222;

import java.util.ArrayList;

public class T2_ArrayList {
    public static void main(String[] args) {
        //declare and define an arraylist of countries
        ArrayList<String> countries = new ArrayList<>();
        //now add the values for countries array
        countries.add("USA");
        countries.add("Canada");
        countries.add("Bangladesh");
        countries.add("India");

        //print usa from the countries list
        System.out.println("Countries value: " + countries.get(0));
        //get me all the count of the countries list
        System.out.println("Countries count: " + countries.size());
    }
}
