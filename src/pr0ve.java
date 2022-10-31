public class pr0ve {
/*
    public static int tverrsum(int n)
    {
        System.out.println("tverrsum(" + n + ") starter!");
        int sum = (n < 10) ? n : tverrsum(n / 10) + (n % 10);
        System.out.println("tverrsum(" + n + ") er ferdig!");
        return sum;
    }

*/

    public static int fib(int n)
    {
        if (n <= 1) return n;
        else return fib(n-1)+ fib(n-2);
    }


    public static void main(String... args)
    {
      //  System.out.println("main() starter!");
      //  int sum = tverrsum(7295);
      //  System.out.println("main() er ferdig! and n = "+sum);
        System.out.println(fib(10));

    }

}
