import java.util.Scanner;

public class FibonacciIterative
{
    public static int counter = 0;
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = -1;
        while(n < 0)
        {
            System.out.println("Vilket tal i fibonaccisekvensen vill du beräkna?");
            n = scan.nextInt();
        }

        System.out.println("Det " + n + " fibonaccitalet är: " + fib(n));
        System.out.println("Antal loopvarv för att räkna ut talet: " + counter);
    }

    /**
     * En metod som använder tabulering för att beräkna fibonacci iterativt.
     * Det här är ett exempel på dynamisk programmering.
     * @param n Det tal i fibonaccisekvensen som vi vill beräkna
     * @return Det beräknade talet
     */
    public static long fib(int n)
    {
        if (n <= 1) return n;

        //Fibonaccisekvensen: 0, 1, 1, 2, 3, 5, 8, 13, 21... osv
        //Vi initialiserar n1 och n2 så att de innehåller de första två talen för sekvensen
        long n1 = 0;
        long n2 = 1;
        long sum = 0;

        for(int i = 2; i <= n; i++)
        {
            counter++;

            sum = n2 + n1;
            n1 = n2;
            n2 = sum;
        }

        return sum;
    }
}
