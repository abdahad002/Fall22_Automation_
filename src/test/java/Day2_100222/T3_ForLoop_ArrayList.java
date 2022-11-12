package Day2_100222;

import java.util.ArrayList;

public class T3_ForLoop_ArrayList {

    public static void main(String[] args) {

        //declare and define the arrayList for zip code
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("10001");
        zipCode.add("11219");
        zipCode.add("11377");
        zipCode.add("11376");

        //call for loop to print out all zip code values from the array list
        for (int i = 0; i < zipCode.size() ; i++) {
            //print out each zip code automatically
            System.out.println("Zip code: " + zipCode.get(i));

        }//end of for loop

    }//end of main
}//end of java class
