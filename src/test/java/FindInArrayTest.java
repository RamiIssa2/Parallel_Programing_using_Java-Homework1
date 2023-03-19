import junit.framework.TestCase;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class FindInArrayTest extends TestCase {


    private final int size = 1_000_000_000;
    @SuppressWarnings("SameParameterValue")
    private int[] randomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1,100_001);
        }
        return arr;
    }

    @SuppressWarnings("unused")
    private int[] intStream(int size) {
        IntStream intStream = IntStream.range(1, size);
        return intStream.toArray();
    }

    public void testFindInArraySeq() {

        int number = 5000;
        int[] arr = randomArray(size);

        FindInArray array = new FindInArray(arr, 0, arr.length - 1, number);
        long start = System.currentTimeMillis();
        array.computeSeq();
        int count = array.count;
        long endTimer = System.currentTimeMillis() - start;
        System.out.printf("Sequential Time execution for Random Array of size %d is %d ms count is %d\n\n", size, endTimer, count);
    }

    public void testFindInArrayPP() {

        int number = 5000;
        int[] arr = randomArray(size);

        FindInArray array = new FindInArray(arr, 0, arr.length - 1, number);
        long start = System.currentTimeMillis();
        ForkJoinPool.commonPool().invoke(array);
        int count = array.count;
        long endTimer = System.currentTimeMillis() - start;
        System.out.printf("Parallel Time execution for Random Array of size %d is %d ms count is %d\n\n", size, endTimer, count);
    }

    public void testFindInArraySeqStream() {

        int number = 5000;
        int[] arr = randomArray(size);

        FindInArray array = new FindInArray(arr, 0, arr.length - 1, number);
        long start = System.currentTimeMillis();
        array.computeSeqStream();
        int count = array.count;
        long endTimer = System.currentTimeMillis() - start;
        System.out.printf("Sequential Stream Time execution for Random Array of size %d is %d ms count is %d\n\n", size, endTimer, count);
    }

    public void testFindInArrayPPStream() {

        int number = 5000;
        int[] arr = randomArray(size);

        FindInArray array = new FindInArray(arr, 0, arr.length - 1, number);
        long start = System.currentTimeMillis();
        array.computePPStream();
        int count = array.count;
        long endTimer = System.currentTimeMillis() - start;
        System.out.printf("Parallel Stream Time execution for Random Array of size %d is %d ms count is %d\n\n", size, endTimer, count);
    }
}
