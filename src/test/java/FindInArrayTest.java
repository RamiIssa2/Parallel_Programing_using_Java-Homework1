import junit.framework.TestCase;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class FindInArrayTest extends TestCase {

    private int[] randomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1,100_001);
        }
        /* Check  random array
        Arrays.stream(arr).forEach(System.out::println);*/
        return arr;
    }

    public void testFindInArraySeq() {

        int size = 100_000_000;
        int number = 5000;
        int[] arr = randomArray(size);

        FindInArray array = new FindInArray(arr, 0, arr.length - 1, number);
        long start = System.currentTimeMillis();
        array.computeSeq();
        int count = array.count;
        long endTimer = System.currentTimeMillis() - start;
        System.out.printf("Sequential Time execution for Random Array of size %d is %d ms count is %d\n", size, endTimer, count);
    }

    public void testFindInArrayPP() {

        int size = 100_000_000;
        int number = 5000;
        int[] arr = randomArray(size);

        FindInArray array = new FindInArray(arr, 0, arr.length - 1, number);
        long start = System.currentTimeMillis();
        ForkJoinPool.commonPool().invoke(array);
        int count = array.count;
        long endTimer = System.currentTimeMillis() - start;
        System.out.printf("Parallel Time execution for Random Array of size %d is %d ms count is %d\n", size, endTimer, count);
    }

    public void testFindInArraySeqStream() {

        int size = 100_000_000;
        int number = 5000;
        int[] arr = randomArray(size);

        FindInArray array = new FindInArray(arr, 0, arr.length - 1, number);
        long start = System.currentTimeMillis();
        array.computeSeqStream();
        int count = array.count;
        long endTimer = System.currentTimeMillis() - start;
        System.out.printf("Sequential Stream Time execution for Random Array of size %d is %d ms count is %d\n", size, endTimer, count);
    }

    public void testFindInArrayPPStream() {

        int size = 100_000_000;
        int number = 5000;
        int[] arr = randomArray(size);

        FindInArray array = new FindInArray(arr, 0, arr.length - 1, number);
        long start = System.currentTimeMillis();
        array.computePPStream();
        int count = array.count;
        long endTimer = System.currentTimeMillis() - start;
        System.out.printf("Parallel Stream Time execution for Random Array of size %d is %d ms count is %d\n", size, endTimer, count);
    }
}
