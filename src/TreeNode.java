/**
 * Ännu ett exempel på en rekursiv datastruktur - den här gången en nod för ett träd
 * som innehåller två stycken instanser av sig självt. Vi kan använda den här för att
 * bygga ett binärt träd. Skillnaden mellan en TreeNode och en Node i en LinkedList är
 * att varje TreeNode har en vänster- och en högernod:
 *
 *               (Huvudvärde)
 *              /            \
 *        (leftNode)      (rightNode)
 *        /        \      /         \
 *
 */
public class TreeNode
{
    int value;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(int value)
    {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }
}