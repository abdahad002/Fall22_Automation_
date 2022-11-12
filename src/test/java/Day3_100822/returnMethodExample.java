package Day3_100822;

public class returnMethodExample {

    public static void main(String[] args) {
        //the result of return method is equal to the value you stored in the new variable
        int value = ReusableClass.returnTwoAddNumbers(5,2);
        //now you can set additional calculation to the value since you stored it as a variable
        System.out.println("new value is " +(value+3));
    }//end of main


}//end of java class
