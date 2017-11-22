package formationnetbeans_exo1;

import java.util.Scanner;

public class FFdebugTest {

    private int[] myArray;
    private int myInt;
    private boolean myBoolean;
    private String myString;

    /**
     * The constructor of the class 
     * @param myArray is an array with the given number
     */
    public FFdebugTest(int[] myArray) {
        this.myArray = myArray;
    }
    
    /**
     * the getter of the array
     * @return 
     */
    public int[] getMyArray() {
        return myArray;
    }

    public void setMyArray(int[] myArray) {
        this.myArray = myArray;
    }
    

    public int getMyInt() {
        return myInt;
    }

    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

    public boolean isMyBoolean() {
        return myBoolean;
    }

    public void setMyBoolean(boolean myBoolean) {
        this.myBoolean = myBoolean;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public static void main(String[] args) {
        FFdebugTest debug = new FFdebugTest(new int[3]);
        FFdebugTest.getValue(debug.myArray);
        System.out.println("La plus grande valeur est : "
                + FFdebugCalc.findMax(debug.myArray));
        System.out.println("La plus petite valeur est : "
                + FFdebugCalc.findMin(debug.myArray));
    }

    public static void getValue(int[] array) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Entrer un nombre : ");
            array[i] = scan.nextInt();
        }
    }
}
