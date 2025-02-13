

public class BinaryTree
{
    private TreeNode root;

    public void insert(int value)
    {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value)
    {
        //Antingen skapar vi en ny nod ifall rotnoden är null och lägger in värdet där:
        if (node == null) {
            System.out.println("Creating a new node for value " + value);
            return new TreeNode(value);
        }
        //Om rotnoden inte är null kollar vi om värdet är mindre än det i rotnoden, och
        //gör i så fall ett rekursivt anrop som lägger in värdet i den vänstra undernoden:
        if (value < node.value) {
            System.out.println("Going to the left in the tree");
            node.left = insertRecursive(node.left, value);
        }
        //Om värdet är större än det i rotnoden gör vi ett rekursivt anrop och lägger in
        //värdet i den högra undernoden i stället:
        else if (value > node.value) {
            System.out.println("Going to the right in the tree");
            node.right = insertRecursive(node.right, value);
        }

        return node;
    }
}