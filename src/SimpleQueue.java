import java.util.LinkedList;

public class SimpleQueue<Type>
{
    private final LinkedList<Type> queue;

    public SimpleQueue()
    {
        queue = new LinkedList<>();
    }

    public void enQueue(Type value)
    {
        queue.offer(value);
    }

    public void deQueue()
    {
        if(queue.isEmpty())
            System.out.println("Queue is empty!");
        else
            queue.remove();
    }

    public boolean isEmpty()
    {
        return queue.isEmpty();
    }
}
