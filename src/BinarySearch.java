public class BinarySearch
{
    public static int counter = 0;

    public static void main(String[] args)
    {
        int[] numberArray = new int[10000000];
        fillArrayWithNumbers(numberArray);
        int targetValue = 2575000;

        int result = binarySearch(numberArray, targetValue, 0,numberArray.length -1);

        System.out.println("Värdet hittades på plats " + result + " i arrayen!");
        System.out.println("Antal sökningar i array med " + numberArray.length + " värden för att " +
                               "hitta rätt nummer: " + counter);
    }


    public static int binarySearch(int[] array, int target, int beginning, int end)
    {
        counter++;

        //if (beginning > end) { return -1; }

        int middle = (beginning + end) / 2;

        if (target == array[middle]) { return middle; }

        if(target > array[middle])
        {
            int newBeginning = middle + 1;
            return binarySearch(array, target, newBeginning, end);
        }

        //else: target < array[middle]
        int newEnd = middle - 1;
        return binarySearch(array, target, beginning, newEnd);
    }

    public static void fillArrayWithNumbers(int[] array)
    {
        for(int i = 0; i < array.length-1; i++)
        {
            array[i] = i * 5;
        }
    }
}