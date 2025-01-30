/**
 * Generisk klass som kan lagra alla sorters objekt
 * Vi har ersatt datatypen med en generisk typ "Type"
 * @param <Type> datatypen som bestäms vid instansiering
 */
public class Box<Type>
{
    private Type item;

    public Box(Type item)
    {
        this.item = item;
    }

    public Type getItem()
    {
        return this.item;
    }
}