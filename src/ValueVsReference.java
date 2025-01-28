import java.util.Arrays;

public class ValueVsReference
{
    public static void main(String[] args)
    {
        int number = 100;
        System.out.println("Värdet i variabeln number innan den skickats som värde till passByValue(): " + number);
        passByValue(number);
        System.out.println("Värdet i variabeln number efter den skickats som värde till passByValue(): " + number +"\n");

        int[] array = {50, 2, 35, 4, 6, 1, 99, 45, 53, 97, 5, 8};
        System.out.println("Ordningen på arrayen innan den skickats som referens till passByReference(): ");
        for (int j : array)
            System.out.print(j + ", ");

        passByReference(array);

        System.out.println("\nOrdningen på arrayen efter den skickats som referens till passByReference(): ");
        for (int j : array)
            System.out.print(j + ", ");
    }

    //Metoden ändrar inte värdet på number i main() eftersom värdet (100) i number kopieras och skickas hit
    public static void passByValue(int number)
    {
        number = number * 2;
        System.out.println("Den lokala variabeln number i metoden passByValue() har nu värdet " + number);
    }

    //Metoden sorterar arrayen i main() utan att behöva returnera någonting igen eftersom den tar in en referens
    public static void passByReference(int[] array)
    {
        Arrays.sort(array);
    }

}
