import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class FindInArray extends RecursiveAction {

    final int number;
    public int count;
    int[] arr;
    int lo;
    int hi;


    public FindInArray(int[] arr, int lo, int hi, int number) {
        this.number = number;
        this.arr = arr;
        this.lo = lo;
        this.hi = hi;
    }

    public void computeSeq() {
        for (int i = lo; i <= hi; ++i) {
            if (arr[i] == number){
                count++;
            }
        }
    }

    @Override
    protected void compute() {
        if (hi - lo > 1_000_000) {
            int mid = (lo + hi) / 2;
            FindInArray left = new FindInArray(arr, lo, mid, number);
            FindInArray right = new FindInArray(arr, mid + 1, hi, number);
            left.fork();
            right.compute();
            left.join();
            count = left.count + right.count;
        }
        else {
            this.computeSeq();
        }
    }

    public void computeSeqStream() {
        count = (int) Arrays.stream(arr).filter(x -> x == number).count();
    }

    public void computePPStream() {
        count = (int) Arrays.stream(arr).parallel().filter(x -> x == number).count();
    }
}
