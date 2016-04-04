import java.util.Iterator;

public class AList<E> implements IList<E>
{
    private Object[] items;
    private int capacity;
    private int sz;
    public AList()
    {
        this(10);
    }
    public AList(int capacity)
    {
        this.capacity = capacity;
        sz = 0;
        items = new Object[capacity];
    }
    /**
     * @param newItem new item to be added to the end
     * of the list.
     */
    public void add(E newItem) {
        if (sz >= capacity){
            resizeArray();
        }
        items[sz] = newItem;
        sz++;

    }
    /**
     * @param k The index at which the new item is
     * to be inserted
     * @param newItem new item to be added at k
     */
    public void add(int k, E newItem)
    {
        if (k >= capacity){
            resizeArray();
        }
        shiftArray(1, k); //Includes sz ++
        items[k] = newItem;


    }
    /**
     * @param k the index
     * @throws IndexOutOfBoundsException if a nonexistent index
     * is passed to this method
     * @return the item at index k  in this list.
     */
    public E get(int k)
    {
        return (E) items[k];
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
        Object oldValue =  items[k];
        items[k] = newValue;
        return (E) oldValue;
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
        int i = 0;
        while (i <= items.length){
            if (items[i].equals(o)){
                return true;
            }
        }
        return false;
    }
    /**
     * This returns the number of items stored in this list.
     * @return the number of items in this list
     */
    public int size()
    {
        return items.length;
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
        IList<E> newList = new AList<>(endIndex-startIndex);
        int i = 0;
        while (i <= endIndex-startIndex){
            newList.add((E) items[i+startIndex]);
        }
        return newList;
    }
    public Iterator<E> iterator()
    {
        return null;
    }

    //Functions borrowed from AStack

    private int resizePolicy(int oldSize) {
        return oldSize < 1000? 2*oldSize: 3*oldSize/2;
    }

    private void resizeArray() {
        //make a bigger array using the resize policy to size it
        Object[] newHouse = new Object[resizePolicy(items.length)];
        //move contents of old array in
        System.arraycopy(items, 0, newHouse, 0, items.length);
        //orphan old array

        items = newHouse;
        capacity = newHouse.length;
    }
    // This one is all mine (not from AStack)
    /**
     * This shifts all values in the array around for adding and deleting
     * @param shift how much to shift
     * @param pos the position in the array to shift at
     * @throws IndexOutOfBoundsException if pos < |shift|  and pos < 0 because you
     * would end up with a negative index and ain't nobody got time for that.
     */
    private void shiftArray(int shift, int pos){
        if (pos-shift < 0){ throw new IndexOutOfBoundsException();}
        if (items.length + shift > capacity){
            resizeArray();
        }
        if (shift > 0){
            int i = items.length;
            while (i > pos) {
                // Shift values over starting at the back so you don't overwrite something
                items[i + shift] = items[i];
            }
        }else{
            int i = pos;
            while (i < items.length) {
                // Shift values over starting at pos so you don't overwrite something
                items[i + shift] = items[i];
            }
        }
        sz += shift;
        
    }
}
