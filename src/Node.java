/**
 * En rekursiv klass som t.ex kan användas för att bygga en länkad lista.
 * Notera att Node innehåller en instans av sig själv. När vi skapar en ny
 * länk i listan är det den här noden som vi länkar den samman med.
 */
public class Node<Type>
{
    Type data;
    Node<Type> node;

    public Node(Type data)
    {
        this.data = data;
        this.node = null;
    }
}