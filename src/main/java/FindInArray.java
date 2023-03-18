import java.util.concurrent.RecursiveTask;

public class FindInArray extends RecursiveTask<Integer> {

    final int number;

    int arr[], lo, hi;


    public FindInArray(int[] arr, int lo, int hi, int number) {
        this.number = number;
        this.arr = arr;
        this.lo = lo;
        this.hi = hi;
    }

    @Override
    protected Integer compute() {
        return null;
    }
}
