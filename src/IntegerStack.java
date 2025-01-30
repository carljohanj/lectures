import java.util.EmptyStackException;

/**
 * A stack implementation that only stores integers.
 */
public class IntegerStack
{
    private final int DEFAULT_CAPACITY = 1000;
    private int[] stack;
    private int topOfStack;
    private int size;

    // Default constructor: Initializes the stack with default capacity
    public IntegerStack()
    {
        this.size = DEFAULT_CAPACITY;
        this.stack = new int[size];
        this.topOfStack = -1;
    }

    // Constructor that allows custom size initialization
    public IntegerStack(int size)
    {
        this.size = size;
        this.stack = new int[size];
        this.topOfStack = -1;
    }

    // Returns the top element without removing it
    public int peek()
    {
        if (topOfStack == -1)
        {
            throw new EmptyStackException();
        }
        return stack[topOfStack];
    }

    // Removes the top element
    public void pop()
    {
        if (topOfStack == -1)
        {
            throw new EmptyStackException();
        }
        topOfStack--;
    }

    // Pushes a new integer onto the stack
    public void push(int value)
    {
        if (topOfStack == size - 1)
        {
            throw new StackOverflowError("The stack is full");
        }
        topOfStack++;
        stack[topOfStack] = value;
    }

    // Checks if the stack is empty
    public boolean isEmpty()
    {
        return topOfStack == -1;
    }
}
