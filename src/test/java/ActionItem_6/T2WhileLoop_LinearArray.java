package ActionItem_6;

public class T2WhileLoop_LinearArray {

    public static void main(String[] args) {

        //Declare string array variable.
        String [] region;
        //Defining regions for the linear string array
        region = new String[]{"Rochester", "Buffalo", "Poughkeepsie","Albany"};


        //Declare and define the linear array for area code
        int[] areaCode = new int[] {585,716,845,518 };

        //iterate through all areaCode by while loop
        //set the initializer
        int i = 0;

        //set the condition for whileLoop
        while ( i < areaCode.length){
            System.out.println(" My region is " + region[i] + " and my area code is " + areaCode[i]);

            i++;

        }//end of while loop

    }//end of main


    }//end of java class

