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
        System.out.printf("Fibonacci for %d is %d, and parallel execution took %d ms or %d ns\n",n,res,end,endNano);
//        Fibonacci parallel takes 144269 fon n = 50 before enhancement 1
    }

    public void testFiboSeq(){
        long start = System.currentTimeMillis();
        long startNano = System.nanoTime();
        Fibonacci fib = new Fibonacci(n);
        long res = fib.computeSeq();
        long end = System.currentTimeMillis()-start;
        long endNano = System.nanoTime() - startNano;
        System.out.printf("Fibonacci for %d is %d, and sequential execution took %d ms or %d ns\n",n,res,end,endNano);
        //Fibonacci Sequential takes 86495 fon n = 50 before enhancement 1
    }
}
