
public class GreedyCoinChange
{
    public static void main(String[] args)
    {
        final int[] coinValues = {10, 5, 1};
        int amount = 35;
        calculateChange(coinValues, amount);
    }

    private static void calculateChange(int[] coins, int amount)
    {
        int count = 0;
        System.out.println("Coins used to get to " + amount + ": ");
        for (int coin : coins)
        {
            while (amount >= coin)  //Medan summan är större eller lika med värdet på det aktuella myntet...
            {
                amount -= coin;   //... subtraherar vi värdet från summan som är kvar
                System.out.print(coin + ", ");
                count++;
            }
        }
        System.out.println("\nTotal coins used: " + count);
    }
}
