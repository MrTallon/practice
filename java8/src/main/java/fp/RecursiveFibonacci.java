package fp;

/**
 * @author yangbo
 */
public class RecursiveFibonacci {

    private interface IntCall {
        /**
         * 计算方法
         * @param arg
         * @return
         */
        int call(int arg);
    }

    IntCall fib;

    private RecursiveFibonacci() {
        fib = n -> n == 0 ? 0 :
                n == 1 ? 1 :
                        fib.call(n - 1) + fib.call(n - 2);
    }

    private int fibonacci(int n) { return fib.call(n); }

    public static void main(String[] args) {
        RecursiveFibonacci rf = new RecursiveFibonacci();
        for(int i = 0; i <= 10; i++) {
            System.out.println(rf.fibonacci(i));
        }
    }


}
