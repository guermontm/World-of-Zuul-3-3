package formationnetbeans_exo1;

public class FFdebugCalc {

    /**
     * This class give the max value 
     * @param array is the array
     * @return give the max value
     */
    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        
        return max;
    }

    /**
     * This class give the min value 
     * @param array is an array 
     * @return the min value 
     */
    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
