import junit.framework.TestCase;


@SuppressWarnings("SpellCheckingInspection")
public class FibonacciTest extends TestCase {

    int n=50;

    public void testFiboPP(){
        long start = System.currentTimeMillis();
        long startNano = System.nanoTime();
        Fibonacci fib = new Fibonacci(n);
        long res = fib.compute();
        long end = System.currentTimeMillis() - start;
        long endNano = System.nanoTime() - startNano;
        System.out.println("Fibonacci parallel takes 144269 ms for n = 50 before enhancement");
        System.out.printf("Fibonacci for n = %d is %d, and parallel execution took %d ms or %d ns after enhancement\n\n",n,res,end,endNano);
    }

    public void testFiboSeq(){
        long start = System.currentTimeMillis();
        long startNano = System.nanoTime();
        Fibonacci fib = new Fibonacci(n);
        long res = fib.computeSeq();
        long end = System.currentTimeMillis()-start;
        long endNano = System.nanoTime() - startNano;
        System.out.println("Fibonacci Sequential takes 86495 ms for n = 50 before enhancement");
        System.out.printf("Fibonacci for n = %d is %d, and sequential execution took %d ms or %d ns after enhancement\n\n",n,res,end,endNano);
    }
}
