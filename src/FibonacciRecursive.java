import java.util.Scanner;

public class FibonacciRecursive
{
    public static int counter = 0;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = -1;
        while(n < 0)
        {
            System.out.println("Vilket tal i fibonaccisekvensen vill du beräkna?");
            n = scanner.nextInt();
        }

        System.out.println("Det " + n + " fibonaccitalet är " + fib(n));
        System.out.println("Antal metodanrop för att beräkna numret: " + counter);
    }

    /**
     * I fibonaccisekvensen beräknas varje nytt tal utifrån de två föregående.
     * Algoritmen börjar från toppen och arbetar nedåt genom att göra nya anropskedjor ända tills basfallet nås.
     * Om inte basfallet uppnås vill vi därför göra två nya anrop för att beräkna föregående tal.
     * När en anropskedja nått basfallet kommer den börja returnera beräkningar
     *
     * @param n Det fibonaccital vi vill beräkna
     * @return n om basfallet är nått, annars två nya anrop till sig själv
     */
    public static long fib(int n)
    {
        counter++;

        if (n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }
}
