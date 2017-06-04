/**
 * Created by sslghost on 6/3/2017.
 */
import java.util.Random;

public class Select1 {

    Random rnd = new Random();
    SortingHelper ctrl;
    private int a [];          // array that is reused and resized for sorting
    private int values [];     // array of array sizes for 'a'
    private int iterations;    // iterations each value in 'a' will run
    private double time [][];  // 2D array to hold time values
    private double micro;      // number to divide nano-seconds to micro-seconds

    public Select1(int[] values, int iterations, double micro){
        this.values = values;
        this.iterations = iterations;
        this.time = new double [2][values.length];
        this.micro = micro;
        this.ctrl = new SortingHelper(values);
    }

    public void Select1(int n, int k){
        int low =0; int up = n;
        boolean found = false;
        while(!found) {
            int j = partition(low, up);
            if (k == j) found = true;
            else if (k < j) up = j-1;
            else low = j + 1;
        }
    }

    public int partition(int start, int end){
        int pivot = a[start];
        while(start<end){
            while(a[start] < pivot){
                start++;
            }
            while(a[end] > pivot){
                end--;
            }
            if(start < end || (a[end] == pivot && a[start] < a[end])) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++; end--;
            }
        } // end while
        return start;
    }
    public void startSelect1() {
        long x, y;
        int tests = 0;

        /* Average Case */
        for (int k = 0; k < values.length; k++) {
            for (int i = 0; i < iterations; i++) {
                a = ctrl.getAverageArray(values[k]);
                x = System.nanoTime();
                Select1(a.length-1, rnd.nextInt(a.length));
                y = System.nanoTime();
                time[tests][k] += (double) (y - x)/micro;
            }
            time[tests][k] /= (double)(iterations);
        }
        System.out.println("Results for pivot = first array index for average case");
        ctrl.printResults(time, tests);
        System.out.println();

        /* Worst Case */
        tests++;
        for (int k = 0; k < values.length; k++) {
            for (int i = 0; i < iterations; i++) {
                a = ctrl.getWorstArray(values[k]+1);
                x = System.nanoTime();
                Select1(a.length-1, rnd.nextInt(a.length));
                y = System.nanoTime();
                time[tests][k] += (double) (y - x)/micro;
            }
            time[tests][k] /= (double) (iterations);
        }
        System.out.println("Results for pivot = first array index for worst case");
        ctrl.printResults(time, tests);
        System.out.println();
    }

}
