/**
 * Created by Gerald Glasgow on 6/3/2017.
 */
public class Main {
    public static void main(String [] args){
        int iterations = 1000000;                                      // iterations each value of 'values' will run
        int values[] = {100,200,300,400,500,600,700,800,900,1000}; // size of arrays being run
        double micro = 1000000.00;                                 // divide nano-seconds by 10^6 to get micro-seconds
        Select1 first = new Select1(values, iterations, micro);
        SelectR random = new SelectR(values, iterations, micro);
        first.startSelect1();
        random.startSelectR();
    }
}