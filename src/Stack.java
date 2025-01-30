import java.util.EmptyStackException;

/**
 * En generisk implementation av en stack med en underliggande array. Type innebär att klassen är en
 * template som inte har en fixerad datatyp förrän den anropas. Vid instansiering av ett stackobjekt
 * anger man vad man vill att den ska lagra för datatyp, precis som man gör med en ArrayList och liknande
 * datastrukturer.
 * <br><br>
 * Exempel:
 * <br>
 * {@code Stack<Integer> stack = new Stack<>();}
 * <br><br>
 * där Integer ersätter Type. Funkar även med Double, Long, String, osv...
 * @param <Type> Datatypen som stacken ska hantera.
 *
 */
public class Stack<Type>
{
    Type[] stack;
    int topOfStack;
    int size;

    public Stack(int size)
    {
        stack = (Type[]) new Object[size];
        topOfStack = -1;
        this.size = size;
    }

    public Type peek()
    {
        if (topOfStack == -1) throw new EmptyStackException();

        return stack[topOfStack];
    }

    public void pop()
    {
        if (topOfStack == -1) throw new EmptyStackException();

        topOfStack--;
    }

    public void push(Type value)
    {
        if (topOfStack == size - 1) throw new StackOverflowError("The stack is full");

        topOfStack++;
        stack[topOfStack] = value;
    }

    public boolean isEmpty()
    {
        return topOfStack == -1;
    }
}
