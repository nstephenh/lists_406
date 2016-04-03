import java.util.Iterator;

public class AList<E>
{
    /**
     * @param newItem new item to be added to the end
     * @return true
     * of the list.
     */
    public boolean add(E newItem)
    {
        return false;
    }
    /**
     * @param k The index at which the new item is
     * to be inserted
     * @param newItem new item to be added to the end
     * of the list.
     */
    public void add(int k, E newItem)
    {
    }
    /**
     * @param k the index
     * @throws IndexOutOfBoundsException if a nonexistent index
     * is passed to this method
     * @return the item at index k  in this list.
     */
    public E get(int k)
    {
        return null;
    }
    /**
     * This method sets the item at index k to have value newValue.
     * @param k an index
     * @return the object evicted in this process
     * @throws IndexOutOfBoundsException if a nonexistent index
     * is passed to this method
     * 
     */
    public E set(int k, E newValue)
    {
        return null;
    }
    /**
     * This rifles the list for the object <code>o</code>
     * @param o the item we are seeking
     * @return true if an object equal to <code> is</code>
     * found. Equality is established via <code>E</code>'s
     * <code>equals</code> method.
     */
    public boolean contains(Object o)
    {
        return false;
    }
    /**
     * This returns the number of items stored in this list.
     * @return the number of items in this list
     */
    public int size()
    {
        return -1;
    }
    /**
     * This creates a new list containing all entries starting
     * at <code>startIndex</code> and ending at <code>endIndex</code>.
     * @param startIndex the index our sublist starts with 
     * @param endIndex the index our sublist ends with 
     * @return the indicated sublist
     * @throws IndexOutOfBoundsException either index is out
     * of bounds.
     */
    public IList<E> subList(int startIndex, int endIndex) 
    {
        return null;
    }
    public Iterator<E> iterator()
    {
        return null;
    }
}
