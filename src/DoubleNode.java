public class DoubleNode
{
    int data;
    DoubleNode previousNode;
    DoubleNode nextNode;

    DoubleNode(int data)
    {
        this.data = data;
        previousNode = null;
        nextNode = null;
    }

    void setPreviousNode(DoubleNode previousNode)
    {
        this.previousNode = previousNode;
    }

    void setNextNode(DoubleNode nextNode)
    {
        this.nextNode = nextNode;
    }

}
