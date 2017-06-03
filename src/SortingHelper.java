/**
 * Created by sslghost on 6/3/2017.
 */
import java.util.Random;

/**
 * Created by Gerald Glasgow on 6/2/2017.
 */

class SortingHelper {

    private int [] values;

    /**
     * Constructor initializes the value of the global array
     * @param values number of array to be sorted
     */
    public SortingHelper(int [] values){
        this.values = values;
    }

    /**
     * function to generate and insert random integers into an array
     * @param a size of array
     * @return array of random integers
     */
    public int[] getAverageArray(int a){
        Random rnd = new Random();
        int[] array = new int[a];
        for(int i=0;i<a;i++){
            array[i] = rnd.nextInt(100)+1;
        }
        return array;
    }

    /**
     * function to insert numbers in non-decreasing order into
     * the array starting at 0 and going to 'a'-1
     * @param a size of array
     * @return array created with values in non-decreasing order
     */
    public int[] getWorstArray(int a){
        int[] array = new int[a];
        for(int i=0;i<a;i++){
            array[i] = i;
        }
        return array;
    }

    /**
     * function prints out results of program.
     * @param time array of average time for each array size
     * @param tests to keep track of worst and best case times
     */
    public void printResults(double time [][], int tests){
        for(int i=tests-1;i<tests;i++){
            for(int k=0;k<values.length;k++){
                System.out.println("n = " + values[k] + " runtime: " + time[tests][k]);
            }
        }
    }
    public void printArray(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }

}

