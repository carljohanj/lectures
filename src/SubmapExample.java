import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

public class SubmapExample
{
    //Trädkarta som vi vill hämta en subMap från:
    private static final TreeMap<Integer, String> tree = new TreeMap<>();
    //Array med strängar som kan paras ihop slumpmässigt med nycklarna i trädet:
    private static final String[] fruits = {"Apple", "Banana", "Cherry", "Strawberry",
                                            "Grapes", "Orange", "Lemon"};
    //Random-objekt för att kunna slumpa fram strängar:
    private static final Random random = new Random();


    public static void main(String[] args)
    {
        //Fyller trädet med en miljon nyckel-värde-par:
        fillMapRandomly(1000000);
        final var subTree = getSubset(500000, 500100);  //O(1), eftersom vi sparar en SortedMap i stället
                                                        //för att skapa ett helt nytt träd
        for(Map.Entry<Integer, String> entry : subTree.entrySet())  //O(k), där k är vårt subset av n
        {
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
        }

        int searchKey = 500700;
        boolean containsKey = subTree.containsKey(searchKey);  //O(log k), där k är vårt subset av n
        System.out.println("\nSearching... key: " + searchKey + " exists: " + containsKey);
    }

    //Metoden är O(1) eftersom vi bara returnerar en vy i form av en SortedMap:
    private static SortedMap<Integer, String> getSubset(int fromKey, int toKey)
    {
        return tree.subMap(fromKey, toKey);
    }

    //Hjälpmetod för att fylla trädet med nycklar och värden:
    private static void fillMapRandomly(int n)
    {
        for(int i = 0; i < n; i++)
        {
            String randomWord = fruits[random.nextInt(fruits.length)];
            tree.put(i, randomWord);
        }
    }
}
